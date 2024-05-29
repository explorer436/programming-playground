fn main() {
    let fibonacci = std::iter::successors(Some((0, 1)), |&(prev, next)| Some((next, prev + next)))
		    .map(|(val, _)| val);

    // The `take(n)` method reduces an `Iterator` to its first `n` terms.
    println!("The first four terms of the Fibonacci sequence are: ");
    /*for i in fibonacci.take(4) {
        println!("> {}", i);
    }*/

    // The `skip(n)` method shortens an `Iterator` by dropping its first `n` terms.
    println!("the next six terms of the fibonacci sequence are: ");
    for i in fibonacci.skip(4).take(6) {
        println!("> {}", i);
    }

}
