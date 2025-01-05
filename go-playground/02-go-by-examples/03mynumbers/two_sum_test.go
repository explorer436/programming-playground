package mynumbers

import "testing"
import "reflect"

func TestTwoSum(t *testing.T) {

	var emptyArray []int
	var cases = []struct {
		name   string
		input  []int
		target int
		want   []int
	}{
		// the table itself
		{"9 should be Foo", []int{2, 4, 6, 8, 10, 12, 14, 16, 18}, 14, []int{2, 3}},
		{"3 should be Foo", []int{2, 4, 6, 8, 10, 12, 14, 16, 18}, 6, []int{0, 1}},
		{"3 should be Foo", []int{3, 2, 4}, 6, []int{1, 2}},
		{"3 should be Foo", []int{0, 4, 3, 0}, 0, []int{0, 3}},
		{"3 should be Foo", []int{-1, -2, -3, -4, -5}, -7, []int{2, 3}},
		{"0 should be Foo", []int{2, 4, 6, 8, 10, 12, 14, 16, 18}, 7, emptyArray},
	}

	for _, c := range cases {
		got := TwoSum(c.input, c.target)

		if !reflect.DeepEqual(got, c.want) {
			t.Errorf("TwoSum(%d, %d) got %d, but want %d", c.input, c.target, got, c.want)
		}
	}
}
