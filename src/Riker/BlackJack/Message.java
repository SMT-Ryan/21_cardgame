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
		case 3:
			System.out.println("That was not a number, plase try again");
		break;
		case 4:
			System.out.println("its time for everyone to anti up!");
			System.out.println();
		break;
		case 5:
			System.out.println("selecting a name has gone horribly wrong.");
		break;
		case 6:
			System.out.println("let me know what you would prefer to be "
					+ "called?");
			System.out.println("Its alrght if you dont want to be called "
					+ "something special just press the ENTER key");
		break;
		case 7:
			System.out.println("Well shoot, partner. looks like you have ace");
			System.out.println("At my table an ace is worth 11.");
		break;
		case 8:
			System.out.println("Player hits");
			System.out.println();
		break;
		case 9:
			System.out.println("something went horribly wrong assinging cards "
					+ "value");
		break;
		case 10:
				System.out.println("I have bad news my friend, you have "
						+ "busted.");
				System.out.println();
		break;
		case 11:
				System.out.println("player stays");
				System.out.println();
		break;
		case 12:
				System.out.println("Congratulations friend, you have 21");
				System.out.println();
		break;
		case 13:
			System.out.println("Dealer busted player wins betting pool plus a "
					+ "bonus 10 funds");
			System.out.println();
		break;
		case 14:
			System.out.println("Player wins by being closer to 21 and not busting"
					+ " 15 bonus funds rewarded");
			System.out.println();
		break;
		case 15:
			System.out.println("dealer wins by being closer to 21 and not busting"
					+ " player loses the betting pool.");
			System.out.println();
		break;
		case 16:
			System.out.println("Player has 21 and the dealer didnt bust"
					+ " player 25 bonus funds rewarded.");
			System.out.println();
		break;
		case 17:
			System.out.println("Player has busted and loses the betting pool");
			System.out.println();
		break;
		default:
			System.out.println("Something went horribly wrong in the message "
					+ "class");
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
			System.out.println("something went horribly wrong in the message "
					+ "class");
		break;
		}
		
	}
	
/**
 * The method displays English messages the require an integer to display 
* correctly
* @param m
* @param value
*/
	public void displayEnglishMessage(int m, int num) {
		switch (m){
		case 1:
			System.out.println("number of cards in the dealers hand is : " + 
					num);
			System.out.println();
			System.out.println("The dealers first card is FACE DOWN.");
		break;
		case 2:
			System.out.println("number of cards in this hand is : " + 
					num);
			System.out.println();
		break;
		case 3:
		System.out.println("the deck has :#" + num + 
				" cards left.");
		System.out.println();
		break;
		case 4:
			System.out.println("Please, enter player " + num + 
					"'s first name ");
		break;
		case 5:
			System.out.println("your current hands total value is: " + num );
			System.out.println("would you like to hit or stay");
			System.out.println("please type H for hit or S for stay");
			System.out.println();
		break;
		case 6:
			System.out.println("the current hands total value is: " + num );
			System.out.println();
		break;
		default:
			System.out.println("something went horribly wrong in the message "
					+ "class");
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
	public void displayEnglishMessage(int m, String activeString1,
			String activeString2) {
		switch (m){
		case 1:
			 System.out.println("Also in the Dealer's hand is the " + activeString1 + 
					 " of " + activeString2 + ".");
				System.out.println();
		break;
		case 2:
			 System.out.println("in the hand is card rank: " +  activeString1 + 
					 " and suit " + activeString2);
		break;
		case 3:
			 System.out.println("The " + activeString1 + " of " + activeString2);
		break;
		default:
			System.out.println("something went horribly wrong in the message "
					+ "class");
		break;
		}
		
	}
	
	/**
	 * This method displays an English message that requires two integers to 
	 * 	display correctly
	 * @param m
	 * @param value1
	 * @param value2
	 */
	public void displayEnglishMessage(int m, int num1, int num2){
		switch (m){
		case 1:
			System.out.println("player " + num1 + " you have " + num2 + 
					" left in your wallet.");
			
			System.out.println("Player " + num1 + " please enter the amount "
					+ "you wish to risk.");
		break;
		default:
			System.out.println("something went horribly wrong in the message "
					+ "class");
		break;
	
		}
		
	}
	/** 
	 * This method displays an English message that requires an integer and a
	 * 	string to display correctly.
	 * @param m
	 * @param value
	 * @param string
	 */
	public void displayEnglishMessage(int m, int num, String activeString){
		switch (m){
		case 1:
			System.out.println( activeString + " you have " + num + 
					" left in your wallet.");
			
			System.out.println(activeString + " please enter the amount you wish to "
					+ "risk.");
		break;
		case 2:
			System.out.println("It looks like " + activeString + " has a hand value of "
					+ num );
			System.out.println("dealer takes a card");
			System.out.println();
		break;
		case 3:
			System.out.println("It looks like " + activeString + " has a hand value of "
					+ num );
			System.out.println("dealer stays");
			System.out.println();
		break;
		
		default:
			System.out.println("something went horribly wrong in the message "
					+ "class");
		break;
		}
	}
}
