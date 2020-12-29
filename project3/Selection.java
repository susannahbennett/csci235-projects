/**
 * Selection.java
 *
 * A sort() method that implements selection sort.
 *
 * @author Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 3
 * 10.13.19
 */

public class Selection {

    public static void sort(int[] array) {
	for (int j = 0; j < array.length; j++){ // j controls how much of the array to sort (the unsorted parts), starting from the initial values
	    int smallest = array[j]; // the smallest value and location must be initialized to a value of the array (the first of the unsorted values)
	    int location = j;
	    for (int i = j; i < array.length; i++){ // i controls the checking of each number to see if its the minimum out of the remaining, unsorted array
		if (array[i] < smallest){
		    smallest = array[i];
		    location = i;
		}
	    }
	    array[location] = array[j]; // the smallest value (at location) is switched with the value at the first index of the unsorted array
	    array[j] = smallest;
	}



    }
}
