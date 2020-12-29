/**
 * Variable.java
 * 
 * Evaluation class that returns the variable
 *
 * @author Susannah Bennett
 * Wheaton College, CSCI235, Fall 2019
 * Project 7
 * 12/6/19
 */

public class Variable implements ExprNode{
    /** 
     * Returns the variable
     * @param x The double variable
     * @return x The double variable
     */
    public double evaluate(double x) {
	return x;
    }
}
