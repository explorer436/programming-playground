package mynumbers

func TwoSum(nums []int, target int) []int {

	my_map := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		var complement int = target - nums[i]

		map_value_for_component_key, ok := my_map[complement]

		if ok && map_value_for_component_key != i {
			return []int{map_value_for_component_key, i}
		} else {
			my_map[nums[i]] = i
		}
	}

	var emptyArray []int
	return emptyArray
}
