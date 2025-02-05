package mydatastructures

func TreeHeight(bst BinarySearchTree) int {
	if bst == (BinarySearchTree{}) {
		return -1
	}
	if bst.Left == nil && bst.Right == nil {
		return 0
	}
	if bst.Left == nil && bst.Right != nil {
		return 1 + TreeHeight(*bst.Right)
	}
	if bst.Left != nil && bst.Right == nil {
		return 1 + TreeHeight(*bst.Left)
	}

	a := 1 + TreeHeight(*bst.Right)
	b := 1 + TreeHeight(*bst.Left)
	if a > b {
		return a
	}
	return b

}
