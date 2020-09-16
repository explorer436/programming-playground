package datastructures.trees;

public class TreeClient {

	public static void main(String[] args) {
		Tree intTree = new Tree();
		intTree.insert(25);
		intTree.insert(20);
		intTree.insert(15);
		intTree.insert(27);
		intTree.insert(30);
		intTree.insert(29);
		intTree.insert(26);
		intTree.insert(22);
		intTree.insert(32);
		intTree.insert(17);
		
		/**
		 * 
		 			    25
		 			   /  \ 
					  /    \
					 /      \
					20       27
  				   /  \     /  \
  				  /    \   /    \
				 15    22 26   30
				  \	           / \
				  17	     29  32
		 * 
		 */
		
		intTree.traverseInOrder(); // The results will be in ascending order.
		// 15, 17, 20, 22, 25, 26, 27, 29, 30, 32
		
		System.out.println("");
		
		intTree.traversePreOrder();
		// 25, 20, 15, 17, 22, 27, 26, 30, 29, 32
		
		System.out.println("");
		
		System.out.println(intTree.get(27));
		System.out.println(intTree.get(17));
		System.out.println(intTree.get(8888));
		
		System.out.println("");
		
		System.out.println(intTree.min());
		System.out.println(intTree.max());
		
		System.out.println("");
		System.out.println("done");
		
		System.out.println("");
		
		// intTree.delete(15);
		// intTree.traverseInOrder();
		
		// intTree.delete(27);
		// intTree.traverseInOrder();
		
		// intTree.delete(25);
		// intTree.traverseInOrder();
		
		// intTree.delete(8888);
		// intTree.traverseInOrder();
	}

}
