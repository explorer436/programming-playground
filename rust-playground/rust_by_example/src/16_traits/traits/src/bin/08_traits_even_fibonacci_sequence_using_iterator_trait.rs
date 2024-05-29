struct Fibonacci {
    curr: u64,
    next: u64,
}

// Implement `Iterator` for `Fibonacci`.
// See "Iterator.rs"
// The `Iterator` trait only requires a method to be defined for the `next` element.
impl Iterator for Fibonacci {

    // type Item is mandatory for Iterator trait. See "Iterator.rs"
    type Item = u64; // We can refer to this type using Self::Item


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

    let upper = 4 * 1000000;
    let even_fibonacci_sequence = fibonacci_sequence_generator()
        .filter(|&n| is_even(n))
        .take_while(|&n| n < upper); // Below upper limit

    let mut accumulator: u64 = 0;
    for i in even_fibonacci_sequence {
            accumulator = accumulator + i;
    }

    println!("the answer is: {}", accumulator);
}

// Correct answer is: 4,613,732


fn is_even(n: u64) -> bool {
    n % 2 == 0
}