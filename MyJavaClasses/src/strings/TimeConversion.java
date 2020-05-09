package strings;

/**
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.

Function Description:
Complete the timeConversion function in the editor below. 
It should return a new string representing the input time in 24 hour format.

timeConversion has the following parameter(s):
    s: a string representing time in 12 hour format

Input Format:
A single string s containing a time in 12-hour clock format (i.e. hh:mm:ssAM or hh:mm:ssPM), where 01 <= hh <= 12 and 00 <= mm, ss <= 59.

Constraints:
    All input times are valid

Output Format:
Convert and print the given time in 24-hour format, where 00 <= hh <= 23.

Sample Input 0
07:05:45PM

Sample Output 0
19:05:45
 */

public class TimeConversion {
    
	public static void main(String[] args) {
		System.out.println("24-hour format for 07:05:45PM is : " + timeConversion("07:05:45PM"));
		
		System.out.println("24-hour format for 07:05:45AM is : " + timeConversion("07:05:45AM"));
		
		System.out.println("24-hour format for 12:00:00AM is : " + timeConversion("12:00:00AM"));
		
		System.out.println("24-hour format for 12:00:00PM is : " + timeConversion("12:00:00PM"));
	}
	
	static String timeConversion(String s) {
		String[] values = s.split(":");
		
		String hourValue = values[0];
		
		if ("PM".equals(values[2].substring(2)) && !"12".equals(hourValue))
		{
			hourValue = String.valueOf(Integer.valueOf(hourValue) + 12);
		}
		
		if ("AM".equals(values[2].substring(2)) && "12".equals(hourValue))
		{
			hourValue = "00";
		}
		
		return hourValue + ":" + values[1] + ":" + values[2].substring(0,2);
				
	}
}
