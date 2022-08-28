What Are Arrays?

How does array resizing work : 
Array variables (references) are reusable; 
to change the length of an array, 
we can create a new array of the desired length and assign it to the original array variable.


    int arrayOfInt[] = new int[7];
    String arrayOfString[] = new String[4];

In the preceding declarations, arrayOfInt is an array of seven int values. Because int is a
primitive type, there is no need to allocate any additional space after the new call. The array
already is assigned enough contiguous memory to hold seven ints. 

The arrayOfString allocation call is a little different. 
The new operator assigns enough contiguous memory for the handles to four Strings; 
it does not allocate the memory for the String objects
themselves. The String memory must be created separately, as shown in this code:

    int arrayOfInt[] = new int[7];
    String arrayOfString[] = new String[4];
    
    for( int i = 0; i < 7; i++ )
    {
    	arrayOfInt[i] = i;
    }
    
    arrayOfString[0] = new String("Hello");
    arrayOfString[1] = new String("World");
    arrayOfString[2] = new String("It's");
    arrayOfString[3] = "Me";

The final statement is an implicit call to the following:
arrayOfString[3] = new String("Me");

For details about memory allocation and management, see Vectors/Notes.md

