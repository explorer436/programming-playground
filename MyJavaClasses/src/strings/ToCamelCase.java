package strings;

/**
 * 
 * Complete the method/function so that it converts 
 * dash/underscore delimited words into camel casing. 
 * The first word within the output should be capitalized only if the original word was capitalized 
 * (known as Upper Camel Case, also often referred to as Pascal case).
Examples

toCamelCase("the-stealth-warrior"); // returns "theStealthWarrior"

toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
 *
 */
public class ToCamelCase {

	public static void main(String[] args) {
		System.out.println(toCamelCase("the-stealth-warrior"));
		
		System.out.println();
		
		System.out.println(toCamelCase("The_Stealth_Warrior"));
		
		System.out.println();
		
		System.out.println(toCamelCase("The-Stealth_Warrior"));
		
		System.out.println();
		
		System.out.println(toCamelCase("theStealthWarrior"));
		

	}
	
	// Convert the initial string into a StringBuffer and manipulate the StringBuffer.
	static String toCamelCase(String s){
		StringBuffer sb = new StringBuffer(s);
			for (int i = 0; i < sb.length(); i++) {
				if ((sb.charAt(i)=='_')||(sb.charAt(i)=='-'))
				{   
					sb.setCharAt(i+1, Character.toUpperCase((sb.charAt(i+1))));
					sb.deleteCharAt(i);
				}
			}
		return sb.toString();
	}
	
	// Trying functional programming approach.
	// Apply a series of functions to get the final result.
	static String toCamelCase2(String s){
	    return replaceHyphens(replaceUnderscores(s));
	}

	private static String replaceUnderscores(String s) {
		if (s.contains("_"))
		{
			String[] values = s.split("_");
			
			StringBuffer sb = new StringBuffer();
			sb.append(values[0]);
			for (int i = 1; i < values.length; i++)
			{
				sb.append(values[i].substring(0, 1).toUpperCase() + values[i].substring(1));
			}
			
			return sb.toString();
		}
		else
		{
			return s;
		}
	}

	private static String replaceHyphens(String s) {
		if (s.contains("-"))
		{
			String[] values = s.split("-");
			
			StringBuffer sb = new StringBuffer();
			sb.append(values[0]);
			for (int i = 1; i < values.length; i++)
			{
				sb.append(values[i].substring(0, 1).toUpperCase() + values[i].substring(1));
			}
			
			return sb.toString();
		}
		else
		{
			return s;
		}
	}

}
