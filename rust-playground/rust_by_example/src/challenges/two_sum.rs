use std::collections::HashMap;

#[allow(dead_code)]
fn solution(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut map = HashMap::new();

    for (i, &num) in nums.iter().enumerate() {
        if let Some(&j) = map.get(&(target - num)) {
            return vec![j as i32, i as i32];
        }
        map.insert(num, i);
    }

    vec![]
}

#[cfg(test)]
mod tests {
    use crate::challenges::two_sum::solution;

    #[test]
    fn happy_path() {

        let mut nums = Vec::new();
        nums.push(2);
        nums.push(7);
        nums.push(11);
        nums.push(15);

        let _result1 = solution(nums, 9);
        let mut expected1 = Vec::new();
        expected1.push(0);
        expected1.push(1);
        assert_eq!(_result1, expected1);
    }

    #[test]
    fn no_result() {

        let mut nums = Vec::new();
        nums.push(2);
        nums.push(7);
        nums.push(11);
        nums.push(15);

        let _result1 = solution(nums, 10);
        let expected1 = Vec::new();
        assert_eq!(_result1, expected1);
    }
}