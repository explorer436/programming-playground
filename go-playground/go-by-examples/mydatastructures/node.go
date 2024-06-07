package mydatastructures

type node struct {
	data                int
	left_child_pointer  *node
	right_child_pointer *node

	/**
	* We have to use pointers for recursive structures.
	* Otherwise the compiler has no way to figure out what the size of the Environment structure is.
	* A pointer's size is known, but how big is something that contains itself?
	* (And the inner struct contains itself as well, as does the inner inner struct, and so on.)
	 */
}

func InsertNode(n int, current_node *node) node {
	var result node

	// checking if the pointer is null.
	// If the pointer is null, the struct is null.
	if current_node.data == n {
		// It is a duplicate.
		// We don't want to support duplicates. So, don't do anything.
	} else if n < current_node.data {
		if current_node.left_child_pointer == nil {
			new_node := node{data: n}
			current_node.left_child_pointer = &new_node
		} else {
			result = InsertNode(n, current_node.left_child_pointer)
		}
	} else if n > current_node.data {
		if current_node.right_child_pointer == nil {
			new_node := node{data: n}
			current_node.right_child_pointer = &new_node
		} else {
			result = InsertNode(n, current_node.right_child_pointer)
		}
	}

	return result
}
