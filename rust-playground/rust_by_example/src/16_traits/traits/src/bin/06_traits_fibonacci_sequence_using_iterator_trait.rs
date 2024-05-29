struct Fibonacci {
    curr: u32,
    next: u32,
}

// Implement `Iterator` for `Fibonacci`.
// See "Iterator.rs"
// The `Iterator` trait only requires a method to be defined for the `next` element.
impl Iterator for Fibonacci {

    // type Item is mandatory for Iterator trait. See "Iterator.rs"
    type Item = u32; // We can refer to this type using Self::Item


    // Here, we define the sequence using `.curr` and `.next`.
    // The return type is `Option<T>`:
    //     * When the `Iterator` is finished, `None` is returned.
    //     * Otherwise, the next value is wrapped in `Some` and returned.
    // We use Self::Item in the return type, so we can change
    // the type without having to update the function signatures.
    fn next(&mut self) -> Option<Self::Item> {
        let temp = self.curr;

        self.curr = self.next;
        self.next = self.next + temp;

        // Since there's no endpoint to a Fibonacci sequence, the `Iterator`
        // will never return `None`, and `Some` is always returned.
        Some(temp)
    }
}

// Returns a Fibonacci sequence generator until infinity
fn fibonacci_sequence_generator() -> Fibonacci {
    Fibonacci { curr: 0, next: 1 }
}

fn main() {

    // The `fibonacci sequence is:
    /*println!("The `fibonacci sequence is: ");
    for i in fibonacci() {
    println!("> {}", i);
    }*/

    // The `take(n)` method reduces an `Iterator` to its first `n` terms.
    println!("The first four terms of the Fibonacci sequence are: ");
    for i in fibonacci_sequence_generator().take(100) {
        println!("> {}", i);
    }

    // The `skip(n)` method shortens an `Iterator` by dropping its first `n` terms.
    println!("The next six terms of the Fibonacci sequence are: ");
    for i in fibonacci_sequence_generator().skip(4).take(6) {
        println!("> {}", i);
    }

}
