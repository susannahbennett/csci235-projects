/**
 * Insertion.java
 *
 * A sort() method that implements insertion sort.
 *
 * @author Susannah Bennett 
 * Wheaton College, CSCI 235, Fall 2019
 * Project 3
 * 10.13.19
 */

public class Insertion {

    public static void sort(int[] array) {

	for (int j = 1; j < array.length; j++){ // makes sure that every position of the array is evaluated
	    int smallest = array[j];
	    for (int i = j; i > 0; i--){ // makes sure that the unsorted yet value finds a spot amidst the sorted side

		if (array[i] < array[i-1]){ // compares a value with the one before it (comparing to the left)
		    smallest = array[i]; 
		    array[i] = array[i-1]; // two values are switched, based on which one is smaller
		    array[i-1] = smallest;
		}
	    }
	}
    }
}
