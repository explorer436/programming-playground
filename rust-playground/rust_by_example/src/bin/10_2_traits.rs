// Why do we need Traits in the first place?
// Because, in Rust, we don't have Object inheritance - or Struct inheritance.

// Traits are similar to "interfaces" in other languages.
// Rust takes "Composition over Inheritance" approach.
// Traits define required behavior - functions and methods that a Struct must implement, if it wants to have that Trait.
// Another interesting thing:
// Traits implement inheritance.

// Why bother with Traits?
// Why don't we just write the impls in the Structs without using Traits?
// With Traits, we can start writing generic functions that can be implemented by any Struct that wants to implement the Trait.

trait Person {
    fn name(&self) -> String;
}

// Person is a supertrait of Student.
// Implementing Student requires you to also impl Person.
trait Student: Person {
    fn university(&self) -> String;
}

trait Programmer {
    fn fav_language(&self) -> String;
}

// CompSciStudent (computer science student) is a subtrait of both Programmer
// and Student. Implementing CompSciStudent requires you to impl both supertraits.
trait CompSciStudent: Programmer + Student {
    fn git_username(&self) -> String;
}

#[allow(dead_code)]
fn comp_sci_student_greeting(student: &dyn CompSciStudent) -> String {
    format!(
        "My name is {} and I attend {}. My favorite language is {}. My Git username is {}",
        student.name(),
        student.university(),
        student.fav_language(),
        student.git_username()
    )
}

fn main() {}
