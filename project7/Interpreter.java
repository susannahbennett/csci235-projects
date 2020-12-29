/**
 * Interpreter.java
 *
 * Class to generate ExprNode trees based on a given
 * input.
 *
 * @author Susannah Bennett
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 * 12/7/19
 */

public class Interpreter {

    /**
     * Turn a string into an ExprNode tree.
     *
     * @param input The string to parse
     * @return The root of the ExprNode tree
     */
    public static ExprNode parse(String input) {

        String nodes[] = ExprStringSlicer.slice(input);

        ExprNode out = null;

        if (nodes.length == 1){
            if (nodes[0].equals("x")){
                out = new Variable();
            } else {
                out = new Number(nodes[0]);
            }
        } else {
            out = new Operation(nodes[1], parse(nodes[0]), parse(nodes[2]));
        }

        return out;
    }

    /**
     * For testing project 7 (Part A).
     */
    public static void main(String[] args) {
        ExprNode tree = parse(args[0]);
        System.out.println(tree.evaluate(Double.parseDouble(args[1])));
    }
}