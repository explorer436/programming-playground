package mydatastructures

import (
	"testing"
)

func Test_BiggestElementInBinarySearchTree_EmptyTree(t *testing.T) {

	var got int = BiggestElementInBinarySearchTree(BinarySearchTree{})

	want := 0

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_BiggestElementInBinarySearchTree_RightNodeIsEmpty(t *testing.T) {

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

	var got int = BiggestElementInBinarySearchTree(test_tree)

	want := 17

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_BiggestElementInBinarySearchTree_LeftNodeIsEmpty(t *testing.T) {

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

	var got int = BiggestElementInBinarySearchTree(test_tree)

	want := 26

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_BiggestElementInBinarySearchTree_LeftNodeAndRightNodeAreNotEmpty(t *testing.T) {

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

	var got int = BiggestElementInBinarySearchTree(test_tree)

	want := 32

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}