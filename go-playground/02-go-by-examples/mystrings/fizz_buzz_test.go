package mystrings

import "testing"

func TestFizzBuzz(t *testing.T) {

	var cases = []struct {
		name  string
		input int
		want  string
	}{
		// the table itself
		{"9 should be Foo", 9, "1 2 Fizz 4 Buzz Fizz 7 8 Fizz"},
		{"3 should be Foo", 3, "1 2 Fizz"},
		{"1 is not Foo", 1, "1"},
		{"0 should be Foo", 0, ""},
	}

	for _, c := range cases {
		got := FizzBuzz(c.input)
		if got != c.want {
			t.Errorf("FizzBuzz(%d) got %q, but want %q", c.input, got, c.want)
		}
	}
}
