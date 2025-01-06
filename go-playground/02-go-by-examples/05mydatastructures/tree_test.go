package mydatastructures

import "testing"

func TestCreateBinarySearchTree(t *testing.T) {

	got := CreateBinarySearchTree(789)

	want := BinarySearchTree{
		Value: 789,
	}

	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}
