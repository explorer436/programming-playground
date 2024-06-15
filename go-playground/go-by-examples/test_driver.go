package main

import (
	"fmt"

	mynumbers "my/go/examples/mynumbers"
	morestrings "my/go/examples/mystrings"
	value_types "my/go/examples/myvaluetypes"

	"github.com/google/go-cmp/cmp"
)

func main() {

	// strings

	fmt.Println("Hello, world.")

	fmt.Println(morestrings.ReverseRunes("!oG ,ereht olleH"))

	fmt.Println(cmp.Diff("Hello World", "Hello Go"))

	// values
	value_types.ValueTypes()

	// swap numbers
	var a int = 12
	var b int = 34

	fmt.Println("a before swapping: ", a) // 12
	fmt.Println("b before swapping: ", b) // 34
	mynumbers.SwapNumbers_passing_values(a, b)
	fmt.Println("a after swapping: ", a) // 12
	fmt.Println("b after swapping: ", b) // 34

	// The local variables of the function SwapNumbers_passing_values are changing but not ‘a’ and ‘b’.

	// swap numbers
	var c int = 56
	var d int = 78
	fmt.Println("c before swapping: ", c) // 56
	fmt.Println("d before swapping: ", d) // 78
	mynumbers.SwapNumbers_passing_pointers(&c, &d)
	fmt.Println("c after swapping: ", c) // 56
	fmt.Println("d after swapping: ", d) // 78
}
