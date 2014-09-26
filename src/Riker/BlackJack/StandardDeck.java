package Riker.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
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

	
	//constructor
	public StandardDeck() {
		
		for(int suitCount = 1; suitCount <= SPADES; suitCount++){
			for(int count = 1; count <= KING; count++ ){
				readyCards.add(new Card(count , suitCount));
			}
		}
	}

	
/**
 * A method used to print all the cards in the ready deck.  does not include 
 * cards in discard list 
 */
	public void printDeck(){
		
		Message mg = new Message();
		String currentRank = null;
		String currentSuit = null;
		
		
		mg.displayEnglishMessage(3, readyCards.size());
		 
		 for ( int count = 0 ; count < readyCards.size(); count++ ) {

			 currentRank = setCurrentRank(readyCards.get(count).getRank());
			 
			 currentSuit = setCurrentSuit(readyCards.get(count).getSuit());
			 
		mg.displayEnglishMessage(3, currentRank, currentSuit);
		 }
	}
	
	/**
	 * Takes the existing list of cards and shuffles them into random order
	 * 	@Override
	 * 	@return the list of cards after being shuffled.
	 */
	public Deck shuffle(Deck deck) {
		
		Collections.shuffle(deck.getReadyCards());
		return deck;
	}

	/**
	 * method that returns the list of cards in a deck.
	 */
	public List<Card> getReadyCards(){
		return readyCards;
	}
	
	/**
	 * returns the card at the top of the array.
	 * @return activeCard
	 */
	public Card getCard(){
		Card activeCard = new Card();
		
		activeCard = readyCards.get(0);
		readyCards.remove(0);
		
		//error checking
		//System.out.println("active card rank" + activeCard.getRank() + " and " + 
		//		activeCard.getSuit());
		return activeCard;
	}
	
	/**
	 * reloads the discarded cards to the deck
	 * @Override
	 */
	public void reload() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Takes the intriguer value for suit and translates it into a readable 
	 * suit for the user
	 * @param currentSuit integer value for the current cards' suit.
	 * @return a string value for card suit for display
	 */
	
	public String setCurrentSuit(int currentSuit) {
		String suit = null;
		
		switch(currentSuit){
		 case 1:
			 suit = "DIAMOND";
			 break;
		 case 2:
			 suit = "CLUBS";
			 break;
		 case 3:
			 suit = "HEARTS";
			 break;
		 case 4:
			 suit = "SPADES";
			 break;
		default:
			suit = "Something has gone horribly wrong here";
			break;			 
		 }

		return suit;
	}
	
	/**
	 * Takes the integer values for the rank and translates them into a readable 
	 * rank for the user.
	 * 
	 * @param currentRank integer rank of current card.
	 * @return a string value of card rank for display
	 */
	
	public String setCurrentRank(int currentRank){
		String rank = null;
		
		 switch (currentRank) {
		 case 1:
			 rank = "ACE";
			 break;
		 case 2:
			 rank = "DEUCE";
			 break;
		 case 3:
			 rank = "THREE";
			 break;
		 case 4:
			 rank = "FOUR";
			 break;
		 case 5:
			 rank = "FIVE";
			 break;
		 case 6:
			 rank = "SIX";
			 break;
		 case 7:
			 rank = "SEVEN";
			 break;
		 case 8:
			 rank = "EIGHT";
		 	 break;
		 case 9:
			 rank = "NINE";
			 break;
		 case 10:
			 rank = "TEN";
			 break;
		 case 11:
			 rank = "JACK";
			 break;
		 case 12:
			 rank = "QUEEN";
			 break;
		 case 13:
			 rank = "KING";
			 break;
		default:
			rank = "Something has gone horribly wrong here.";
			break;
			
		 }
		
		return rank;
	}
	

	
}
