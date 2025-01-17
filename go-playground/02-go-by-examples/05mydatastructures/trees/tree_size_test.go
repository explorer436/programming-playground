package mydatastructures

import (
	"testing"
)

func Test_TreeSize_EmptyTree(t *testing.T) {

	var got int = TreeSize(BinarySearchTree{})

	want := 0

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_TreeSize_NoNodes(t *testing.T) {

	var got int = TreeSize(BinarySearchTree{3, nil, nil})

	want := 1

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_TreeSize_RightNodeIsEmpty(t *testing.T) {

	var test_tree BinarySearchTree = InsertInBinarySearchTree(8,
		InsertInBinarySearchTree(9,
			InsertInBinarySearchTree(10,
				InsertInBinarySearchTree(11,
					InsertInBinarySearchTree(12,
						InsertInBinarySearchTree(13,
							InsertInBinarySearchTree(14,
								InsertInBinarySearchTree(15,
									InsertInBinarySearchTree(16,
										InsertInBinarySearchTree(17, BinarySearchTree{}),
									)))))))))

	var got int = TreeSize(test_tree)

	want := 10

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_TreeSize_LeftNodeIsEmpty(t *testing.T) {

	var test_tree BinarySearchTree = InsertInBinarySearchTree(26,
		InsertInBinarySearchTree(25,
			InsertInBinarySearchTree(24,
				InsertInBinarySearchTree(23,
					InsertInBinarySearchTree(22,
						InsertInBinarySearchTree(21,
							InsertInBinarySearchTree(20,
								InsertInBinarySearchTree(19,
									InsertInBinarySearchTree(18,
										InsertInBinarySearchTree(17, BinarySearchTree{}),
									)))))))))

	var got int = TreeSize(test_tree)

	want := 10

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_TreeSize_LeftNodeAndRightNodeAreNotEmpty(t *testing.T) {

	var test_tree BinarySearchTree = InsertInBinarySearchTree(15,
		InsertInBinarySearchTree(27,
			InsertInBinarySearchTree(30,
				InsertInBinarySearchTree(29,
					InsertInBinarySearchTree(26,
						InsertInBinarySearchTree(22,
							InsertInBinarySearchTree(32,
								InsertInBinarySearchTree(20,
									InsertInBinarySearchTree(25,
										InsertInBinarySearchTree(17, BinarySearchTree{}),
									)))))))))

	var got int = TreeSize(test_tree)

	want := 10

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}
