package mynumbers

import (
	"strconv"
	"strings"
)

func FirstNFibonacciNumbers_without_recursion(n int) string {
	var s string

	var n1, n2 int = 0, 1

	if n == 1 {
		s = s + strconv.Itoa(n1) + " "
	} else if n == 2 {
		s = s + strconv.Itoa(n1) + " "
		s = s + strconv.Itoa(n2) + " "
	} else {
		s = s + strconv.Itoa(n1) + " "
		s = s + strconv.Itoa(n2) + " "

		var next int
		for i := 2; i < n; i++ {
			next = n1 + n2
			s = s + strconv.Itoa(next) + " "

			n1 = n2
			n2 = next
		}
	}

	s = strings.TrimRight(s, " ")
	return s
}

// seems very inefficient
func FibonacciNumberAtPositionN_using_recursion(n int) int {

	var n1, n2 int = 0, 1

	if n < 1 {
		return 0
	} else if n == 1 {
		return n1
	} else if n == 2 {
		return n2
	} else {
		return FibonacciNumberAtPositionN_using_recursion(n-1) + FibonacciNumberAtPositionN_using_recursion(n-2)
	}
}

func FibonacciNumberAtPositionN_without_recursion(n int) int {

	var n1, n2 int = 0, 1

	if n < 1 {
		return 0
	} else if n == 1 {
		return n1
	} else if n == 2 {
		return n2
	} else {
		var next int
		for i := 3; i <= n; i++ {
			next = n1 + n2
			n1 = n2
			n2 = next
		}
		return next
	}
}
