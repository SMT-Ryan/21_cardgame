package Riker.BlackJack;

/**
 * <b>Title</B>: Card.java Description: java code of a card. card object will 
 * 		at minimum hold a rank, suit, and value.
 * 
 * Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
 *
 * @author: Ryan Riker
 * @version 1.0
 * @since 09/23/2014 
 * last update: never
 */

public class Card {

	private int rank = 0;
	private int suit = 0;
	private int value = 0;
	
	//empty constructor
	public Card() {
		
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
