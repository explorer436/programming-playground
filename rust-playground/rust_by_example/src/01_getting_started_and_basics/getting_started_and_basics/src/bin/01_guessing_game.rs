use std::io;
// The io library comes from the standard library, known as std.
use rand::Rng;
// https://crates.io/crates/rand
use std::cmp::Ordering;

fn main() {
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1..101);

    println!("The secret number is: {}", secret_number);

    loop {
        println!("Please input your guess!");
        let mut guessed_string = String::new();

        // Rust has a strong, static type system.
        // However, it also has type inference.
        // When we wrote let mut guessed_string = String::new(),
        // Rust was able to infer that guessed_string should be a String and didn’t make us write the type.

        io::stdin()
            .read_line(&mut guessed_string)
            .expect("Failed to read line");

        println!("You guessed: {}", guessed_string);

        // Convert the string that the user entered into a number

        // let guessed_number: u32 = guessed_string.trim().parse().expect("Please type a number!");

        // The parse method on strings converts a string to another type.
        // Here, we use it to convert from a string to a number.
        // We need to tell Rust the exact number type we want by using let guess: u32.
        let guessed_number: u32 = match guessed_string.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
            // We switch from an expect call to a match expression
            // to move from crashing on an error to handling the error.
            // Remember that parse returns a Result type and
            // Result is an enum that has the variants Ok and Err.
            // We’re using a match expression here.

            // If parse is able to successfully turn the string into a number,
            // it will return an Ok value that contains the resultant number.
            // That Ok value will match the first arm’s pattern,
            // and the match expression will just return the num value that parse produced and
            // put inside the Ok value.
            // That number will end up right where we want it in the new guessed_number variable we’re creating.

            // If parse is not able to turn the string into a number,
            // it will return an Err value that contains more information about the error.
            // The Err value does not match the Ok(num) pattern in the first match arm,
            // but it does match the Err(_) pattern in the second arm.
            // The underscore, _, is a catchall value;
            // in this example, we’re saying we want to match all Err values,
            // no matter what information they have inside them.
            // So the program will execute the second arm’s code, continue,
            // which tells the program to go to the next iteration of the loop and
            // ask for another guess. So, effectively,
            // the program ignores all errors that parse might encounter!
        };

        // The Ordering type is another enum and has the variants Less, Greater, and Equal.
        // These are the three outcomes that are possible when you compare two values.

        // The cmp method compares two values and can be called on anything that can be compared.
        // It takes a reference to whatever you want to compare with:
        // here it’s comparing guess to secret_number.

        // https://doc.rust-lang.org/stable/book/ch06-02-match.html
        // We use a match expression to decide what to do next based on
        // which variant of Ordering was returned from the call to cmp
        // with the values in guess and secret_number.
        match guessed_number.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
        // A match expression is made up of arms.
        // An arm consists of a pattern to match against,
        // and the code that should be run if the value given to match fits that arm’s pattern.
        // Rust takes the value given to match and looks through each arm’s pattern in turn.
        // Patterns and the match construct are powerful Rust features:
        // they let you express a variety of situations your code might encounter and
        // they make sure you handle them all.
    }
}

// The full job of read_line is to take whatever the user types into standard input and append that into a string (without overwriting its contents), so we therefore pass that string as an argument. The string argument needs to be mutable so the method can change the string’s content.
