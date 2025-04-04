package main

import (
	"cmp"
	"encoding/json"
	"fmt"
	"log"
	"os"
	"slices"
	"sort"
	"strings"
)

type response1 struct {
	Page   int
	Fruits []string
}

type response2 struct {
	Page   int      `json:"page"`
	Fruits []string `json:"fruits"`
}

// This can have complex fields as well.
type Car struct {
	Make       string
	Model      string
	Year       int
	Color      string
	EngineSize float64
}

func main() {

	bolB, _ := json.Marshal(true)
	fmt.Println(string(bolB))

	intB, _ := json.Marshal(1)
	fmt.Println(string(intB))

	fltB, _ := json.Marshal(2.34)
	fmt.Println(string(fltB))

	strB, _ := json.Marshal("gopher")
	fmt.Println(string(strB))

	slcD := []string{"apple", "peach", "pear"}
	slcB, _ := json.Marshal(slcD)
	fmt.Println(string(slcB))

	mapD := map[string]int{"apple": 5, "lettuce": 7}
	mapB, _ := json.Marshal(mapD)
	fmt.Println(string(mapB))

	res1D := &response1{
		Page:   1,
		Fruits: []string{"apple", "peach", "pear"}}
	res1B, _ := json.Marshal(res1D)
	fmt.Println(string(res1B))

	res2D := &response2{
		Page:   1,
		Fruits: []string{"apple", "peach", "pear"}}
	res2B, _ := json.Marshal(res2D)
	fmt.Println(string(res2B))

	byt := []byte(`{"num":6.13,"strs":["a","b"]}`)
	var dat map[string]interface{}
	if err := json.Unmarshal(byt, &dat); err != nil {
		panic(err)
	}
	fmt.Println(dat)
	num := dat["num"].(float64)
	fmt.Println(num)
	strs := dat["strs"].([]interface{})
	str1 := strs[0].(string)
	fmt.Println(str1)

	structToAndFromJson()

	funcName()

	sortingObjects1()

	sortingObjects2()

	a := []int{4, 5, 6}
	b := []int{4, 5, 6}
	c := []int{4, 5, 6, 7}
	log.Print(areSlicesEqual(a, b))
	log.Print(areSlicesEqual(b, c))
}

func funcName() {

	fmt.Println(">>> funcName()")

	str := `{"page": 1, "fruits": ["apple", "peach"]}`
	res := response2{}
	json.Unmarshal([]byte(str), &res)
	fmt.Println(res)
	fmt.Println(res.Fruits[0])

	enc := json.NewEncoder(os.Stdout)
	d := map[string]int{"apple": 5, "lettuce": 7}
	enc.Encode(d)

	dec := json.NewDecoder(strings.NewReader(str))
	res1 := response2{}
	dec.Decode(&res1)
	fmt.Println(res1)

	fmt.Println("<<< funcName()")
}

func structToAndFromJson() {

	fmt.Println(">>> structToAndFromJson()")

	// Convert raw json into a struct
	var car Car
	byt2 := []byte(`{"make":"Honda","model":"accord", "year": 2025, "color": "white", "EngineSize": 8}`)
	if err := json.Unmarshal(byt2, &car); err != nil {
		panic(err)
	}
	// Print raw struct
	fmt.Println(car)

	// Pretty print
	// https://stackoverflow.com/questions/19038598/how-can-i-pretty-print-json-using-go
	carStr, _ := json.MarshalIndent(car, "", "  ")
	fmt.Println(string(carStr))

	fmt.Println("<<< structToAndFromJson()")
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

func sortingObjects1() {

	fmt.Println(">>> sortingObjects1()")

	people := []Person{
		{"Gopher", 13},
		{"Alice", 55},
		{"Bob", 24},
		{"Alice", 20},
	}

	slices.SortFunc(people, CmpPerson)

	// Expected Output: [{Alice 20} {Alice 55} {Bob 24} {Gopher 13}]
	fmt.Println(people)

	fmt.Println("<<< sortingObjects1()")

}

func sortingObjects2() {

	fmt.Println(">>> sortingObjects2()")

	people := []Person{
		{"Gopher", 13},
		{"Alice", 55},
		{"Bob", 24},
		{"Alice", 20},
	}

	sort.Slice(people, func(i, j int) bool {

		a := people[i].Name < people[j].Name
		b := people[i].Age < people[j].Age

		return a && b
	})

	// Expected Output: [{Alice 20} {Alice 55} {Bob 24} {Gopher 13}]
	// FIXME Doesn't seem to be doing it
	fmt.Println(people)

	fmt.Println("<<< sortingObjects2()")

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
