fn main() {
    example_use_case_for_mut_keyword();
    example_use_case_for_shadowing();
    string_that_can_be_mutated();
}

fn example_use_case_for_mut_keyword() {
    println!(">>> example_use_case_for_mut_keyword");
    let mut x = 5;
    println!("The value of x is: {}", x);
    x = 6;
    println!("The value of x is: {}", x);
    println!("<<< example_use_case_for_mut_keyword");
}

fn example_use_case_for_shadowing() {
    println!(">>> example_use_case_for_shadowing");
    let x = 5;

    let x = x + 1;

    {
        let x = x * 2;
        println!("The value of x in the inner scope is: {x}");
    }

    println!("The value of x in the outer scope is: {}", x);
    println!("<<< example_use_case_for_shadowing");
}

fn string_that_can_be_mutated() {
    let mut s = String::from("hello");

    s.push_str(", world!"); // push_str() appends a literal to a String

    println!("{}", s); // This will print `hello, world!`
}