package mydatastructures

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

func InsertInBinarySearchTree(x int) BinarySearchTree {

}

// https://go.dev/tour/concurrency/7
// https://go.dev/tour/concurrency/8
