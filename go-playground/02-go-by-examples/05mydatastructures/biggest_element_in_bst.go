package mydatastructures

func BiggestElementInBinarySearchTree(bst BinarySearchTree) int {
	if bst == (BinarySearchTree{}) {
		return 0
	}
	if bst.Right == nil {
		return bst.Value
	}
	return BiggestElementInBinarySearchTree(*bst.Right)
}
