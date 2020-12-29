/**
 * ATMdriver.java
 *
 * This program is a driver to test the class ATM.
 *
 * @author Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * 11.5.19
 */

import java.util.Scanner; // imported for user input with menu choices

public class ATMdriver {
    
    public static void main(String[] args) {
	
	Scanner keyboard = new Scanner(System.in); // user input
	ATM myAccount = new ATM(0, 0, 0); // the bank account to be adjusted
	boolean quit = false; // for quitting the do-while loop

	do {
	    System.out.println("W: withdraw money from the ATM\n" + "T: add twenties to the ATM\n" + "F: add fives to the ATM\n" + "Q: quit\n");
	    System.out.print("Your choice: ");
	    char query = keyboard.next().charAt(0); // user menu choice
	    keyboard.nextLine();

	    switch (query) {
	    case 'W':
	    case 'w':
		System.out.println("How much do you want to withdraw? Please enter a multiple of 5.");
		int request1 = keyboard.nextInt(); // user's withdrawal request
		keyboard.nextLine();
		
		//to ensure that a positive value that is a multiple of 5 is given
		while (request1 < 0 && request1 % 5 != 0) { 
		    System.out.println("Please enter a positive value that is a multiple of 5.");
		    request1 = keyboard.nextInt();
		    keyboard.nextLine();
		}

		myAccount.withdraw(request1); // calls the withdrawal method in ATM.java
		System.out.println(myAccount.toString()); // prints an updated count of what bills/balance are in the account
		System.out.println();
		break;

	    case 'T':
	    case 't':
		System.out.println("How many twenties do you want to add?");
		int request2 = keyboard.nextInt(); // user's request for adding bills
		myAccount.addTwenties(request2); // calls the addTwenties method in ATM.java
		System.out.println(myAccount.toString()); // prints an updated count of what bill/balance are in the account
		System.out.println();
		break;

	    case 'F':
	    case 'f':
		System.out.println("How many fives do you want to add?");
		int request3 = keyboard.nextInt(); // user's request for adding bills
		myAccount.addFives(request3); // calls the addFives method in ATM.java
		System.out.println(myAccount.toString()); // prints an updated count of what bills.balance are in the account
		break;

	    case 'Q':
	    case 'q':
		quit = true; // flags programs end to exit the do while loop
		break;

	    default:
		System.out.println("That is not a choice.");
	    }
	} while (!quit);

    }
}

