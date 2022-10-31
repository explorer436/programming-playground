package com.my.company.datastructures.trees;

public class TreeNode {
	
	private int data;
	
	private TreeNode leftChild;
	
	private TreeNode rightChild;

	public TreeNode(int data) {
		super();
		this.data = data;
	}
	
	public void insert(int value)
	{
		if (value == data)
		{
			// It is a duplicate. 
			// We don't want to support duplicates. So, don't do anything.
			return;
		}
		else if (value < data)
		{
			if (leftChild == null)
			{
				leftChild = new TreeNode(value);
			}
			else
			{
				leftChild.insert(value);
			}
		}
		else if (value > data)
		{
			if (rightChild == null)
			{
				rightChild = new TreeNode(value);
			}
			else
			{
				rightChild.insert(value);
			}
		}
	}
	
	public void traverseInOrder()
	{
		// visit the leftChild first.
		if (leftChild != null)
		{
			leftChild.traverseInOrder();
		}
		
		// visit the current node.
		System.out.print(data + ", ");
		
		// And then, visit the rightChild.
		if (rightChild != null)
		{
			rightChild.traverseInOrder();
		}
	}
	
	public void traversePreOrder()
	{
		// visit the current node.
		System.out.print(data + ", ");
				
		// after that, visit the leftChild.
		if (leftChild != null)
		{
			leftChild.traversePreOrder();
		}
		
		// And then, visit the rightChild.
		if (rightChild != null)
		{
			rightChild.traversePreOrder();
		}
	}
	
	public TreeNode get(int value)
	{
		if (value == data)
		{
			return this;
		}
		else if (value < data)
		{
			if (leftChild != null)
			{
				return leftChild.get(value);
			}
		}
		else if (value > data)
		{
			if (rightChild != null)
			{
				return rightChild.get(value);
			}
		}
		
		return null;
	}
	
	public int min()
	{
		if (leftChild == null)
		{
			return data;
		}
		else
		{
			return leftChild.min();
		}
	}
	
	public int max()
	{
		if (rightChild == null)
		{
			return data;
		}
		else
		{
			return rightChild.max();
		}
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}
	
	
}
