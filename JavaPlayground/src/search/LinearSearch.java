package search;

public class LinearSearch {

	public static void main(String[] args) {
		int[] anArray = new int[] {1,2,3,4,5,6,7,8,9,10};

		System.out.println(linearSearch(anArray, 4));
		System.out.println(linearSearch(anArray, 8888));
	}
	
	public static int linearSearch(int[] anArray, int value)
	{
		for (int i = 0; i < anArray.length; i++)
		{
			if (anArray[i] == value)
			{
				return i;
			}
		}
		return -1;
	}

}
