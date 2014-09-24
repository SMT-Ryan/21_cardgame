package Riker.BlackJack;

import java.util.ArrayList;
import java.util.List;


/**
* <b>Title</B>: Player.java Description: Java Code for a hand of cards Object.  
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
	private List<Card> cardsInHand = new ArrayList<>(10);
	
	//empty constructor
	public Hand() {
		
	}


	public void printHand() {
		
		System.out.println();
		
		System.out.println("number of cards in hand is : " + 
				numberOfCardsInHand);
		
		System.out.println();
		 
		 for ( int count = 0 ; count < numberOfCardsInHand; count++ ) {

			 System.out.println("the shuffled card is " + 
					 cardsInHand.get(count).getSuit() + 
						 " and " + cardsInHand.get(count).getRank());
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

	public List<Card> getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(List<Card> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}
	
	public void addCardToHand(Card newCard) {
		cardsInHand.add(newCard);
		numberOfCardsInHand++;
		value = value + newCard.getValue();
	}


}
