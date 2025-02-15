package handlers

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/yourusername/blog-api/api"
	"github.com/yourusername/blog-api/db"
)

type BlogAPI struct {
	db *db.DB
}

func NewBlogAPI(db *db.DB) *BlogAPI {
	return &BlogAPI{db: db}
}

func (b *BlogAPI) GetPosts(c *gin.Context) {
	posts, err := b.db.ListPosts()
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}

	apiPosts := make([]api.Post, len(posts))
	for i, post := range posts {
		hex := post.ID.Hex()
		title := post.Title
		content := post.Content
		createdAt := post.CreatedAt
		updatedAt := post.UpdatedAt

		apiPosts[i] = api.Post{
			Id:        &hex,
			Title:     &title,
			Content:   &content,
			CreatedAt: &createdAt,
			UpdatedAt: &updatedAt,
		}
	}

	c.JSON(http.StatusOK, apiPosts)
}

func (b *BlogAPI) PostPosts(c *gin.Context) {
	var newPost api.NewPost
	if err := c.ShouldBindJSON(&newPost); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	post, err := b.db.CreatePost(newPost.Title, newPost.Content)
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}

	hex := post.ID.Hex()
	title := post.Title
	content := post.Content
	createdAt := post.CreatedAt
	updatedAt := post.UpdatedAt

	c.JSON(http.StatusCreated, api.Post{
		Id:        &hex,
		Title:     &title,
		Content:   &content,
		CreatedAt: &createdAt,
		UpdatedAt: &updatedAt,
	})
}

func (b *BlogAPI) DeletePostsId(c *gin.Context, id string) {
	err := b.db.DeletePost(id)
	if err != nil {
		c.JSON(http.StatusNotFound, gin.H{"error": "Post not found"})
		return
	}

	c.Status(http.StatusNoContent)
}

func (b *BlogAPI) GetPostsId(c *gin.Context, id string) {
	post, err := b.db.GetPost(id)
	if err != nil {
		c.JSON(http.StatusNotFound, gin.H{"error": "Post not found"})
		return
	}

	hex := post.ID.Hex()
	title := post.Title
	content := post.Content
	createdAt := post.CreatedAt
	updatedAt := post.UpdatedAt

	c.JSON(http.StatusOK, api.Post{
		Id:        &hex,
		Title:     &title,
		Content:   &content,
		CreatedAt: &createdAt,
		UpdatedAt: &updatedAt,
	})
}

func (b *BlogAPI) PutPostsId(c *gin.Context, id string) {
	var updatePost api.NewPost
	if err := c.ShouldBindJSON(&updatePost); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	post, err := b.db.UpdatePost(id, updatePost.Title, updatePost.Content)
	if err != nil {
		c.JSON(http.StatusNotFound, gin.H{"error": "Post not found"})
		return
	}

	hex := post.ID.Hex()
	title := post.Title
	content := post.Content
	createdAt := post.CreatedAt
	updatedAt := post.UpdatedAt

	c.JSON(http.StatusOK, api.Post{
		Id:        &hex,
		Title:     &title,
		Content:   &content,
		CreatedAt: &createdAt,
		UpdatedAt: &updatedAt,
	})
}
