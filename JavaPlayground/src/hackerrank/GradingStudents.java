package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradingStudents {
	
	public static void main(String[] args) {
		System.out.println("result for input " + Arrays.toString(new int[] { 73, 67, 38, 33 }) + " is ");
		List<Integer> inputList  = new ArrayList<Integer>();
		inputList.add(73);
		inputList.add(67);
		inputList.add(38);
		inputList.add(33);
		
		System.out.println(Arrays.toString(gradingStudents(inputList).toArray()));
		
		System.out.println();

	}
	
	static List<Integer> gradingStudents(List<Integer> grades) {
		for (int j = 0; j < grades.size(); j++)
		{
			int currentGrade = grades.get(j);
			if (currentGrade >= 38)
			{
				int mod5 = currentGrade % 5;
				
				int nextMultipleOf5 = (currentGrade - mod5) + 5;
				
				if (nextMultipleOf5 - currentGrade < 3)
				{
					grades.set(j, nextMultipleOf5);
				}
				else
				{
					grades.set(j, currentGrade);
				}
			}
		}
		return grades;
    }
    
}
