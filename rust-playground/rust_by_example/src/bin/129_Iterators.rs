// Iterator is a Trait.
//https://doc.rust-lang.org/std/iter/trait.Iterator.html 
// It is used for dealing with iterators.
// https://doc.rust-lang.org/std/iter/index.html
// https://doc.rust-lang.org/std/iter/index.html#implementing-iterator


// Required Associated Types: type Item
// Required Methods: "next()"


fn main() {

    // `0..3` is an `Iterator` that generates: 0, 1, and 2.
    let mut sequence = 0..3;

    println!("Calling sequence.next consecutively");
    println!("> {:?}", sequence.next());
    println!("> {:?}", sequence.next());
    println!("> {:?}", sequence.next());
    println!("> {:?}", sequence.next());
    println!("> {:?}", sequence.next());
    println!("> {:?}", sequence.next());


    // `for` works through an `Iterator` until it returns `None`.
    // Each `Some` value is unwrapped and bound to a variable (here, `i`).
    println!("Iterate through 0..3 using `for`");
    for i in 0..3 {
        println!("> {}", i);
    }


    // The `iter` method produces an `Iterator` over an array/slice.
    let array = [1u32, 3, 3, 7];
    println!("Iterate the following array {:?}", &array);
    for i in array.iter() {
        println!("> {}", i);
    }

}
