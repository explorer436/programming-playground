package main

import (
	"fmt"

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
}
