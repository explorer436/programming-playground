When implementing FixedCapacityStack , we do not know
the actual type of Item , but a client can use our stack for any type of data by providing a
concrete type when the stack is created. Concrete types must be reference types, but cli-
ents can depend on autoboxing to convert primitive types to their corresponding wrap-
per types. Java uses the type parameter Item to check for type mismatch errors—even
though no concrete type is yet known, variables of type Item must be assigned values
of type Item , and so forth. But there is one significant hitch in this story: We would like
to implement the constructor in FixedCapacityStack with the code

	a = new Item[cap];
	
which calls for creation of a generic array. For historical and technical reasons beyond
our scope, generic array creation is disallowed in Java. Instead, we need to use a cast:

	a = (Item[]) new Object[cap];
	
This code produces the desired effect (though the Java compiler gives a warning, which
we can safely ignore), and we use this idiom throughout the book (the Java system li-
brary implementations of similar abstract data types use the same idiom).


Q. Why does Java disallow generic arrays?
A. Experts still debate this point. You might need to become one to understand it! For
starters, learn about covariant arrays and type erasure.

// TODO find out more about this.