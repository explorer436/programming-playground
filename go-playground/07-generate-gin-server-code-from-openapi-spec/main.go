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

    // The middleware calls have to be before we register the Handlers.
    // If not, the front end apps are not receiving CORS headers in the response.
    // So the UI apps will not work.
	router.Use(accessControlMiddleware())
	router.Use(requestValidationMiddleware())
	router.Use(otelMiddleware())

	// Avoid passing middlewares as options into the api.
	// Just use router.Use()
	// I ran into errors where requests with OPTIONS method were returning 404 (instead of 204)
	// Requests with OPTIONS method but they need to be supported.
	// See https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/OPTIONS
	// middlewares := []api.MiddlewareFunc{requestValidationMiddleware(), accessControlMiddleware(), otelMiddleware()}
	api.RegisterHandlersWithOptions(router, blogAPI, api.GinServerOptions{
		BaseURL: "my-custom-basepath",
		// Middlewares:  middlewares,
		Middlewares:  nil,
		ErrorHandler: nil,
	})

	router.Run("localhost:8080")
}

func requestValidationMiddleware() gin.HandlerFunc {
	swagger, err := api.GetSwagger()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error loading swagger spec\n: %s", err)
		os.Exit(1)
	}
	return middleware.OapiRequestValidator(swagger)
}

/*func requestValidationMiddleware() api.MiddlewareFunc {
	// Request validation
	swagger, err := api.GetSwagger()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error loading swagger spec\n: %s", err)
		os.Exit(1)
	}

	return api.MiddlewareFunc(middleware.OapiRequestValidator(swagger))
}*/

/*
Why do we need this?
If these headers are not on the response, the React application will not be able to use the response returned from the backend.
*/
func accessControlMiddleware() func(c *gin.Context) {
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

/*func otelMiddleware() api.MiddlewareFunc {
	return func(c *gin.Context) {
		otelgin.Middleware("generate-gin-server-code-from-openapi-spec") // Name of the service
	}
}*/

func otelMiddleware() func(c *gin.Context) {
	return func(c *gin.Context) {
		otelgin.Middleware("generate-gin-server-code-from-openapi-spec") // Name of the service
	}
}
