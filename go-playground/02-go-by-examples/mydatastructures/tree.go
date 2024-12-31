package mydatastructures

type tree struct {
	root node
}

func InsertInTree(n int, input_tree tree) tree {
	var result tree

	// checking if the pointer is null.
	// If the pointer is null, the struct is null.
	if &input_tree == nil {
		// build a new tree
		a_new_node := node{data: n}
		result := tree{root: a_new_node}
		return result
	} else {
		// insert in existing tree
		InsertNode(n, &input_tree.root)
	}

	return result
}
