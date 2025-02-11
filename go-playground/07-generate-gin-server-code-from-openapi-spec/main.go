package main

import (
	"github.com/gin-gonic/gin"
	"myexample.com/generate-gin-server-code-from-openapi-spec/api"
	"myexample.com/generate-gin-server-code-from-openapi-spec/handlers"
)

func main() {
	router := gin.Default()

	// Initialize the handlers written in NewMyAlbumAPI
	blogAPI := handlers.NewMyAlbumAPI()

	api.RegisterHandlers(router, blogAPI)

	router.Run("localhost:8080")
}
