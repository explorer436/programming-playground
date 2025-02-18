package main

import (
	"log"

	"github.com/gin-gonic/gin"
	"github.com/yourusername/blog-api/api"
	"github.com/yourusername/blog-api/db"
	"github.com/yourusername/blog-api/handlers"
)

func main() {

	// Create a new Gin router
	router := gin.Default()

	// Initialize database
	database := db.InitDb()

	// Initialize the BlogAPI handlers
	blogAPI := handlers.NewBlogAPI(database)

	// Register the API routes
	api.RegisterHandlers(router, blogAPI)

	// Start the server
	log.Println("Starting server on :8080")
	if err := router.Run(":8080"); err != nil {
		log.Fatalf("Failed to start server: %v", err)
	}
}
