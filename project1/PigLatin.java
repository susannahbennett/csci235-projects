/**
 * PigLatin.java
 *
 * Program to generate a Pig Latin expression 
 * consisting of up to four words
 *
 * @author Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 1
 * Date?
 */
import java.util.*;

public class PigLatin {

    public static void main(String[] args) {
      
	//for input from keyboard
	Scanner keyboard = new Scanner(System.in);

	System.out.print("Please enter words: ");

	//store input at str
	String str = keyboard.nextLine();
	
	//remove leading and trailing spaces
	str = str.trim();  
	
	//hold pig latin expression up to this point
	String pig = "";
	
	//add your code here
	str = str + " ";
	int place = 0;
	for (int i = 0; i < str.length(); i++){
	    String word = "";
	    char firstChar = str.charAt(0);
	    int endIndex = str.indexOf(" ");

	    word = str.substring(1, endIndex) + firstChar + "ay";
	    
	    str = str.substring(endIndex + 1);
	        
	    pig = pig + word + " ";
	}
	
	//print pig latin expression at pig
	System.out.println("The Pig Latin expression: " + pig);

    }
}
