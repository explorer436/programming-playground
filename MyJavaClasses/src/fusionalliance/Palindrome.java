package fusionalliance;

public class Palindrome {    
   
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
	
	public static boolean isPalindrome(String word) {
        StringBuilder rev = new StringBuilder();

        String orig = word.replaceAll("\\s+", "").toLowerCase();

        char[] plain = orig.toCharArray();

        for (int i = plain.length - 1; i  >= 0; i--) {
            rev.append(plain[i]);
        }

        return (rev.toString().equals(orig));

    }
}