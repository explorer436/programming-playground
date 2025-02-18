package db

import (
	"context"

	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"go.mongodb.org/mongo-driver/mongo/options"
	"time"
)

type Post struct {
	ID        primitive.ObjectID `bson:"_id,omitempty"`
	Title     string             `bson:"title"`
	Content   string             `bson:"content"`
	CreatedAt time.Time          `bson:"createdAt"`
	UpdatedAt time.Time          `bson:"updatedAt"`
}

func (db *DB) CreatePost(title, content string) (*Post, error) {
	post := &Post{
		Title:     title,
		Content:   content,
		CreatedAt: time.Now(),
		UpdatedAt: time.Now(),
	}

	result, err := db.posts.InsertOne(context.Background(), post)
	if err != nil {
		return nil, err
	}

	post.ID = result.InsertedID.(primitive.ObjectID)
	return post, nil
}

func (db *DB) GetPost(id string) (*Post, error) {
	objectID, err := primitive.ObjectIDFromHex(id)
	if err != nil {
		return nil, err
	}

	var post Post
	err = db.posts.FindOne(context.Background(), bson.M{"_id": objectID}).Decode(&post)
	if err != nil {
		return nil, err
	}

	return &post, nil
}

func (db *DB) UpdatePost(id, title, content string) (*Post, error) {
	objectID, err := primitive.ObjectIDFromHex(id)
	if err != nil {
		return nil, err
	}

	update := bson.M{
		"$set": bson.M{
			"title":     title,
			"content":   content,
			"updatedAt": time.Now(),
		},
	}

	var post Post
	err = db.posts.FindOneAndUpdate(
		context.Background(),
		bson.M{"_id": objectID},
		update,
		options.FindOneAndUpdate().SetReturnDocument(options.After),
	).Decode(&post)

	if err != nil {
		return nil, err
	}

	return &post, nil
}

func (db *DB) DeletePost(id string) error {
	objectID, err := primitive.ObjectIDFromHex(id)
	if err != nil {
		return err
	}

	_, err = db.posts.DeleteOne(context.Background(), bson.M{"_id": objectID})
	return err
}

func (db *DB) ListPosts() ([]*Post, error) {
	cursor, err := db.posts.Find(context.Background(), bson.M{})
	if err != nil {
		return nil, err
	}
	defer cursor.Close(context.Background())

	var posts []*Post
	for cursor.Next(context.Background()) {
		var post Post
		if err := cursor.Decode(&post); err != nil {
			return nil, err
		}
		posts = append(posts, &post)
	}

	return posts, nil
}
