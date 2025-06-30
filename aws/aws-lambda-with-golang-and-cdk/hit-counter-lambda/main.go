package main

import (
	"context"
	"encoding/json"
	"fmt"
	"github.com/aws/aws-lambda-go/events"
	"github.com/aws/aws-lambda-go/lambda"
	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/dynamodb"
	sdklambda "github.com/aws/aws-sdk-go/service/lambda"
	"github.com/aws/jsii-runtime-go"
	"log"
	"os"
)

func main() {
	lambda.Start(hitCounterHandler)
}

func hitCounterHandler(ctx context.Context, req events.APIGatewayProxyRequest) (events.APIGatewayProxyResponse, error) {
	log.Println("Function invoked")

	marshaledReq, _ := json.Marshal(req)
	log.Println("marshaledReq :", string(marshaledReq))

	p := req.Path
	log.Println("Path to the function that is invoked is :", p)

	// Initialize a session that the SDK will use to load
	// credentials from the shared credentials file ~/.aws/credentials
	// and region from the shared configuration file ~/.aws/config.
	session := session.Must(session.NewSessionWithOptions(session.Options{
		SharedConfigState: session.SharedConfigEnable,
	}))

	// Create DynamoDB client
	dynamodbSvc := dynamodb.New(session)

	// Read an environment variable
	tableName := os.Getenv("HITS_TABLE_NAME")

	dynamoDbInput := &dynamodb.UpdateItemInput{
		TableName: jsii.String(tableName),
		Key: map[string]*dynamodb.AttributeValue{
			"path": {
				S: aws.String(p),
			},
		},
		UpdateExpression: aws.String("ADD hits :incr"),
		ExpressionAttributeValues: map[string]*dynamodb.AttributeValue{
			":incr": {
				N: aws.String("1"),
			},
		},
		ReturnValues: aws.String("UPDATED_NEW"),
	}

	_, err := dynamodbSvc.UpdateItem(dynamoDbInput)
	if err != nil {
		log.Fatalf("Got error calling UpdateItem: %s", err)
	}

	// TODO
	// call downstream lambda and capture response and send it back

	downstreamFunctionName := os.Getenv("DOWNSTREAM_FUNCTION_NAME")
	log.Println("downstreamFunctionName :", downstreamFunctionName)

	payload, err := json.Marshal(req)
	if err != nil {
		fmt.Println("Error marshalling request to hitCounterHandler")
	}

	// Create a lambda client
	lambdaClient := sdklambda.New(session)

	input := &sdklambda.InvokeInput{
		FunctionName: aws.String(downstreamFunctionName),
		Payload:      payload,
	}

	result, err := lambdaClient.Invoke(input)
	if err != nil {
		// Handle invocation error
	}
	log.Println("result from downstream lambda : ", result)

	return events.APIGatewayProxyResponse{
		Body:       string(result.Payload),
		StatusCode: 200,
	}, nil
}
