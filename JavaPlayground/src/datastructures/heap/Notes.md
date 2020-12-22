In computer science, a heap is a specialized tree-based data structure which is essentially an almost complete tree that satisfies the heap property: in a max heap, for any given node C, if P is a parent node of C, then the key (the value) of P is greater than or equal to the key of C. In a min heap, the key of P is less than or equal to the key of C. The node at the "top" of the heap (with no parents) is called the root node.

The heap is one maximally efficient implementation of an abstract data type called a priority queue, and in fact, priority queues are often referred to as "heaps", regardless of how they may be implemented. In a heap, the highest (or lowest) priority element is always stored at the root. However, a heap is not a sorted structure; it can be regarded as being partially ordered. A heap is a useful data structure when it is necessary to repeatedly remove the object with the highest (or lowest) priority.

         22
	   /    \
	  19    18
	 / \   / \
	15  3 14  4
   /
  12 
  
  Array         : [22, 19, 18, 15, 3, 14, 4, 12]
  Array position: [0,   1,  2,  3, 4, 5,  6,  7]
  
  For the node at array[i] - 
  left child  = 2i + 1
  right child = 2i + 2
  
  parent = floor((i - 1)/2)
  
  --------------------------------
  
Operations
The common operations involving heaps are:

Basic
*	find-max (or find-min): find a maximum item of a max-heap, or a minimum item of a min-heap, respectively (a.k.a. peek)
*	insert: adding a new key to the heap (a.k.a., push[4])
*	extract-max (or extract-min): returns the node of maximum value from a max heap [or minimum value from a min heap] after removing it from the heap (a.k.a., pop)
*	delete-max (or delete-min): removing the root node of a max heap (or min heap), respectively
*	replace: pop root and push a new key. More efficient than pop followed by push, since only need to balance once, not twice, and appropriate for fixed-size heaps.

Creation
*	create-heap: create an empty heap
*	heapify: create a heap out of given array of elements
*	merge (union): joining two heaps to form a valid new heap containing all the elements of both, preserving the original heaps.
*	meld: joining two heaps to form a valid new heap containing all the elements of both, destroying the original heaps.

Inspection
*	size: return the number of items in the heap.
*	is-empty: return true if the heap is empty, false otherwise.

Internal
*	increase-key or decrease-key: updating a key within a max- or min-heap, respectively
*	delete: delete an arbitrary node (followed by moving last node and sifting to maintain heap)
*	sift-up: move a node up in the tree, as long as needed; used to restore heap condition after insertion. Called "sift" because node moves up the tree until it reaches the correct level, as in a sieve.
*	sift-down: move a node down in the tree, similar to sift-up; used to restore heap condition after deletion or replacement.
