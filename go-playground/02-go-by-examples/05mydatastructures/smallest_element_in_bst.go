package mydatastructures

func SmallestElementInBinarySearchTree(bst BinarySearchTree) int {
	if bst == (BinarySearchTree{}) {
		return 0
	}
	if bst.Left == nil {
		return bst.Value
	}
	return SmallestElementInBinarySearchTree(*bst.Left)
}
