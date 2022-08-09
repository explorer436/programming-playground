use std::io;
// The io library comes from the standard library, known as std.
use rand::Rng;
use std::cmp::Ordering;

fn main() {
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1..101);

    // println!("The secret number is: {}", secret_number);

    loop {
        println!("Please input your guess!");
        let mut guess = String::new();
    
        io::stdin()
            .read_line(&mut guess)
    	.expect("Failed to read line");
    
        // let guess: u32 = guess.trim().parse().expect("Please type a number!");

       let guess: u32 = match guess.trim().parse() {
           Ok(num) => num,
            Err(_) => continue,
       };
    
        println!("You guessed: {}", guess);
    
        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
		break;
	    }
        }
    }
}

// The full job of read_line is to take whatever the user types into standard input and append that into a string (without overwriting its contents), so we therefore pass that string as an argument. The string argument needs to be mutable so the method can change the string’s content.
