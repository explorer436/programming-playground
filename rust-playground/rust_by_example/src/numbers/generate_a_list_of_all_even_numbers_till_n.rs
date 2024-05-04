#[allow(dead_code)]
fn solution(upper: i32) -> Vec<i32> {

    // Functional approach
    let vec: Vec<i32> = (1..upper)
        .filter(|&n| is_even(n))
        .collect();

    vec

    /*let mut all_even_numbers_till_n: Vec<i32> = Vec::new();

    for i in (1..) {
        if i < upper {
            if is_even(i) && i < upper {
                all_even_numbers_till_n.push(i);
            }
        } else {
            break;
        }
    };

    all_even_numbers_till_n*/
}

fn is_even(n: i32) -> bool {
    n % 2 == 0
}

#[cfg(test)]
mod tests {
    use crate::numbers::generate_a_list_of_all_even_numbers_till_n::solution;

    #[test]
    fn happy_path_1() {
        let mut expected: Vec<i32> = Vec::new();
        expected.push(2);
        expected.push(4);
        expected.push(6);
        expected.push(8);

        let actual = solution(10);
        assert_eq!(actual, expected);
    }
}