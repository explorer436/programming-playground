package mynumbers

import "fmt"

func SwapNumbers_passing_values(a int, b int) {

	var temp int = a
	a = b
	b = temp

	fmt.Println("a inside the swap function: ", a)
	fmt.Println("b inside the swap function: ", b)
}

func SwapNumbers_passing_pointers(c *int, d *int) {

	var temp int = *c
	// Go to the address c is holding (GPS coordinates of c)
	// Now get the value at that address (the house)
	// Now assign the value (the house that used to be at c) to temp.

	*c = *d
	// When *d is assigned to *c
	// Go to the address d is holding (GPS coordinates of d)
	// Now get the value at that address (the house)
	// Now go to the address ‘c’ is holding (GPS coordinates of c)
	// Now assign the value at d (the house that used to be at d) to the c.

	*d = temp
	// When temp is assigned to *
	// Go to the address d is holding (GPS coordinates of d)
	// Now assign temp (the house) to d.

	fmt.Println("c inside the swap function: ", *c)
	fmt.Println("d inside the swap function: ", *d)
}
