package mydatastructures

import "testing"

func TestInsert(t *testing.T) {

	got := InsertInTree(789, tree{root: node{data: 456}})

	want := tree{root: node{data: 123}}
	if got != want {
		t.Errorf("Result was incorrect - got %+v, but want %+v", got, want)
	}
}
