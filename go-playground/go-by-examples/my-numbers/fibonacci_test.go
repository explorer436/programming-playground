package mynumbers

import "testing"

func TestFirstNFibonacciNumbers_without_recursion(t *testing.T) {

	var cases = []struct {
		name  string
		input int
		want  string
	}{
		// the table itself
		{"9 should be Foo", 9, "0 1 1 2 3 5 8 13 21"},
		{"3 should be Foo", 3, "0 1 1"},
		{"1 is not Foo", 1, "0"},
		{"0 should be Foo", 2, "0 1"},
	}

	for _, c := range cases {
		got := FirstNFibonacciNumbers_without_recursion(c.input)
		if got != c.want {
			t.Errorf("FirstNFibonacciNumbers_without_recursion(%d) got %q, but want %q", c.input, got, c.want)
		}
	}
}

func TestFibonacciNumberAtPositionN_using_recursion(t *testing.T) {

	var cases = []struct {
		name  string
		input int
		want  int
	}{
		// the table itself
		{"9 should be Foo", 9, 21},
		{"3 should be Foo", 3, 1},
		{"3 should be Foo", 2, 1},
		{"1 is not Foo", 1, 0},
		{"0 should be Foo", 0, 0},
	}

	for _, c := range cases {
		got := FibonacciNumberAtPositionN_using_recursion(c.input)
		if got != c.want {
			t.Errorf("FibonacciNumberAtPositionN_using_recursion(%d) got %d, but want %d", c.input, got, c.want)
		}
	}
}

func TestFibonacciNumberAtPositionN_without_recursion(t *testing.T) {

	var cases = []struct {
		name  string
		input int
		want  int
	}{
		// the table itself
		{"9 should be Foo", 9, 21},
		{"3 should be Foo", 3, 1},
		{"3 should be Foo", 2, 1},
		{"1 is not Foo", 1, 0},
		{"0 should be Foo", 0, 0},
	}

	for _, c := range cases {
		got := FibonacciNumberAtPositionN_without_recursion(c.input)
		if got != c.want {
			t.Errorf("FibonacciNumberAtPositionN_without_recursion(%d) got %d, but want %d", c.input, got, c.want)
		}
	}
}
