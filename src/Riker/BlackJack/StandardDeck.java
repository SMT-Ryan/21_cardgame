package Riker.BlackJack;

import java.util.ArrayList;
import java.util.List;





/**
 * <b>Title</B>: StandardDeck.java Description: Java code for an instance 
 * 		of a deck object.  A standard deck of cards is A deck that will have 
 * 		52 standard playing cards in four suits with ranks from ace to king. 
 * 		no jokers.  
 * 		The deck will use two lists of cards, one will be the shuffled cards
 * 		waiting to be played, and the second will be the used cards in the form
 * 		of a discard pile.
 * 
 * Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
 *
 * @author: Ryan Riker
 * @version 1.0
 * @since 09/23/2014 
 * last update: never
 */

public class StandardDeck implements Deck{

	/*
	 * Constant values for suits
	 */
    public final static int DIAMONDS = 1;
    public final static int CLUBS = 2;
    public final static int HEARTS = 3;
    public final static int SPADES = 4;
		
    /*
     * constant values of card ranks 
     */
    public final static int ACE = 1;
    public final static int DEUCE = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int HIGH_ACE = 11;    
    public final static int QUEEN = 12;
    public final static int KING = 13;
    
    List<Card> readyCards = new ArrayList<>(52);
    List<Card> discardPile = new ArrayList<>(52);

	
	//empty constructor
	public StandardDeck() {
		
		for(int count = 0; count < KING; count++ ){
			readyCards.add(new Card(count , DIAMONDS));
			readyCards.add(new Card(count , CLUBS));
			readyCards.add(new Card(count , HEARTS));
			readyCards.add(new Card(count , SPADES));
		}
		
	}

	public void printDeck(){
		// write print function
		System.out.println("the deck has :#" + readyCards.size() + " cards left.");
		
	}
	
	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}

}
