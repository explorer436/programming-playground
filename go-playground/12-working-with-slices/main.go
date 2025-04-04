package main

import (
	"cmp"
	"fmt"
	"slices"
	"sort"
)

func main() {
	sortingObjectsUsingSortFunc()

	sortingObjectsUsingSortStableFunc()

	sortingObjectsUsingSortSlice()

	a := []int{4, 5, 6}
	b := []int{4, 5, 6}
	c := []int{4, 5, 6, 7}
	fmt.Print(areSlicesEqual(a, b))
	fmt.Print(areSlicesEqual(b, c))
}

type Person struct {
	Name string
	Age  int
}

func CmpPerson(a, b Person) int {
	if a.Name == b.Name {
		return cmp.Compare(a.Age, b.Age)
	}
	return cmp.Compare(a.Name, b.Name)
}

// https://stackoverflow.com/questions/37695209/golang-sort-slice-ascending-or-descending
// https://stackoverflow.com/posts/77687553/timeline
func sortingObjectsUsingSortFunc() {

	fmt.Println(">>> sortingObjectsUsingSortFunc()")

	people := []Person{
		{"Gopher", 13},
		{"Alice", 55},
		{"Bob", 24},
		{"Alice", 20},
	}

	slices.SortFunc(people, CmpPerson)

	// Expected Output: [{Alice 20} {Alice 55} {Bob 24} {Gopher 13}]
	fmt.Println(people)

	fmt.Println("<<< sortingObjectsUsingSortFunc()")
}

// https://stackoverflow.com/questions/37695209/golang-sort-slice-ascending-or-descending
// https://stackoverflow.com/posts/77687553/timeline
func sortingObjectsUsingSortStableFunc() {

	fmt.Println(">>> sortingObjectsUsingSortStableFunc()")

	people := []Person{
		{"Gopher", 13},
		{"Alice", 55},
		{"Bob", 24},
		{"Alice", 20},
	}

	slices.SortStableFunc(people, CmpPerson)

	// Expected Output: [{Alice 20} {Alice 55} {Bob 24} {Gopher 13}]
	fmt.Println(people)

	fmt.Println("<<< sortingObjectsUsingSortStableFunc()")

}

// This is not working
func sortingObjectsUsingSortSlice() {

	fmt.Println(">>> sortingObjectsUsingSortSlice()")

	people := []Person{
		{"Gopher", 13},
		{"Alice", 55},
		{"Bob", 24},
		{"Alice", 20},
	}

	sort.Slice(people, func(i, j int) bool {

		a := people[i].Name < people[j].Name
		// b := people[i].Age < people[j].Age

		// return a && b
		return a
	})

	// Expected Output: [{Alice 20} {Alice 55} {Bob 24} {Gopher 13}]
	// FIXME Doesn't seem to be doing it
	fmt.Println(people)

	a := []int{5, 3, 4, 7, 8, 9}
	sort.Slice(a, func(i, j int) bool {
		return a[i] < a[j]
	})
	for _, v := range a {
		fmt.Println(v)
	}

	fmt.Println("<<< sortingObjectsUsingSortSlice()")

}

func areSlicesEqual(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
