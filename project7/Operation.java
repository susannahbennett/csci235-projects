/** 
 * Operation.java
 *
 * Evaluation class finds and returns the operation symbol
 * 
 * @author Susannah Bennett
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 * 12.6.19
 */

public class Operation implements ExprNode {
  /**
   * String that holds the operation sign from the equation to be graphed
   */
	private String operator;
  /**
   * The node on the left side of the branch in the treeNode
   */
	private ExprNode left;
  /** 
   * The node on the right side of the branch in the treeNode
   */
	private ExprNode right;

  /**
   * Constructor to initialize operator, left, and right
   */
	public Operation (String operator, ExprNode left, ExprNode right){
		this.operator = operator;
		this.left = left;
		this.right = right;
	}
  	
  /** 
   * Checks what symbol is in the String operator and performs the correct math operation based on what it is
   * @param x Value holding the variable x
   * @return the correct math operation
   */
  public double evaluate(double x) {
  		if (operator.equals("*")){
  			return left.evaluate(x) * right.evaluate(x);
  		} else if (operator.equals("/")){
  			return left.evaluate(x) / right.evaluate(x);
  		} else if (operator.equals("+")){
  			return left.evaluate(x) + right.evaluate(x);
  		} else if (operator.equals("-")){
  			return left.evaluate(x) - right.evaluate(x);
  		} else {
  			return Math.pow(left.evaluate(x), right.evaluate(x));
  		} 
  }
}
