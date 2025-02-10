package main

import (
	"example.com/generate-gin-code-from-spec/api"
	"example.com/generate-gin-code-from-spec/handlers"
	"github.com/gin-gonic/gin"
)

func main() {
	router := gin.Default()

	// Initialize the handlers written in NewMyAlbumAPI
	blogAPI := handlers.NewMyAlbumAPI()

	api.RegisterHandlers(router, blogAPI)

	router.Run("localhost:8080")
}
