package Riker.BlackJack;

/**
 * <b>Title</B>: Dealer.java Description: Java code of a dealer. A dealer object
 * 		will move cards based on game rules, or user input.  
 * 
 * Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
 *
 * @author: Ryan Riker
 * @version 1.0
 * @since 09/23/2014 
 * last update: never
 */

public class Dealer extends Player {


	
	public Dealer() {
		this.setWallet(500);
	}
/**
 * 
 * @param hand
 * @param deck
 */
	public void drawCardToHand(Hand hand, Deck deck) {
		
		hand.addCardToHand(((StandardDeck) deck).getCard());
	}
	
	
}
