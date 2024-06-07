package mynumbers

func EvenNumbersTillN(n int) []int {

	var result []int

	if n > 1 {
		for j := 1; j < n; j++ {
			if j%2 == 0 {
				result = append(result, j)
			}
		}
	}

	return result
}

func FirstNEvenNumbers(n int) []int {

	var result []int

	if n >= 1 {
		i := 2
		for {
			if i%2 == 0 {
				result = append(result, i)
			}
			i++

			if len(result) < n {
				continue
			} else {
				break
			}
		}
	}

	return result
}
