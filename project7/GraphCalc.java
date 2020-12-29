/**
 * GraphCalc.java
 *
 * Graphing calculator program (class with main method)
 *
 * @author Susannah Bennett
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 * 12/7/19
 */

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class GraphCalc {

    private JTextField funcField, xminField, yminField, xmaxField, ymaxField;
    private JLabel fx, xmin, ymin, xmax, ymax;
    private PaintPanel graphPanel;

    /**
     * Constructor to set up window
     */
    public GraphCalc () {
    	//sets up window
        JFrame window = new JFrame("Graphing calculator");
    	window.setLayout(new FlowLayout());
	    window.setSize(450, 650);
        
        graphPanel = new PaintPanel(350, 350);
        
        //creates textFields
        funcField = new JTextField(25);
        xminField = new JTextField(5);
        yminField = new JTextField(5);
        xmaxField = new JTextField(5);
        ymaxField = new JTextField(5);

        // adds text to textFields
        funcField.setText(""); 
        xminField.setText("-10.0");
        yminField.setText("-10.0");
        xmaxField.setText("10.0");
        ymaxField.setText("10.0");

        // adds go button and listener for button
        JButton go = new JButton("Go");
        GoListener al = new GoListener(graphPanel, this);
        go.addActionListener(al);

	    window.add(graphPanel);

	    // create panels
	    JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        // create new labels
        fx = new JLabel("f(x) = ");
        xmin = new JLabel("x min: ");
        ymin = new JLabel("y min: ");
        xmax = new JLabel("x max: ");
        ymax = new JLabel("y max: ");

        // set the layouts of the panels
	    panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());

        // add buttons, textfields, and labels to the panels
        panel2.add(go);
        panel2.add(fx);
        panel2.add(funcField);
        panel3.add(xmin);
        panel3.add(xminField);
        panel3.add(ymin);
        panel3.add(yminField);
        panel4.add(xmax);
        panel4.add(xmaxField);
        panel4.add(ymax);
        panel4.add(ymaxField);

        // add panels to the window 
	    window.add(panel2);
        window.add(panel3);
        window.add(panel4);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
    }

    /**
     * Main method to create the window
     */
    public static void main(String[] args) {
        GraphCalc theWindow = new GraphCalc();
    }

    /**
     * Creates and returns a string array that contains all of the new inputs fromt the JTextFields
     *
     */
    public JTextField getField(String text) {
    	JTextField field = null;
    	switch(text) {
    		case "func":
    			field = funcField;
    			break;
    		case "xmin":
    			field = xminField;
    			break;
    		case "xmax":
    			field = xmaxField;
    			break;
    		case "ymin":
    			field = yminField;
    			break;
    		case "ymax":
    			field = ymaxField;
    			break;
    		}
    	return field;
    }
}

