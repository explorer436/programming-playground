package serverinterface

import (
	"github.com/gin-gonic/gin"
	"myexample.com/generate-gin-server-code-from-openapi-spec/api"
	"net/http"
	"strconv"
)

var artist1 = "John Coltrane"
var artist2 = "Gerry Mulligan"
var artist3 = "Sarah Vaughan"

var price1 float32 = 56.99
var price2 float32 = 17.99
var price3 float32 = 39.99

// albums slice to seed record album data.
var albums = []api.Album{
	{Id: "1", Title: "Blue Train", Artist: &artist1, Price: &price1},
	{Id: "2", Title: "Jeru", Artist: &artist2, Price: &price2},
	{Id: "3", Title: "Sarah Vaughan and Clifford Brown", Artist: &artist3, Price: &price3},
}

func (b *MyAPI) GetAlbums(c *gin.Context) {
	c.IndentedJSON(http.StatusOK, albums)
}

func (b *MyAPI) PostAlbums(c *gin.Context) {
	var newAlbum api.Album

	// Call BindJSON to bind the received JSON to
	// newAlbum.
	if err := c.BindJSON(&newAlbum); err != nil {
		return
	}

	// Add the new album to the slice.
	albums = append(albums, newAlbum)
	c.IndentedJSON(http.StatusCreated, newAlbum)
}

func (b *MyAPI) GetAlbumByID(c *gin.Context, id int) {

	// Loop over the list of albums, looking for
	// an album whose ID value matches the parameter.
	for _, a := range albums {
		if a.Id == strconv.Itoa(id) {
			c.IndentedJSON(http.StatusOK, a)
			return
		}
	}
	c.IndentedJSON(http.StatusNotFound, gin.H{"message": "album not found"})
}
