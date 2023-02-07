// How did this file come about?
// Cargo made it for us.

// Why are we adding this line?
// Because, we need to tell Rust that first.rs is something that our lib uses.
pub mod first;


pub fn add(left: usize, right: usize) -> usize {
    left + right
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn it_works() {
        let result = add(2, 2);
        assert_eq!(result, 4);
    }
}
