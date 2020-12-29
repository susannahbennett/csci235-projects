/**
 * ATM.java
 *
 * This program simulates an ATM through withdraw transaction.
 *
 * @author Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * 11.5.19
 */

public class ATM {
	/**
	 * The number of twenty dollar bills in myAccount
	 */
    private int twenties; 
    /**
	 * The number of five dollar bills in myAccount
	 */
    private int fives; 
    /**
	 * The dollar amount based on the number of bills in myAccount
	 */
    private int balance; 
    
    /**
     * Constructor for initializing ATM variables
     *
     */
    public ATM (int twenties, int fives, int balance) {
	this.twenties = twenties;
	this.fives = fives;
	this.balance = balance;
    }
    
    /**
     * Adds variables to a formatted string to show the current status of myAccount
     * @return the combined string to be printed
     */
    public String toString (){
	String phrase = "ATM now has \n\t " + this.twenties + " twenty dollar bills and " + this.fives + " five dollar bills:" + "$" +this.balance;
	return phrase;
    }
    
    /**
     * Increases the number of twenties in myAccount
     * @param  twentiesToAdd the number of twenty dollar bills to increase twenties by
     * POSTCONDITION: this.twenties will be increased by twentiesToAdd
     */
    public void addTwenties (int twentiesToAdd) {
	this.twenties += twentiesToAdd;
	this.balance += (twentiesToAdd * 20);
    }
    
    /**
     * Increases the number of fives in myAccount
     * @param fivesAdd the number of five dollar bills to increase fives by
     * POSTCONDITION: this.fives will be increased by fivesToAdd
     */
    public void addFives (int fivesToAdd) {
	this.fives += fivesToAdd;
	this.balance += (fivesToAdd * 5);
    }

    /**
     * Withdraws money from twenties, fives, and the balance, when possible
     * @param request the requested amount to be withdrawn
     * PRECONDITION: the request is a positive value that is a multiple of 5
     * POSTCONDITION: twenties, fives, and balance will be decreased, if the transaction is possible
     */
    public void withdraw (int request) {
	this.balance = (this.twenties * 20) + (this.fives * 5);
	if (this.balance < request) {
	    System.out.println("Not enough money in balance for withdraw.");
	    return;
	}
	
	int remainder = request % 20; // determines how much of the request can be withdrawn in twenty dollar bills
	int twentiesPart = request - remainder; // determines how much of the total request could returned in twenties
	int numTwenties = twentiesPart / 20; // determines the number of twenty dollar bills that theoretically should be withdrawn

	int numTwentiesToWithdraw; // holds the number of bills that can actually be withdrawn, based on the number of bills available
	int numTwentiesRemaining; // keeps track of the number of twenty dollar bills, based on circumstance
	
	if (numTwenties > this.twenties){
	    numTwentiesRemaining = 0;
	    numTwentiesToWithdraw = this.twenties;
	} else {
	    numTwentiesRemaining = this.twenties - numTwenties;
	    numTwentiesToWithdraw = numTwenties;
	}

	int numFives;
	if (numTwentiesToWithdraw == 0) {
		numFives = request / 5;
	} else {
		numFives = remainder / 5;
	}

	// if more fives are requested than there actually are, the transaction cannot occur
	if (numFives > this.fives){
	    System.out.println("Sorry, the transaction cannot be made.");
	    return;
	} 

	// updates the instance variables
	this.fives = this.fives - numFives;
	this.twenties = numTwentiesRemaining; 
	this.balance = (this.twenties * 20) + (this.fives * 5); 

    }
}
