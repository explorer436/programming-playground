package main

import "fmt"

// Run with $ go run main.go

func main() {
	a := 42
	fmt.Println(a)

	b, c, d, _, f := 0, 1, 2, 3, "happiness"
	fmt.Println(b, c, d, f)

	// this would not work - because the variable "e" is not being used.
	// ./main.go:15:11: declared and not used: e
	/*
	b, c, d, e := 0, 1, 2, 3
	fmt.Println(b, c, d)
	*/

	// this does work
	var g int
	fmt.Println(g)
	g = 43
	fmt.Println(g)

	// DECLARE a variable to hold a VALUE of a certain TYPE
	// then ASSIGN a VALUE of that TYPE to the variable
	// initializing a variable
	var h int = 44
	fmt.Println(h)
}