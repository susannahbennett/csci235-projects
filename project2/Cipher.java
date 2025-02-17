/**
 * Cipher.java
 * 
 * Program to decipher messages encoded using a Caesar cipher.
 * 
 * @author TVD, CGG, and Susannah Bennett
 * CSCI 235, Wheaton College, Fall 2019
 * Project 2
 * Date? 10.3.19
 */

import java.util.Scanner;
import java.io.*;

public class Cipher {

    public static void main(String[] args) {

        // encrypted text
        String ciphertext;  

        // input from keyboard
        Scanner keyboard = new Scanner(System.in);

        // -----------------------------------------------------------------
        // this section contains stuff we haven't covered yet. 
        // -----------------------------------------------------------------
        if (args.length > 0) {
            ciphertext = "";
            try {
                Scanner inputFile = new Scanner(new File(args[0]));
                while(inputFile.hasNext()) 
                    ciphertext += inputFile.nextLine();
            } catch(IOException ioe) {
                System.out.println("File not found: " + args[0]);
                System.exit(-1);
            }
        }
        else {
            System.out.print("Please enter text--> ");
            ciphertext = keyboard.nextLine(); 
        }
        // -----------------------------------------------------------------
        


	int distance = 0;  // how far the ciphertext should be shifted
	String next = "";  // user input after viewing
	
	// String plaintext = something; // the (possibly) decrypted message
        
	while(!next.equals("quit")) {
	    distance += 1;
	    String plaintext = ""; // the (possibly) decrypted message
	   
	    for (int pos = 0; pos < ciphertext.length(); pos++){
		char originalLetter = ciphertext.charAt(pos);
		int asciiOriginal = (int) originalLetter;
		char newLetter;
		if (asciiOriginal >= (int)'a' && asciiOriginal <= (int)'z'){
		    int asciiNew = asciiOriginal + distance;
		    int changeRange = asciiNew - (int)'a';
		    changeRange = (changeRange%26) + (int)'a';
		    newLetter = (char)changeRange;
		} else if (asciiOriginal >= (int)'A' && asciiOriginal <= (int)'Z'){
		    int asciiNew = asciiOriginal + distance;
		    int changeRange = asciiNew - (int)'A';
		    changeRange = (changeRange%26) + (int)'A';
		    newLetter = (char)changeRange;
		} else {
		    newLetter = originalLetter;
		}

		plaintext = plaintext + newLetter;		
	    }
	    
	    
	    System.out.println (ciphertext);

	    

	    // At this point, plaintext is the shifted ciphertext.
	    // Nothing below this should need to change.
	    System.out.println("distance " + distance);
            System.out.println(plaintext);
            System.out.println("Press enter to see the next option,"
			       + "type 'quit' to quit.");
            next = keyboard.nextLine().trim();
        }
	System.out.println("Final shift distance was " + distance + " places");
    }

}
