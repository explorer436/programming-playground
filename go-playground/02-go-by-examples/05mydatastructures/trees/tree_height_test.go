package mydatastructures

import (
	"testing"
)

func Test_TreeHeight_EmptyTree(t *testing.T) {

	var got int = TreeHeight(BinarySearchTree{})

	want := -1

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_TreeHeight_NoNodes(t *testing.T) {

	var got int = TreeHeight(BinarySearchTree{3, nil, nil})

	want := 0

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

/*
				17
			       /
			      16
			     /
			    15
			   /
			  14
			 /
			13
		       /
		      12
		     /
		    11
		   /
		  10
		 /
		9
	       /
	      8
*/

func Test_TreeHeight_RightNodeIsEmpty(t *testing.T) {

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

	var got int = TreeHeight(test_tree)

	want := 9

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

/*
	      17
	       \
		18
		 \
		  19
		   \
		    20
		     \
		      21
		       \
			22
			 \
			  23
			   \
			    24
			     \
			      25
			       \
				26
*/

func Test_TreeHeight_LeftNodeIsEmpty(t *testing.T) {

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

	var got int = TreeHeight(test_tree)

	want := 9

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

/*

		17
	       /
	      15

*/

func Test_TreeHeight_LeftNodeAndRightNodeAreNotEmpty_01(t *testing.T) {

	var test_tree BinarySearchTree = InsertInBinarySearchTree(15,
		InsertInBinarySearchTree(17, BinarySearchTree{}),
	)

	var got int = TreeHeight(test_tree)

	want := 1

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

/*
	      17
		\
		25
	       /  \
	      20  26
	       \   \
		22  27
		     \
		      29
		       \
			30
*/

func Test_TreeHeight_LeftNodeAndRightNodeAreNotEmpty_02(t *testing.T) {

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

	var got int = TreeHeight(test_tree)

	want := 5

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}
