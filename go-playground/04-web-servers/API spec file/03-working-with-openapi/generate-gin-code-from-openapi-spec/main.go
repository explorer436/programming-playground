package main

import (
	"example.com/generate-gin-code-from-spec/api"
	"example.com/generate-gin-code-from-spec/handlers"
	"github.com/gin-gonic/gin"
)

func main() {
	router := gin.Default()

	// Initialize the BlogAPI handlers
	blogAPI := handlers.NewBlogAPI()

	api.RegisterHandlers(router, blogAPI)

	router.Run("localhost:8080")
}
