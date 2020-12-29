/**
 * Merge.java
 *
 * This program implements Merge sort.
 *
 * @author Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 3
 * 10.14.19
 */

public class Merge {
    
    /**
     * Sort an array, in-place, using merging.
     * @param array The array to be sorted.
     * POSTCONDITION: The elements of array are in ascending order.
     */
    public static void sort(int[] array) {
	int[] sorted = mergeSort(array);
	
	// copies the array generated by mergeSort into the old array
	for (int i = 0; i < array.length; i++){
	    array[i] = sorted[i];
	}
    }

    /**
     * Extract the portion of an array from start up to (excluding) stop.
     * @param array The source array.
     * @param start The starting index (inclusive).
     * @param stop  The ending index (exclusive).
     * @return An array containing the same elements the portion of array.
     * PRECONDITION: 0 <= start <= stop <= array.length
     */
    private static int[] subarray(int[] array, int start, int stop) {
	//creates a new array with a length that is the difference between the start and stop
	int [] half = new int[stop-start];

	//values from the array are copied into the new array half
	for (int i = 0; i < stop-start; i++){
	    half[i] = array[i+start];
	}
	return half;
    }

    /**
     * Merge two sorted arrays into one new array.
     * @param first The first array, already sorted.
     * @param second The second array, already sorted.
     * @return A new array containing the elements of first and second,
     *         in order.
     */
    private static int[] merge(int[] first, int[] second) {
	//a new array is defined with a length of the combined array's lengths
	int size = first.length + second.length;
        int [] merged = new int [size];

	//each index variable keeps track of how far into the array is sorted, to ensure that no value is left out and that the method doesn't sort out of bounds of each array
	int firstIndex = 0;
	int secondIndex = 0;
	int mergedIndex = 0;

	while (mergedIndex < size){
 
	    //this inner while maintains that the loop doesn't try to evaluate past the array's limits/index values
	    while (firstIndex != first.length && secondIndex != second.length) {
	    
		if (first[firstIndex] < second[secondIndex]){
		    // the smaller of the two values is placed in the sorted array
		    merged[mergedIndex] = first[firstIndex];
		    firstIndex++; //the index is progressed because the value that is at that index has been accounted for in the sorted array
		    mergedIndex++;
		} else {
		    merged[mergedIndex] = second[secondIndex];
		    secondIndex++;
		    mergedIndex++;
		}
	    }

	    //this if else accounts for if one array is shorter than the other and thus "ends" earlier
	    //the remaining (and longer) array is then copied into rest of the index values of the sorted array

	    if (firstIndex == first.length){
		merged[mergedIndex] = second[secondIndex];
		mergedIndex++;
		secondIndex++;
	    } else {
		merged[mergedIndex] = first[firstIndex];
		mergedIndex++;
		firstIndex++;
	    }
	}

      	return merged;

    }

    /**
     * Sort an array by merging.
     * @param array The array to sort.
     * @return A new array containing the elements of array, in order.
     */
    private static int[] mergeSort(int[] array) {
	if (array.length == 1){
	    return array;
	}

	//even if the array's length is odd, it will evaluate and round the middle point to make one side one value longer than the other
	int middle = array.length / 2;
	
	//because the stop integer is exclusive the subarrays can end/stop with middle
	int[] left = subarray(array, 0, middle);
	int[] right = subarray(array, middle, array.length);
		
	//mergeSort is recursively called and will return a sorted array (for both left and right), which merge with then put and sort together for the return value of a fully sorted array
 	return merge(mergeSort(left), mergeSort(right));

    }


}
