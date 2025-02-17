/**
 * Player.java
 * 
 * The player for the MonsterGame.
 *
 * @author Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 4
 * 10.26.19
 */

public class Player {
    
    /**
     * The x coordinate of the player
     */
    private int xPos;

    /**
     * The y coordinate of the player
     */
    private int yPos;

    /**
     * The x coordinate that indicates the boundaries of the grid
     */
    private int xGrid;

    /**
     * The x coordinate that indicates the boundaries of the grid
     */
    private int yGrid;

    /**
     * The character that is shown or not shown to indicate the Player's location
     */
    private char icon;


    /**
     * Constructor for initializing Player's instance variables (sets coordinates and sets grid 
     * @param x The value for xPos
     * @param y The value for yPos
     * @param xSize The value for xSize
     * @param ySize The value for ySize
     * icon is also initialized
     */
    public Player(int x, int y, int xSize, int ySize) { 
	xPos = x;
	yPos = y;
	xGrid = xSize;
	yGrid = ySize;
	icon = 'P';
    }

    /**
     * Return the position of Player's x coordinate
     * @return the position of x
     */
    public int getXPos() {
	return xPos;
    }

    /**
     * Return the position of Player's y coordinate
     * @return the position of y
     */
    public int getYPos() {
	return yPos;
    }
    
    /**
     * Increase the y position and ensure the Player does not go off the grid
     * POSTCONDITION: The Player's y-coordinate will be one greater and still on the grid
     */
    public void up() {
	yPos++;
	if (yPos >= yGrid){
	    yPos = yGrid-1;
	}
    }
    /**
     * Decrease the y position and ensure the Player does not go off the grid
     * POSTCONDITION: The Player's y-coordinate will be one less and still on the grid
     */
    public void down() { 
	yPos--;
	if (yPos < 0){
	    yPos = 0;
	}
    }
    /**
     * Decrease the x position and ensure the Player does not go off the grid
     * POSTCONDITION: The Player's x-coordinate will be one less and still on the grid
     */
    public void left() { 
	xPos--;
	if (xPos < 0){
	    xPos=0;
	}
    }

   /**
     * Increase the x position and ensure the Player does not go off the grid
     * POSTCONDITION: The Player's x-coordinate will be one greater and still on the grid
     */
    public void right() { 
	xPos++;
	if (xPos >= xGrid){
	    xPos = xGrid-1;
	}
    }

   /**
     * Switch the Player's display to the updated icon
     */
    public void disOrReappear() {
	if (icon == ' '){
	    icon = 'P';
	} else {
	    icon = ' ';
	}
    }

   /**
     * Return the Player character icon
     * @return the character icon
     */
    public char getIcon() { 
        return icon;
    }

}
