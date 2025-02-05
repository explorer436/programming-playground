package mydatastructures

func TreeSize(bst BinarySearchTree) int {
	if bst == (BinarySearchTree{}) {
		return 0
	}
	if bst.Left == nil && bst.Right == nil {
		return 1
	}
	if bst.Left == nil && bst.Right != nil {
		return 1 + TreeSize(*bst.Right)
	}
	if bst.Left != nil && bst.Right == nil {
		return 1 + TreeSize(*bst.Left)
	}
	return 1 + TreeSize(*bst.Left) + TreeSize(*bst.Right)
}
