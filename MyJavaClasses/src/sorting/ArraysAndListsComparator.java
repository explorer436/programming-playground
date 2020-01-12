package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Suppose we want sort fruits by their name and quantity also. 
 * When we make a collection element comparable(by having it implement Comparable), 
 * we get only one chance to implement the compareTo() method. 
 * The solution is using Comparator.
 */
public class ArraysAndListsComparator
{

	public static void main(String[] args)
	{
		Fruit[] fruitsArray = new Fruit[5];

		Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 60, 4);
		Fruit apple = new Fruit("Apple", "Apple description", 100, 1);
		Fruit orange = new Fruit("Orange", "Orange description", 70, 2);
		Fruit banana = new Fruit("Banana", "Banana description", 90, 3);
		Fruit cranberry = new Fruit("cranberry", "cranberry description", 80, 5);

		fruitsArray[0] = pineappale;
		fruitsArray[1] = apple;
		fruitsArray[2] = orange;
		fruitsArray[3] = banana;
		fruitsArray[4] = cranberry;

		List<Fruit> fruitsList = new ArrayList<Fruit>();
		fruitsList.add(pineappale);
		fruitsList.add(apple);
		fruitsList.add(orange);
		fruitsList.add(banana);
		fruitsList.add(cranberry);

		System.out.println("call sort");
		Arrays.sort(fruitsArray);
		for (Fruit f : fruitsArray)
		{
			printFruit(f);
		}

		System.out.println("using the name of the comparator");
		Arrays.sort(fruitsArray, Fruit.FruitNameComparator);
		for (Fruit f : fruitsArray)
		{
			printFruit(f);
		}

		System.out.println("sorting the list");
		Collections.sort(fruitsList);
		for (Fruit f : fruitsList)
		{
			printFruit(f);
		}

		System.out.println("sorting the list in reverse order");
		Collections.sort(fruitsList, Collections.reverseOrder());
		for (Fruit f : fruitsList)
		{
			printFruit(f);
		}

		System.out.println("sorting the list by name using comparator");
		Collections.sort(fruitsList, new NameCompare());
		for (Fruit f : fruitsList)
		{
			printFruit(f);
		}

		System.out.println("sorting the list by rating using comparator");
		Collections.sort(fruitsList, new RatingCompare());
		for (Fruit f : fruitsList)
		{
			printFruit(f);
		}

		System.out.println("sorting the list by quantity using comparator");
		Collections.sort(fruitsList, new QuantityCompare());
		for (Fruit f : fruitsList)
		{
			printFruit(f);
		}
	}

	// Class to compare Fruits by ratings

	static class Fruit implements Comparable<Fruit>
	{

		private String fruitName;
		private String fruitDesc;
		private int quantity;
		private int rating;

		public Fruit(String fruitName, String fruitDesc, int quantity, int rating)
		{
			super();
			this.fruitName = fruitName;
			this.fruitDesc = fruitDesc;
			this.quantity = quantity;
			this.rating = rating;
		}

		public String getFruitName()
		{
			return fruitName;
		}

		public void setFruitName(String fruitName)
		{
			this.fruitName = fruitName;
		}

		public String getFruitDesc()
		{
			return fruitDesc;
		}

		public void setFruitDesc(String fruitDesc)
		{
			this.fruitDesc = fruitDesc;
		}

		public int getQuantity()
		{
			return quantity;
		}

		public void setQuantity(int quantity)
		{
			this.quantity = quantity;
		}

		public int getRating()
		{
			return rating;
		}

		public void setRating(int rating)
		{
			this.rating = rating;
		}

		public int compareTo(Fruit compareFruit)
		{
			int compareQuantity = ((Fruit) compareFruit).getQuantity();

			// ascending order
			return this.quantity - compareQuantity;

			// descending order
			// return compareQuantity - this.quantity;
		}

		public final static Comparator<Fruit> FruitNameComparator = new Comparator<Fruit>()
		{
			public int compare(Fruit fruit1, Fruit fruit2)
			{
				String fruitName1 = fruit1.getFruitName().toUpperCase();
				String fruitName2 = fruit2.getFruitName().toUpperCase();

				// ascending order
				return fruitName1.compareTo(fruitName2);

				// descending order
				// return fruitName2.compareTo(fruitName1);
			}
		};

		public final static Comparator<Fruit> RatingComparator = new Comparator<Fruit>()
		{
			public int compare(Fruit fruit1, Fruit fruit2)
			{
				int fruitRating1 = fruit1.getRating();
				int fruitRating2 = fruit2.getRating();

				// ascending order
				if (fruitRating1 < fruitRating2)
					return -1;
				if (fruitRating1 > fruitRating2)
					return 1;
				else
					return 0;
				// return fruitRating1.compareTo(fruitRating2);

				// descending order
				// return fruitName2.compareTo(fruitName1);
			}
		};
	}

	// Class to compare Fruits by ratiing
	static class RatingCompare implements Comparator<Fruit>
	{
		public int compare(Fruit f1, Fruit f2)
		{
			if (f1.getRating() < f2.getRating())
				return -1;
			if (f1.getRating() > f2.getRating())
				return 1;
			else
				return 0;
		}
	}

	// Class to compare Fruits by name
	static class NameCompare implements Comparator<Fruit>
	{
		public int compare(Fruit f1, Fruit f2)
		{
			String fruitName1 = f1.getFruitName().toUpperCase();
			String fruitName2 = f2.getFruitName().toUpperCase();

			// ascending order
			return fruitName1.compareTo(fruitName2);

			// descending order
			// return fruitName2.compareTo(fruitName1);
		}
	}

	// Class to compare Fruits by rating
	static class QuantityCompare implements Comparator<Fruit>
	{
		public int compare(Fruit f1, Fruit f2)
		{
			if (f1.getQuantity() < f2.getQuantity())
				return -1;
			if (f1.getQuantity() > f2.getQuantity())
				return 1;
			else
				return 0;
		}
	}

	public static void printFruit(Fruit f)
	{
		System.out.print("\t{");
		System.out.print("\"FruitName\":" + f.getFruitName() + ",");
		System.out.print("\"FruitDesc\":\"" + f.getFruitDesc() + "\",");
		System.out.print("\"Quantity\":" + f.getQuantity() + "\",");
		System.out.print("\"Rating\":" + f.getRating() + "\"}");
		System.out.print("\n");
	}

}
