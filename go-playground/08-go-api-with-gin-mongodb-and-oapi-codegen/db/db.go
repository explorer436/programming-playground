package db

import (
	"context"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"log"
)

type DB struct {
	client *mongo.Client
	posts  *mongo.Collection
}

func InitDb() *DB {
	// Initialize the database connection
	database, err := NewDB("mongodb://localhost:27017")
	log.Printf("database: %v", database)
	if err != nil {
		log.Fatalf("Failed to connect to the database: %v", err)
	}
	/*defer func(database *DB) {
		err := database.Close()
		if err != nil {
			// error closing DB connection
		}
	}(database)*/
	return database
}

func NewDB(uri string) (*DB, error) {
	client, err := mongo.Connect(context.Background(), options.Client().ApplyURI(uri))
	if err != nil {
		log.Fatalf("Failed to connect to the database: %v", err)
		return nil, err
	}

	db := client.Database("blog")
	posts := db.Collection("posts")

	return &DB{
		client: client,
		posts:  posts,
	}, nil
}

func (db *DB) Close() error {
	return db.client.Disconnect(context.Background())
}
