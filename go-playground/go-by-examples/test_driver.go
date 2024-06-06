package main

import (
	"fmt"

	morestrings "my/go/examples/my-strings"
	value_types "my/go/examples/value_types"

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
