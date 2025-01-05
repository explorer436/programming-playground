package mystrings

import (
	"strconv"
	"strings"
)

func FizzBuzz(n int) string {
	var s string

	i := 1
	for i <= n {
		if i%15 == 0 {
			s = s + "FizzBuzz "
		} else if i%3 == 0 {
			s = s + "Fizz "
		} else if i%5 == 0 {
			s = s + "Buzz "
		} else {
			t := strconv.Itoa(i)
			s = s + t + " "
		}
		i = i + 1
	}

	s = strings.TrimRight(s, " ")
	return s
}
