use std::collections::HashMap;

fn main() {
//        let mut nums = Vec::new();
//        nums.push(2);
//        nums.push(7);
//        nums.push(11);
//        nums.push(15);
//
//        let _result1 = two_sum(nums, 9);
}

pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
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
    use crate::two_sum;


    #[test]
    fn happy_path() {

        let mut nums = Vec::new();
        nums.push(2);
        nums.push(7);
        nums.push(11);
        nums.push(15);

        let _result1 = two_sum(nums, 9);
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

        let _result1 = two_sum(nums, 10);
        let expected1 = Vec::new();
        assert_eq!(_result1, expected1);
    }
}