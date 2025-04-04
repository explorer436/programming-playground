package main

import "fmt"

type FullUser struct {
	UserName  string
	UserEmail string
}

type SimpleUser struct {
	UserName string
}

// We have some users in manySimpleUsers that we would like to remove from manyFullUsers based on the Username.
// https://stackoverflow.com/questions/32867780/filtering-a-slice-of-structs-based-on-a-different-slice-in-golang

func main() {
	fmt.Println("Hello, playground")

	manyFullUsers := []FullUser{
		{"foo", "foo@jawohl.com"},
		{"bar", "bar@jawohl.com"},
		{"baz", "baz@jawohl.com"}}

	manySimpleUsers := []SimpleUser{{"foo"}, {"bar"}}

	fmt.Println(manyFullUsers)
	fmt.Println(manySimpleUsers)

	result1, result2 := filterByUserName(manyFullUsers, manySimpleUsers)
	fmt.Println(result1)
	fmt.Println(result2)
}

func filterByUserName(fu []FullUser, su []SimpleUser) (usersInBothSlices []FullUser, otherUsers []FullUser) {
	simpleUsersMap := make(map[string]struct{}, len(su))
	for _, u := range su {
		simpleUsersMap[u.UserName] = struct{}{}
	}
	for _, u := range fu {

		// How to check if a map contains a key in Go?
		/*val, ok := myMap["foo"]
		// If the key exists
		if ok {
			// Do something
		}*/

		// Doing it in one line
		/*if val, ok := myMap["foo"]; ok {
			//do something here
		}*/

		if _, ok := simpleUsersMap[u.UserName]; ok {
			usersInBothSlices = append(usersInBothSlices, u)
		} else {
			// If you want to reconcile, do the opposite
			otherUsers = append(otherUsers, u)
		}

	}
	return
}
