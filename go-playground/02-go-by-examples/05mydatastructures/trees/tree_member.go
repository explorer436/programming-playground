package mydatastructures

func TreeMember(bst BinarySearchTree, x int) bool {
	if bst == (BinarySearchTree{}) {
		return false
	}
	if bst.Value == x {
		return true
	} else {
		if bst.Left == nil && bst.Right != nil {
			return TreeMember(*bst.Right, x)
		}
		if bst.Left != nil && bst.Right == nil {
			return TreeMember(*bst.Left, x)
		}
		if bst.Left != nil && bst.Right != nil {
			a := TreeMember(*bst.Right, x)
			b := TreeMember(*bst.Left, x)
			return a || b
		}
	}

	return false
}
