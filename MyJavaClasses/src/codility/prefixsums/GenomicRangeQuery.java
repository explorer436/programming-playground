package codility.prefixsums;

import java.util.Arrays;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C,
 * G and T, which correspond to the types of successive nucleotides in the
 * sequence. Each nucleotide has an impact factor, which is an integer.
 * Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4,
 * respectively. You are going to answer several queries of the form: What is
 * the minimal impact factor of nucleotides contained in a particular part of
 * the given DNA sequence?
 * 
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1]
 * consisting of N characters. There are M queries, which are given in non-empty
 * arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M)
 * requires you to find the minimal impact factor of nucleotides contained in
 * the DNA sequence between positions P[K] and Q[K] (inclusive).
 * 
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 The answers to these M
 * = 3 queries are as follows:
 * 
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C
 * (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose
 * impact factor is 4, so the answer is 4. The part between positions 0 and 6
 * (the whole string) contains all nucleotides, in particular nucleotide A whose
 * impact factor is 1, so the answer is 1. Write a function:
 * 
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * 
 * that, given a non-empty zero-indexed string S consisting of N characters and
 * two non-empty zero-indexed arrays P and Q consisting of M integers, returns
 * an array consisting of M integers specifying the consecutive answers to all
 * queries.
 * 
 * The sequence should be returned as:
 * 
 * a Results structure (in C), or a vector of integers (in C++), or a Results
 * record (in Pascal), or an array of integers (in any other programming
 * language). For example, given the string S = CAGCCTA and arrays P, Q such
 * that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 the function should
 * return the values [2, 4, 1], as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; M is an integer within the
 * range [1..50,000]; each element of arrays P, Q is an integer within the range
 * [0..N − 1]; P[K] ≤ Q[K], where 0 ≤ K < M; string S consists only of
 * upper-case English letters A, C, G, T. Complexity:
 * 
 * expected worst-case time complexity is O(N+M); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments).
 */
public class GenomicRangeQuery
{

	public static void main(String[] args)
	{
		for (int i : solution("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 }))
		{
			System.out.println("result i : " + i);
		}

		// System.out.println("result : " + solution(6, 11, 3));

		// System.out.println("result : " + solution(11, 345, 17));//answer should be 20

		/*
		 * A = 11, B = 345, K = 17 WRONG ANSWER got 19 expected 20
		 */

		/*
		 * System.out.println("result : " + solution(2, A3));
		 * 
		 * System.out.println("result : " + solution(3, A4));
		 * 
		 * System.out.println("result : " + solution(1, A5));
		 * 
		 * System.out.println("result : " + solution(2, A5));
		 */
	}

	public static int[] solution(String S, int[] P, int[] Q)
    {

        char[] chars_from_s_array = S.toCharArray();
        System.out.println("chars_from_s_array.length : " + chars_from_s_array.length);

        // 4 X 8 array
        // 4 columns - each column for each letter A, C, G, T
        // 8 rows
        int[][] cumulativeAnswers = new int[chars_from_s_array.length + 1][4];

        // run for loop on S = CAGCCTA
        for (int location_in_s_array = 0; location_in_s_array < chars_from_s_array.length; location_in_s_array++)
        {
            System.out.println(">>> location_in_s_array : " + location_in_s_array);

            // Leave the first row with all zeroes.
            // Do not change it.
            // We will use this to keep count of each char in the string
            if (location_in_s_array > 0)
            {
                copyRowToNextRow(cumulativeAnswers, location_in_s_array);

                System.out.println("cumulativeAnswers : ");
                System.out.println(print2DArray(cumulativeAnswers));
            }

            incrementCountBasedOnLetterAtCurrentPostition(chars_from_s_array, cumulativeAnswers, location_in_s_array);

            // printing
            System.out.println("after incrementing the letter count for location " + location_in_s_array + " - ");
            System.out.println(print2DArray(cumulativeAnswers));
        }
        // end of the for loop for each letter in the string S

        // finally, populate an element at each location in answerArray
        return extractFinalAnswer(P, Q, cumulativeAnswers);
    }

    private static int[] extractFinalAnswer(int[] P, int[] Q, int[][] cumulativeAnswers)
    {
        // P.length = Q.length and this will be the length of the final answer array
        int[] answerArray = new int[P.length];

        // just subtract the values from the columns for each letter
        // to figure out if the letter is present within the limits
        for (int i = 0; i < P.length; i++)
        {
            // j stands for the letters A,C,G,T
            for (int j = 0; j < 4; j++)
            {
                if ((cumulativeAnswers[Q[i] + 1][j] - cumulativeAnswers[P[i]][j]) > 0)
                {
                    answerArray[i] = j + 1;
                    break;
                }
            }
        }

        return answerArray;
    }

    private static void incrementCountBasedOnLetterAtCurrentPostition(char[] chars_from_s_array,
        int[][] cumulativeAnswers, int location_in_s_array)
    {
        switch (chars_from_s_array[location_in_s_array])
        {
            case 'A':
                cumulativeAnswers[location_in_s_array + 1][0] = cumulativeAnswers[location_in_s_array + 1][0] + 1;
                break;
            case 'C':
                cumulativeAnswers[location_in_s_array + 1][1] = cumulativeAnswers[location_in_s_array + 1][1] + 1;
                break;
            case 'G':
                cumulativeAnswers[location_in_s_array + 1][2] = cumulativeAnswers[location_in_s_array + 1][2] + 1;
                break;
            case 'T':
                cumulativeAnswers[location_in_s_array + 1][3] = cumulativeAnswers[location_in_s_array + 1][3] + 1;
                break;
        }
    }

    // just copy the previous row into the current row to preserve count
    private static void copyRowToNextRow(int[][] cumulativeAnswers, int location_in_s_array)
    {
        for (int eachLettersInDnaSequence = 0; eachLettersInDnaSequence < 4; eachLettersInDnaSequence++)
        {
            System.out.println("eachLettersInDnaSequence : " + eachLettersInDnaSequence);

            cumulativeAnswers[location_in_s_array
                + 1][eachLettersInDnaSequence] = cumulativeAnswers[location_in_s_array][eachLettersInDnaSequence];
        }
    }

    private static String print2DArray(int[][] array)
    {
        return Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
    }
}
