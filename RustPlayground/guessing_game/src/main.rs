use std::io;
// The io library comes from the standard library, known as std.

fn main() {
    println!("Guess the number!");
    println!("Please input your guess!");
    let mut guess = String::new();

    io::stdin()
        .read_line(&mut guess)
	.expect("Failed to read line");

    println!("You guessed: {}", guess);
}

// The full job of read_line is to take whatever the user types into standard input and append that into a string (without overwriting its contents), so we therefore pass that string as an argument. The string argument needs to be mutable so the method can change the string’s content.
