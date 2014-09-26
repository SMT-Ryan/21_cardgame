package Riker.BlackJack;

/**
* <b>Title</B>: Message.java Description: Java Code for an object that displays
* 	messages to the user.  
* 
* Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
*
* @author: Ryan Riker
* @version 1.0
* @since 09/26/2014 
* last update: never
 */

public class Message {
	
	//empty constructor
	public Message() {
		
	}
	
	
/**
 * This method displays the standard English messages
 * @param m
 */
	public void displayEnglishMessage(int m) {
		switch (m){
		case 1:
		System.out.println("Black Jack: A work in progress by Ryan J. "
				+ "Riker");
		System.out.println("(c)  Copyright 2014");
		System.out.println("");
		break;
		case 2:
			System.out.println("How many of you folks are joining us today?");
			break;
		default:
		break;
		}
	}
/**
* This method displays the standard English messages the require the 
* 	dealers data
* @param m
* @param dealer 
* @override
*/
	public void displayEnglishMessage(int m , Dealer dealer) {
		switch (m){
		case 1:
			System.out.println("Welcome, my name is " + dealer.getFirstName() + 
					" "	+ dealer.getLastName() + " but my friends call me " + 
					dealer.getPlayerAlias() +".");
			System.out.println("I will be dealing today");
		break;
		default:
		break;
		}
		
	}
	
/**
 * The method displays English messages the require an integer to display 
* correctly
* @param m
* @param value
*/
	public void displayEnglishMessage(int m, int value) {
		switch (m){
		case 1:
			System.out.println("number of cards in the dealers hand is : " + 
					value);
			System.out.println();
			System.out.println("The dealers first card is FACE DOWN.");
		break;
		case 2:
			System.out.println();
			System.out.println("number of cards in this hand is : " + 
					value);
			System.out.println();
		break;
		default:
		break;
		}
		
	}

/**
 * This method displays English messages that require two strings to display
 * correctly
 * @param m
 * @param string1
 * @param string2
 */
	public void displayEnglishMessage(int m, String string1,
			String string2) {
		switch (m){
		case 1:
			 System.out.println("Also in the Dealer's hand is the " + string1 + 
					 " of " + string2 + ".");
				System.out.println();
		break;
		case 2:
			 System.out.println("in the hand is card rank: " +  string1 + 
					 " and suit " + string2);
		break;
		default:
		break;
		}
		
	}
	
	
	
}
