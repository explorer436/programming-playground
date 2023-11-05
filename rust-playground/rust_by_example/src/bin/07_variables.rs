fn main() {
    example_use_case_for_mut_keyword();
    example_use_case_for_shadowing();
    string_that_can_be_mutated();

    let an_integer = 1u32;
    let a_boolean = true;
    let unit = ();

    // copy `an_integer` into `copied_integer`
    let copied_integer = an_integer;

    println!("An integer: {:?}", an_integer);
    println!("A copied integer: {:?}", copied_integer);
    println!("A boolean: {:?}", a_boolean);
    println!("Meet the unit value: {:?}", unit);

    // The compiler warns about unused variable bindings; these warnings can
    // be silenced by prefixing the variable name with an underscore
    let _unused_variable = 3u32;

    let noisy_unused_variable = 2u32;
    // FIXME ^ Prefix with an underscore to suppress the warning
    // Please note that warnings may not be shown in a browser

    // Variables can be type annotated.
    let logical: bool = true;

    let a_float: f64 = 1.0;  // Regular annotation
    let an_integer   = 5i32; // Suffix annotation

    // Or a default will be used.
    let default_float   = 3.0; // `f64`
    let default_integer = 7;   // `i32`

    // A type can also be inferred from context
    let mut inferred_type = 12; // Type i64 is inferred from another line
    inferred_type = 4294967296i64;

    // A mutable variable's value can be changed.
    let mut mutable = 12; // Mutable `i32`
    mutable = 21;

    // Error! The type of a variable can't be changed.
    // mutable = true;

    // Variables can be overwritten with shadowing.
    let mutable = true;

    let _immutable_binding = 1;
    let mut mutable_binding = 1;

    println!("Before mutation: {}", mutable_binding);

    // Ok
    mutable_binding += 1;

    println!("After mutation: {}", mutable_binding);

    // Error!
    // _immutable_binding += 1;
    // FIXME ^ Comment out this line

    // This binding lives in the main function
    let long_lived_binding = 1;

    // This is a block, and has a smaller scope than the main function
    {
	// This binding only exists in this block
	let short_lived_binding = 2;

	println!("inner short: {}", short_lived_binding);
    }
    // End of the block

    // Error! `short_lived_binding` doesn't exist in this scope
    // println!("outer short: {}", short_lived_binding);
    // FIXME ^ Comment out this line

    println!("outer long: {}", long_lived_binding);

    let shadowed_binding = 1;

    {
	println!("before being shadowed: {}", shadowed_binding);

	// This binding *shadows* the outer one
	let shadowed_binding = "abc";

	println!("shadowed in inner block: {}", shadowed_binding);
    }
    println!("outside inner block: {}", shadowed_binding);

    // This binding *shadows* the previous binding
    let shadowed_binding = 2;
    println!("shadowed in outer block: {}", shadowed_binding);

    // Declare a variable binding
    let a_binding;

    {
	let x = 2;

	// Initialize the binding
	a_binding = x * x;
    }

    println!("a binding: {}", a_binding);

    let another_binding;

    // Error! Use of uninitialized binding
    // println!("another binding: {}", another_binding);
    // FIXME ^ Comment out this line

    another_binding = 1;

    println!("another binding: {}", another_binding);

    let mut _mutable_integer = 7i32;

    {
	// Shadowing by immutable `_mutable_integer`
	let _mutable_integer = _mutable_integer;

	// Error! `_mutable_integer` is frozen in this scope
	// _mutable_integer = 50;
	// FIXME ^ Comment out this line

	// `_mutable_integer` goes out of scope
    }

    // Ok! `_mutable_integer` is not frozen in this scope
    _mutable_integer = 3;
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
