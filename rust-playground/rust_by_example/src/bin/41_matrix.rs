use std::fmt;

// The following struct is for the activity.
#[derive(Debug)]
struct Matrix(f32, f32, f32, f32);

// Implement `Display` for `MinMax`.
impl fmt::Display for Matrix {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let matrix = &self;

        // destructuring
        let (a, b, c, d) = (matrix.0, matrix.1, matrix.2, matrix.3);
        // println!("{:?}, {:?}, {:?}, {:?}", a, b, c, d);

        // Use `self.number` to refer to each positional data point.
        write!(f, "({} {}) \n", a, b)?;
        write!(f, "({} {})", c, d)
    }
}

fn transpose(matrix: Matrix) -> Matrix {
    // destructuring
    let (a, b, c, d) = (matrix.0, matrix.1, matrix.2, matrix.3);
    // println!("{:?}, {:?}, {:?}, {:?}", a, b, c, d);
    Matrix(a, c, b, d)
}

fn main() {
    let matrix = Matrix(1.1, 1.2, 2.1, 2.2);
    println!("{:?}", matrix);
    println!("{}", matrix);
    println!("transposed matrix is \n{}", transpose(matrix));
}
