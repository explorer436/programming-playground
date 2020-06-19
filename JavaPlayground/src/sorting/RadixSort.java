package sorting;

import utility.PrintUtils;

/**
 * 
	Assumption: The data has the same radix and width.
	
	A radix is the number of unique values or numbers that the input has.
	e.g. the radix for the decimal system is 10 - because there are 10 possible numbers in it - 0 to 9.
	for binary system, it is 2.
	for the english alphabet, it is 26.
	
	Width is number of digits or letters in the input.
	e.g. width of "hello" is 5.
	width of [1, 2, 3, 4] is 4.
	width of the number "10" is 2.
	
	Remember: For this, we have to use a stable sorting algorithm at each stage.
 *
 */
public class RadixSort {
		
	/**
	 * 
	 	example input array : 
	 	[ 4725, 4586, 1330, 8792, 1594, 5729 ]
	 	
	 	first, sort using the units position.
	 	
	 	[ 1330, 8792, 1594, 4725, 4586, 5729 ]
	 	
	 	then, sort using the tens position.
	 	
	 	[ 1330, 4725, 5729, 4586, 8792, 1594 ]
	 	
	 	then, sort using the hundreds position.
	 	
	 	[ 1330, 4586, 1594, 4725, 5729, 8792 ]
	 	
	 	then, sort using the thousands position.
	 	
	 	[ 1330, 1594, 4586, 4725, 5729, 8792 ]
	 * 
	 */
	
	/**
		Counting sort is used as the algorthm for radix sort - must be stable counting sort.
	 */
	
    public static void main(String[] args) {

        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };

        radixSort(radixArray, 10, 4);
        
        PrintUtils.printArray(radixArray);

    }

    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] =
                    input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }


    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

	
}
