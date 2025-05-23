// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

/*
 * Albums API
 *
 * This service provides API to manage albums.
 *
 * API version: v1.0.0
 */

package openapi

import (
	"encoding/json"
	"net/http"
	"strings"

	"github.com/gorilla/mux"
)

// AlbumAPIController binds http requests to an api service and writes the service results to the http response
type AlbumAPIController struct {
	service AlbumAPIServicer
	errorHandler ErrorHandler
}

// AlbumAPIOption for how the controller is set up.
type AlbumAPIOption func(*AlbumAPIController)

// WithAlbumAPIErrorHandler inject ErrorHandler into controller
func WithAlbumAPIErrorHandler(h ErrorHandler) AlbumAPIOption {
	return func(c *AlbumAPIController) {
		c.errorHandler = h
	}
}

// NewAlbumAPIController creates a default api controller
func NewAlbumAPIController(s AlbumAPIServicer, opts ...AlbumAPIOption) *AlbumAPIController {
	controller := &AlbumAPIController{
		service:      s,
		errorHandler: DefaultErrorHandler,
	}

	for _, opt := range opts {
		opt(controller)
	}

	return controller
}

// Routes returns all the api routes for the AlbumAPIController
func (c *AlbumAPIController) Routes() Routes {
	return Routes{
		"GetAlbums": Route{
			strings.ToUpper("Get"),
			"/my-custom-basepath/albums",
			c.GetAlbums,
		},
		"PostAlbums": Route{
			strings.ToUpper("Post"),
			"/my-custom-basepath/albums",
			c.PostAlbums,
		},
		"GetAlbumByID": Route{
			strings.ToUpper("Get"),
			"/my-custom-basepath/albums/{id}",
			c.GetAlbumByID,
		},
	}
}

// GetAlbums - Get Albums
func (c *AlbumAPIController) GetAlbums(w http.ResponseWriter, r *http.Request) {
	result, err := c.service.GetAlbums(r.Context())
	// If an error occurred, encode the error with the status code
	if err != nil {
		c.errorHandler(w, r, err, &result)
		return
	}
	// If no error, encode the body and the result code
	_ = EncodeJSONResponse(result.Body, &result.Code, w)
}

// PostAlbums - Post Albums
func (c *AlbumAPIController) PostAlbums(w http.ResponseWriter, r *http.Request) {
	var albumParam Album
	d := json.NewDecoder(r.Body)
	d.DisallowUnknownFields()
	if err := d.Decode(&albumParam); err != nil && !errors.Is(err, io.EOF) {
		c.errorHandler(w, r, &ParsingError{Err: err}, nil)
		return
	}
	if err := AssertAlbumRequired(albumParam); err != nil {
		c.errorHandler(w, r, err, nil)
		return
	}
	if err := AssertAlbumConstraints(albumParam); err != nil {
		c.errorHandler(w, r, err, nil)
		return
	}
	result, err := c.service.PostAlbums(r.Context(), albumParam)
	// If an error occurred, encode the error with the status code
	if err != nil {
		c.errorHandler(w, r, err, &result)
		return
	}
	// If no error, encode the body and the result code
	_ = EncodeJSONResponse(result.Body, &result.Code, w)
}

// GetAlbumByID - Get Album By ID
func (c *AlbumAPIController) GetAlbumByID(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	idParam, err := parseNumericParameter[int32](
		params["id"],
		WithRequire[int32](parseInt32),
	)
	if err != nil {
		c.errorHandler(w, r, &ParsingError{Param: "id", Err: err}, nil)
		return
	}
	result, err := c.service.GetAlbumByID(r.Context(), idParam)
	// If an error occurred, encode the error with the status code
	if err != nil {
		c.errorHandler(w, r, err, &result)
		return
	}
	// If no error, encode the body and the result code
	_ = EncodeJSONResponse(result.Body, &result.Code, w)
}
