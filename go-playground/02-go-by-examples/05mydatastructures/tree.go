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

type BinarySearchNode struct {
	Value int
	Left  *BinarySearchTree
	Right *BinarySearchTree
}

type BinarySearchTree struct {
	Value int
	Left  *BinarySearchTree
	Right *BinarySearchTree
}

func InsertInBinarySearchTree(x int, bst BinarySearchTree) BinarySearchTree {
	if bst == (BinarySearchTree{}) {
		return BinarySearchTree{
			Value: x,
		}
	}
	if bst.Value == x {
		// It is a duplicate.
		// We don't want to support duplicates. So, don't do anything.
		return bst
	}
	if x < bst.Value {
		var newLeft BinarySearchTree
		if bst.Left == nil {
			newLeft = InsertInBinarySearchTree(x, BinarySearchTree{})

		} else {
			newLeft = InsertInBinarySearchTree(x, *bst.Left)
		}
		return BinarySearchTree{
			Value: bst.Value,
			Left:  &newLeft,
			Right: bst.Right,
		}
	}
	if x > bst.Value {
		var newRight BinarySearchTree
		if bst.Right == nil {
			newRight = InsertInBinarySearchTree(x, BinarySearchTree{})
		} else {
			newRight = InsertInBinarySearchTree(x, *bst.Right)
		}
		return BinarySearchTree{
			Value: bst.Value,
			Left:  bst.Left,
			Right: &newRight,
		}
	}
	return BinarySearchTree{}
}

// https://go.dev/tour/concurrency/7
// https://go.dev/tour/concurrency/8
