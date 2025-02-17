/**
 * GoListener.java
 *
 * Class that implements ActionLister and Painter for the Go button
 *
 * @author Susannah Bennett
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 * 12/9/19
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GoListener implements ActionListener, Painter {
	/**
	 * The panel where the graph will be created
	 */
	private PaintPanel p;
	/**
	 * the actual graph calculator
	 */
	private GraphCalc gc;
	/**
	 * Holds the minimum x-coordinate value
	 */
	private double xmin;
	/**
	 * Holds the minimum y-coordinate value
	 */
	private double ymin;
	/**
	 * Holds the maximum x-coordinate value
	 */
	private double xmax;
	/**
	 * Holds the maximum y-coordinate value
	 */
	private double ymax;
	/**
	 * Holds the inputed equation to graph
	 */
	private String funcField;
	/**
	 * Holds the Strings from the text fields from GraphCalc class
	 */
	private String[] values;

	/**
	 * Constructor to initialize instance variables and to get the text from the textfields
	 */
	public GoListener (PaintPanel p, GraphCalc gc) {
		this.p = p;
		this.gc = gc;
		p.setPainter(this);
		xmin = Double.parseDouble(gc.getField("xmin").getText());
		ymin = Double.parseDouble(gc.getField("ymin").getText());
		xmax = Double.parseDouble(gc.getField("xmax").getText());
		ymax = Double.parseDouble(gc.getField("ymax").getText());
	}

	/**
	 * Method for what happens when the button is clicked
	 */
	public void actionPerformed (ActionEvent e){
		// ensures that the bounds are correct and that the function is not empty
		try {
			xmin = Double.parseDouble(gc.getField("xmin").getText());
			ymin = Double.parseDouble(gc.getField("ymin").getText());
			xmax = Double.parseDouble(gc.getField("xmax").getText());
			ymax = Double.parseDouble(gc.getField("ymax").getText());
			funcField = gc.getField("func").getText();

			if (xmin < xmax && ymin < ymax && !funcField.equals("")){
				p.repaint();
			} else {
				System.out.println("Error: please enter a function or correct bounds");
			}
		} catch (Exception a) {
			System.out.println("Error: please enter an int or double values");
		}
	}

	/**
	 * Draws the graphed equation
	 * POSTCONDITION: xmin, ymin, xmax, ymax, and funcField are updated to the new values in the textfields
	 * POSTCONDITION: the axes are draw depending on the updated xmin, ymin, xmax, ymax values
	 * POSTCONDITION: the graph is drawn using many small rectangles
	 * @param Graphics g 
	 */
	public void paint(Graphics g){
		xmin = Double.parseDouble(gc.getField("xmin").getText());
		ymin = Double.parseDouble(gc.getField("ymin").getText());
		xmax = Double.parseDouble(gc.getField("xmax").getText());
		ymax = Double.parseDouble(gc.getField("ymax").getText());
		funcField = gc.getField("func").getText();


		if (ymin <= 0 && ymax >= 0){
			g.drawLine(xToCol(xmin), yToRow(0), xToCol(xmax), yToRow(0));
		}
		if (xmin <= 0 && xmax >= 0){
			g.drawLine(xToCol(0), yToRow(ymin), xToCol(0), yToRow(ymax));
`		}

		for (double i = xmin; i <= xmax; i += 0.01){
			g.setColor(Color.CYAN);
			if(!funcField.equals("")) {
				g.fillRect((int)xToCol(i), (int)yToRow(Interpreter.parse(funcField).evaluate(i)), 1, 1);
			}
		}
	}

	/**
	 * Converts the x-coordinate into pixels in columns
	 * POSTCONDITION: xmin, ymin, xmax, ymax, and funcField are updated to the new values in the textfields
	 * @return the changed value of where the point (x-coordinate) is (in pixels)
	 */
	public int xToCol(double x) {
		xmin = Double.parseDouble(gc.getField("xmin").getText());
		ymin = Double.parseDouble(gc.getField("ymin").getText());
		xmax = Double.parseDouble(gc.getField("xmax").getText());
		ymax = Double.parseDouble(gc.getField("ymax").getText());
		funcField = gc.getField("func").getText();
		return (int)(350 * ((x-xmin)/(xmax-xmin)));
	}

	/**
	 * Converts the y-coordinate into pixels in row
	 * POSTCONDITION: xmin, ymin, xmax, ymax, and funcField are updated to the new values in the textfields
	 * @return the changed value of where the point (y-coordinate) is (in pixels)
	 */
	public int yToRow(double y){
		xmin = Double.parseDouble(gc.getField("xmin").getText());
		ymin = Double.parseDouble(gc.getField("ymin").getText());
		xmax = Double.parseDouble(gc.getField("xmax").getText());
		ymax = Double.parseDouble(gc.getField("ymax").getText());
		funcField = gc.getField("func").getText();
		return (int)(350 * (0 - (y-ymax)/(ymax-ymin)));
	}
}
