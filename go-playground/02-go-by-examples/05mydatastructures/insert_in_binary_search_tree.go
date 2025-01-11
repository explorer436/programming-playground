package mydatastructures

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
