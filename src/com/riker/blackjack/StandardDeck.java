package com.riker.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


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

public class StandardDeck extends AbstractDeck {
	/**
	 * 
	 */
    List<Suit> suits = new ArrayList<Suit>(){
		private static final long serialVersionUID = 1L; {
    		add(new Suit("Diamonds", 1));
    		add(new Suit("Clubs", 2));
    		add(new Suit("Spades", 3));
    		add(new Suit("Hearts", 4));
    	}
    };
    
    List<Rank> ranks = new ArrayList<Rank>(){
		private static final long serialVersionUID = 1L; {
    		add(new Rank("Ace", 1));
    		add(new Rank("Two", 2));
    		add(new Rank("Three", 3));
    		add(new Rank("Four", 4));
    	}
    };
		
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
    public final static int QUEEN = 12;
    public final static int KING = 13;

	
	//constructor
	public StandardDeck() {
		
		for(Suit suit : suits ){
			for(Rank rank : ranks ){
				CardVO card = new CardVO(suit, rank);
				readyCards.add(card);
				System.out.println(card);
			}
		}
	}

	/**
	 * This methods places a Card into the discard pile
	 * @param discardedCard
	 */
	public void discardCard(CardVO discardedCard){
		discardPile.add(discardedCard);
	}
	
	/**
	 * Takes the existing list of cards and shuffles them into random order
	 * 	@Override
	 * 	@return the list of cards after being shuffled.
	 */
	public DeckVO shuffle(DeckVO deck) {
		
		Collections.shuffle(deck.getReadyCards());
		return deck;
	}

	/*
	 * (non-Javadoc)
	 * @see Riker.BlackJack.DeckVO#getReadyCards()
	 */
	public List<CardVO> getReadyCards(){
		return readyCards;
	}
	
	/**
	 * returns the card at the top of the array.
	 * @return activeCard
	 */
	public CardVO getCard(){
		CardVO activeCard = new CardVO();
		
		activeCard = readyCards.get(0);
		readyCards.remove(0);
		
		return activeCard;
	}
	
	/**
	 * reloads the discarded cards to the deck
	 * @param i 
	 * @Override
	 */
	public void reload() {
		 for ( int i = 0 ; i < discardPile.size(); i++ ) {
			 readyCards.add(discardPile.get(i));
		 }
		
	}
	

	
}
