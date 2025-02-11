package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	middleware "github.com/oapi-codegen/gin-middleware"
	"myexample.com/generate-gin-server-code-from-openapi-spec/api"
	"myexample.com/generate-gin-server-code-from-openapi-spec/serverinterface"
	"os"
)

func main() {
	router := gin.Default()

	// Initialize the serverinterface written in NewMyAlbumAPI
	blogAPI := serverinterface.NewMyAPI()

	// Request validation
	swagger, err := api.GetSwagger()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error loading swagger spec\n: %s", err)
		os.Exit(1)
	}
	router.Use(middleware.OapiRequestValidator(swagger))

	api.RegisterHandlers(router, blogAPI)

	router.Run("localhost:8080")
}
