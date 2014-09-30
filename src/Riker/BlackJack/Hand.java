package Riker.BlackJack;

import java.util.ArrayList;
import java.util.List;

/**
* <b>Title</B>: Hand.java Description: Java Code for a hand of cards Object.  
* 
* Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
*
* @author: Ryan Riker
* @version 1.0
* @since 09/23/2014 
* last update: never
 */

public class Hand {
	
	private int numberOfCardsInHand = 0;
	private int value = 0;
	private List<CardVO> cardsInHand = new ArrayList<>(10);
	
	//empty constructor
	public Hand() {
		
	}

/**
 * This method will print the content of the current hand, while hiding the 
 * first card face down.
 * @param deck a standard deck of 52 cards
 */
	public void printDealerHand(DeckVO deck){
		Message mg = new Message();
		String currentRank = null;
		String currentSuit = null;
		
		System.out.println();
		
		mg.displayMessage(1, numberOfCardsInHand);

		 for ( int count = 1 ; count < numberOfCardsInHand; count++ ) {
			 
			currentRank = ((StandardDeck) deck).setCurrentRank(cardsInHand.
						get(count).getRank());
			currentSuit = ((StandardDeck) deck).setCurrentSuit(cardsInHand.
					get(count).getSuit());
			
		mg.displayMessage(1, currentRank, currentSuit);

		 }
		
	}
	/**
	 * This method will print the content of the current hand to display, 
	 * 	showing all cards
	 * @param deck a standard deck of 52
	 */
	public void printHand(DeckVO deck) {
		Message mg = new Message();
		String currentRank = null;
		String currentSuit = null;
		
		mg.displayMessage(2, numberOfCardsInHand);
		
		 for ( int count = 0 ; count < numberOfCardsInHand; count++ ) {
			 
			currentRank = ((StandardDeck) deck).setCurrentRank(cardsInHand.
						get(count).getRank());
			currentSuit = ((StandardDeck) deck).setCurrentSuit(cardsInHand.
					get(count).getSuit());
			
			mg.displayMessage(2, currentRank, currentSuit);
		 }
	}
	

	//setters and getters
	public int getNumberOfCardsInHand() {
		return numberOfCardsInHand;
	}

	public void setNumberOfCardsInHand(int numberOfCardsInHand) {
		this.numberOfCardsInHand = numberOfCardsInHand;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<CardVO> getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(List<CardVO> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}
	
	public void addCardToHand(CardVO newCard) {
		cardsInHand.add(newCard);
		numberOfCardsInHand++;
		value = value + newCard.getValue();
	}


}
