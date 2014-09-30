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
	//empty constructor
	public Dealer() {
		this.setWallet(500);
	}
	
	//this sets the dealers wallet to increase in size per population
	public Dealer(int playerPopulation) {
		this.setWallet(500 * playerPopulation);
	}
/**
 * This method lets the dealer remove a card from the deck and place it in the 
 * 	hand referenced.
 * @param hand
 * @param deck
 */
	public void drawCardToHand(Hand hand, DeckVO deck) {
		
		hand.addCardToHand(((StandardDeck) deck).getCard());
	}
	
	
}
