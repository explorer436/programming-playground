package com.my.company.numbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Print all the odd numbers between a lower limit and an upper limit
 * 
 */
public class FindOddNumbersBetweenLAndR
{

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(solution(2, 5)));
		
		System.out.println();
		
		System.out.println(Arrays.toString(solution(-5, 5)));
	}

	public static int[] solution(int l, int r)
	{
		List<Integer> result = new ArrayList<Integer>();
		for (int i = l; i <= r; i++)
		{
			if (i % 2 != 0)
			{
				result.add(i);
			}
		}
		
		// alternative to using result.toArray();

		int[] series = {};
		for (int i : result)
		{
			series = addElement(series, i);
		}
		return series;
	}

	static int[] addElement(int[] a, int e)
	{
		a = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}
}
