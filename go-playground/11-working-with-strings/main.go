package main

import "fmt"

// https://stackoverflow.com/questions/12311033/extracting-substrings-in-go

func main() {
	s := "address;bar;"

	// To avoid a panic on a zero length input, wrap the truncate operation in an if
	/*if len(input) > 0 {

	}*/

	// Remove the last character of the string
	s2 := s[:len(s)-1]
	fmt.Println(s2)

	// Take substring from index 2 to length of string
	substring := s[2:len(s)]
	fmt.Println(substring)
}
