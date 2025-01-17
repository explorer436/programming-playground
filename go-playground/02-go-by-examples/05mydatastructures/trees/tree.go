package mydatastructures

/*
Alternatives:
Run "go get golang.org/x/tour/tree" - which will add it to go.mod
import "golang.org/x/tour/tree"
to use https://pkg.go.dev/golang.org/x/tour/tree#Tree
*/

type Tree struct {
	data int
	next *Tree
}

type BinaryTree struct {
	Value int
	Left  *BinaryTree
	Right *BinaryTree
}

type BinarySearchTree struct {
	Value int
	Left  *BinarySearchTree
	Right *BinarySearchTree
}

// https://go.dev/tour/concurrency/7
// https://go.dev/tour/concurrency/8
