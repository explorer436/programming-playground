package main

import (
	"context"
	"encoding/json"
	"github.com/aws/aws-lambda-go/events"
	"github.com/aws/aws-lambda-go/lambda"
	"log"
)

func main() {
	lambda.Start(helloWorldHandler)
}

func helloWorldHandler(ctx context.Context, req events.APIGatewayProxyRequest) (events.APIGatewayProxyResponse, error) {
	log.Println("Function invoked")

	marshaledReq, _ := json.Marshal(req)
	log.Println("marshaledReq :", string(marshaledReq))

	p := req.Path
	log.Println("Path to the function that is invoked is :", p)

	return events.APIGatewayProxyResponse{
		Body:       "Hello, World!",
		StatusCode: 200,
	}, nil
}
