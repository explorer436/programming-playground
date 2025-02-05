package mydatastructures

import (
	"reflect"
	"testing"
)

func Test_InsertInBinarySearchTree_InsertInEmptyTree(t *testing.T) {

	var got BinarySearchTree = InsertInBinarySearchTree(789, BinarySearchTree{})

	want := BinarySearchTree{
		Value: 789,
	}

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_InsertInBinarySearchTree_InsertDuplicateElement(t *testing.T) {

	var got BinarySearchTree = InsertInBinarySearchTree(789, BinarySearchTree{
		Value: 789,
	})

	want := BinarySearchTree{
		Value: 789,
	}

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}

func Test_InsertInBinarySearchTree_2(t *testing.T) {

	var got BinarySearchTree = InsertInBinarySearchTree(15,
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

	// Do not use.
	// This is a tedious process and prone to errors.
	var cases = []struct {
		expected int
		received int
	}{
		// the table itself
		{17, got.Value},
		{15, got.Left.Value},
		{25, got.Right.Value},
		{20, got.Right.Left.Value},
		{22, got.Right.Left.Right.Value},
		{32, got.Right.Right.Value},
		{26, got.Right.Right.Left.Value},
		{29, got.Right.Right.Left.Right.Value},
		{27, got.Right.Right.Left.Right.Left.Value},
		{30, got.Right.Right.Left.Right.Right.Value},
	}

	for _, c := range cases {
		if !reflect.DeepEqual(c.expected, c.received) {
			t.Errorf("Result was incorrect - got %+v, but want %+v", c.received, c.expected)
		}
	}

	// Building a complex struct and using it for equality testing
	var expected BinarySearchTree = BinarySearchTree{
		Value: 17,
		Left: &BinarySearchTree{
			Value: 15,
		},
		Right: &BinarySearchTree{
			Value: 25,
			Left: &BinarySearchTree{
				Value: 20,
				Right: &BinarySearchTree{
					Value: 22,
				},
			},
			Right: &BinarySearchTree{
				Value: 32,
				Left: &BinarySearchTree{
					Value: 26,
					Right: &BinarySearchTree{
						Value: 29,
						Left: &BinarySearchTree{
							Value: 27,
						},
						Right: &BinarySearchTree{
							Value: 30,
						},
					},
				},
			},
		},
	}

	if !reflect.DeepEqual(got, expected) {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, expected)
	}

}
