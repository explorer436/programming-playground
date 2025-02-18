package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	middleware "github.com/oapi-codegen/gin-middleware"
	"go.opentelemetry.io/contrib/instrumentation/github.com/gin-gonic/gin/otelgin"
	"myexample.com/generate-gin-server-code-from-openapi-spec/api"
	"myexample.com/generate-gin-server-code-from-openapi-spec/serverinterface"
	"os"
)

func main() {
	router := gin.Default()

	// Initialize the serverinterface written in NewMyAlbumAPI
	blogAPI := serverinterface.NewMyAPI()

	/*swagger, err := api.GetSwagger()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error loading swagger spec\n: %s", err)
		os.Exit(1)
	}
	// Request validation
	router.Use(middleware.OapiRequestValidator(swagger))*/

	middlewares := []api.MiddlewareFunc{requestValidationMiddleware(), middleware1(), middleware2()}
	api.RegisterHandlersWithOptions(router, blogAPI, api.GinServerOptions{
		BaseURL:      "my-custom-basepath",
		Middlewares:  middlewares,
		ErrorHandler: nil,
	})

	router.Run("localhost:8080")
}

func requestValidationMiddleware() api.MiddlewareFunc {
	// Request validation
	swagger, err := api.GetSwagger()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error loading swagger spec\n: %s", err)
		os.Exit(1)
	}

	return api.MiddlewareFunc(middleware.OapiRequestValidator(swagger))
}

func middleware1() api.MiddlewareFunc {
	return func(c *gin.Context) {
		c.Writer.Header().Set("Access-Control-Allow-Origin", "*")
		c.Writer.Header().Set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE")
		c.Writer.Header().Set("Access-Control-Allow-Headers", "Content-Type, Authorization")
		if c.Request.Method == "OPTIONS" {
			c.AbortWithStatus(204)
			return
		}
		c.Next()
	}
}

func middleware2() api.MiddlewareFunc {
	return func(c *gin.Context) {
		otelgin.Middleware("generate-gin-server-code-from-openapi-spec") // Name of the service
	}
}
