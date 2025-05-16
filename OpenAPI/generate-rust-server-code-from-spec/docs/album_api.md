# album_api

All URIs are relative to *http://localhost:8080/my-custom-basepath*

Method | HTTP request | Description
------------- | ------------- | -------------
**getAlbums**](album_api.md#getAlbums) | **GET** /albums | Get Albums
**postAlbums**](album_api.md#postAlbums) | **POST** /albums | Post Albums
**getAlbumByID**](album_api.md#getAlbumByID) | **GET** /albums/{id} | Get Album By ID


# **getAlbums**
> Vec<models::Album> getAlbums()
Get Albums

### Required Parameters
This endpoint does not need any parameter.

### Return type

[**Vec<models::Album>**](Album.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **postAlbums**
> models::Album postAlbums(optional)
Post Albums

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **optional** | **map[string]interface{}** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a map[string]interface{}.

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **album** | [**Album**](Album.md)|  | 

### Return type

[**models::Album**](Album.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAlbumByID**
> models::Album getAlbumByID(id)
Get Album By ID

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
  **id** | **i32**|  | 

### Return type

[**models::Album**](Album.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

