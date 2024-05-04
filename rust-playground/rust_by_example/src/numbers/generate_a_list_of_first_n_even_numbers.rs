#[allow(dead_code)]
fn solution(upper: i32) -> Vec<i32> {

    // Functional approach
    let vec: Vec<i32> = (1..)
        .filter(|&n| crate::numbers::generate_a_list_of_first_n_even_numbers::is_even(n))
        .take(upper as usize)
        .collect();

    vec
}

fn is_even(n: i32) -> bool {
    n % 2 == 0
}

#[cfg(test)]
mod tests {
    use crate::numbers::generate_a_list_of_first_n_even_numbers::solution;

    #[test]
    fn happy_path_1() {
        let mut expected: Vec<i32> = Vec::new();
        expected.push(2);
        expected.push(4);
        expected.push(6);
        expected.push(8);
        expected.push(10);
        expected.push(12);
        expected.push(14);
        expected.push(16);
        expected.push(18);
        expected.push(20);

        let actual = solution(10);
        assert_eq!(actual, expected);
    }
}