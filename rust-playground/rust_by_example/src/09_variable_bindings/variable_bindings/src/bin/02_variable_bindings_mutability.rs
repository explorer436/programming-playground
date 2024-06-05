fn main() {
    let _immutable_binding = 1;
    let mut mutable_binding = 1;

    println!("Before mutation: {}", mutable_binding);

    // Ok
    mutable_binding += 1;

    println!("After mutation: {}", mutable_binding);

    // Error! Cannot assign a new value to an immutable variable
    // _immutable_binding += 1;


    example_use_case_for_mut_keyword();
    string_that_can_be_mutated();
}

fn example_use_case_for_mut_keyword() {
    println!(">>> example_use_case_for_mut_keyword");
    let mut x = 5;
    println!("The value of x is: {}", x);
    x = 6;
    println!("The value of x is: {}", x);
    println!("<<< example_use_case_for_mut_keyword");
    println!("");
}

fn string_that_can_be_mutated() {
    println!(">>> string_that_can_be_mutated");
    let mut s = String::from("hello");

    s.push_str(", world!"); // push_str() appends a literal to a String

    println!("{}", s); // This will print `hello, world!`
    println!("<<< string_that_can_be_mutated");
    println!("");
}