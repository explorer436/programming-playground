package main

import (
	"fmt"

	"example/user/hello/morestrings"

	"github.com/google/go-cmp/cmp"
)

func main() {
	fmt.Println("Hello, world.")

	fmt.Println(morestrings.ReverseRunes("!oG ,ereht olleH"))

	fmt.Println(cmp.Diff("Hello World", "Hello Go"))
}
