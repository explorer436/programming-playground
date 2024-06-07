package mynumbers

import "testing"
import "reflect"

func TestEvenNumbersTillN(t *testing.T) {

	var emptyArray []int
	var cases = []struct {
		name  string
		input int
		want  []int
	}{
		// the table itself
		{"9 should be Foo", 9, []int{2, 4, 6, 8}},
		{"3 should be Foo", 3, []int{2}},
		{"1 is not Foo", 1, emptyArray},
		{"0 should be Foo", 0, emptyArray},
	}

	for _, c := range cases {
		got := EvenNumbersTillN(c.input)

		if !reflect.DeepEqual(got, c.want) {
			t.Errorf("EvenNumbersTillN(%d) got %d, but want %d", c.input, got, c.want)
		}
	}
}

func TestFirstNEvenNumbers(t *testing.T) {

	var emptyArray []int
	var cases = []struct {
		name  string
		input int
		want  []int
	}{
		// the table itself
		{"9 should be Foo", 9, []int{2, 4, 6, 8, 10, 12, 14, 16, 18}},
		{"3 should be Foo", 3, []int{2, 4, 6}},
		{"1 is not Foo", 1, []int{2}},
		{"0 should be Foo", 0, emptyArray},
	}

	for _, c := range cases {
		got := FirstNEvenNumbers(c.input)

		if !reflect.DeepEqual(got, c.want) {
			t.Errorf("FirstNEvenNumbers(%d) got %d, but want %d", c.input, got, c.want)
		}
	}
}
