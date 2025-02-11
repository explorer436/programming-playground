package main

import (
	"github.com/gin-gonic/gin"
	"myexample.com/generate-gin-server-code-from-openapi-spec/api"
	"myexample.com/generate-gin-server-code-from-openapi-spec/serverinterface"
)

func main() {
	router := gin.Default()

	// Initialize the serverinterface written in NewMyAlbumAPI
	blogAPI := serverinterface.NewMyAPI()

	api.RegisterHandlers(router, blogAPI)

	router.Run("localhost:8080")
}
