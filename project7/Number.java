/** 
 * Number.java
 *
 * Evaluation class that finds and returns the number
 * 
 * @author Susannah Bennett
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 * 12.6.19
 */

public class Number implements ExprNode {

	/**
	 * double that holds the value parsed from String text
	 */
    private double value;

    /**
     * Constructor to initialize value 
     */
    public Number(String text){
	value = Double.parseDouble(text);
    }
    
    /**
     * method that returns the number
     * @param x The double value that represents the variable
     * @return value The double value parsed from the String text
     */
    public double evaluate (double x) {
	return value;
    }
}
