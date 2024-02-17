#[allow(dead_code)]
fn solution(num: i32) -> Vec<String> {
    let mut result: Vec<String> = Vec::new();
    for n in 1..=num {
        if n % 15 == 0 {
            // let name = String::from("FizzBuzz");
            result.push(String::from("FizzBuzz"))
        } else if n % 3 == 0 {
            // result.push("Fizz")
            result.push(String::from("Fizz"))
        } else if n % 5 == 0 {
            // result.push("Buzz")
            result.push(String::from("Buzz"))
        } else {
            let s: String = n.to_string();
            result.push(s)
        }
    }

    return result;
}

#[cfg(test)]
mod tests {
    use crate::challenges::fizz_buzz::solution;

    #[test]
    fn happy_path_1() {
        let mut expected: Vec<String> = Vec::new();
        expected.push(String::from("1"));
        expected.push(String::from("2"));
        expected.push(String::from("Fizz"));
        expected.push(String::from("4"));
        expected.push(String::from("Buzz"));

        let _result1 = solution(5);
        assert_eq!(_result1, expected);
    }

    #[test]
    fn happy_path_2() {
        let mut expected: Vec<String> = Vec::new();
        expected.push(String::from("1"));
        expected.push(String::from("2"));
        expected.push(String::from("Fizz"));
        expected.push(String::from("4"));
        expected.push(String::from("Buzz"));
        expected.push(String::from("Fizz"));
        expected.push(String::from("7"));
        expected.push(String::from("8"));
        expected.push(String::from("Fizz"));
        expected.push(String::from("Buzz"));
        expected.push(String::from("11"));
        expected.push(String::from("Fizz"));
        expected.push(String::from("13"));
        expected.push(String::from("14"));
        expected.push(String::from("FizzBuzz"));
        expected.push(String::from("16"));

        let _result1 = solution(16);
        assert_eq!(_result1, expected);
    }

    #[test]
    fn zero_input() {
        let expected: Vec<String> = Vec::new();

        let _result1 = solution(0);
        assert_eq!(_result1, expected);
    }

    #[test]
    fn negative_input() {
        let expected: Vec<String> = Vec::new();

        let _result1 = solution(-5);
        assert_eq!(_result1, expected);
    }
}
