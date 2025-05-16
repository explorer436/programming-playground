#![allow(missing_docs, trivial_casts, unused_variables, unused_mut, unused_imports, unused_extern_crates, unused_attributes, non_camel_case_types)]
#![allow(clippy::derive_partial_eq_without_eq, clippy::disallowed_names)]

use async_trait::async_trait;
use futures::Stream;
use std::error::Error;
use std::collections::BTreeSet;
use std::task::{Poll, Context};
use swagger::{ApiError, ContextWrapper};
use serde::{Serialize, Deserialize};
use crate::server::Authorization;


type ServiceError = Box<dyn Error + Send + Sync + 'static>;

pub const BASE_PATH: &str = "/my-custom-basepath";
pub const API_VERSION: &str = "v1.0.0";

mod auth;
pub use auth::{AuthenticationApi, Claims};


#[derive(Debug, PartialEq, Serialize, Deserialize)]
pub enum GetAlbumsResponse {
    /// OK
    OK
    (Vec<models::Album>)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum PostAlbumsResponse {
    /// Created
    Created
    (models::Album)
    ,
    /// Conflict
    Conflict
    (models::RestErrResponse)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum GetAlbumByIdResponse {
    /// OK
    OK
    (models::Album)
    ,
    /// Not Found
    NotFound
    (models::RestErrResponse)
}

/// API
#[async_trait]
#[allow(clippy::too_many_arguments, clippy::ptr_arg)]
pub trait Api<C: Send + Sync> {
    fn poll_ready(&self, _cx: &mut Context) -> Poll<Result<(), Box<dyn Error + Send + Sync + 'static>>> {
        Poll::Ready(Ok(()))
    }

    /// Get Albums
    async fn get_albums(
        &self,
        context: &C) -> Result<GetAlbumsResponse, ApiError>;

    /// Post Albums
    async fn post_albums(
        &self,
        album: Option<models::Album>,
        context: &C) -> Result<PostAlbumsResponse, ApiError>;

    /// Get Album By ID
    async fn get_album_by_id(
        &self,
        id: i32,
        context: &C) -> Result<GetAlbumByIdResponse, ApiError>;

}

/// API where `Context` isn't passed on every API call
#[async_trait]
#[allow(clippy::too_many_arguments, clippy::ptr_arg)]
pub trait ApiNoContext<C: Send + Sync> {

    fn poll_ready(&self, _cx: &mut Context) -> Poll<Result<(), Box<dyn Error + Send + Sync + 'static>>>;

    fn context(&self) -> &C;

    /// Get Albums
    async fn get_albums(
        &self,
        ) -> Result<GetAlbumsResponse, ApiError>;

    /// Post Albums
    async fn post_albums(
        &self,
        album: Option<models::Album>,
        ) -> Result<PostAlbumsResponse, ApiError>;

    /// Get Album By ID
    async fn get_album_by_id(
        &self,
        id: i32,
        ) -> Result<GetAlbumByIdResponse, ApiError>;

}

/// Trait to extend an API to make it easy to bind it to a context.
pub trait ContextWrapperExt<C: Send + Sync> where Self: Sized
{
    /// Binds this API to a context.
    fn with_context(self, context: C) -> ContextWrapper<Self, C>;
}

impl<T: Api<C> + Send + Sync, C: Clone + Send + Sync> ContextWrapperExt<C> for T {
    fn with_context(self: T, context: C) -> ContextWrapper<T, C> {
         ContextWrapper::<T, C>::new(self, context)
    }
}

#[async_trait]
impl<T: Api<C> + Send + Sync, C: Clone + Send + Sync> ApiNoContext<C> for ContextWrapper<T, C> {
    fn poll_ready(&self, cx: &mut Context) -> Poll<Result<(), ServiceError>> {
        self.api().poll_ready(cx)
    }

    fn context(&self) -> &C {
        ContextWrapper::context(self)
    }

    /// Get Albums
    async fn get_albums(
        &self,
        ) -> Result<GetAlbumsResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().get_albums(&context).await
    }

    /// Post Albums
    async fn post_albums(
        &self,
        album: Option<models::Album>,
        ) -> Result<PostAlbumsResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().post_albums(album, &context).await
    }

    /// Get Album By ID
    async fn get_album_by_id(
        &self,
        id: i32,
        ) -> Result<GetAlbumByIdResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().get_album_by_id(id, &context).await
    }

}


#[cfg(feature = "client")]
pub mod client;

// Re-export Client as a top-level name
#[cfg(feature = "client")]
pub use client::Client;

#[cfg(feature = "server")]
pub mod server;

// Re-export router() as a top-level name
#[cfg(feature = "server")]
pub use self::server::Service;

#[cfg(feature = "server")]
pub mod context;

pub mod models;

#[cfg(any(feature = "client", feature = "server"))]
pub(crate) mod header;
