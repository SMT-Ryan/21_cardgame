package com.riker.blackjack;

import java.util.ArrayList;
import java.util.List;


/****************************************************************************
 * <b>Title</b>: AbstractDeck.java <p/>
 * <b>Project</b>: WebCrescendo <p/>
 * <b>Description: </b> Put Something Here
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author James Camire
 * @version 2.0
 * @since Sep 30, 2014<p/>
 * @updates:
 ****************************************************************************/
public abstract class AbstractDeck implements DeckVO {

    protected List<CardVO> readyCards = new ArrayList<>(52);
    protected List<CardVO> discardPile = new ArrayList<>(52);

	/* (non-Javadoc)
	 * @see Riker.BlackJack.DeckVO#printDeck()
	 */
	@Override
	public void printDeck() {
		Message mg = new Message();
		String currentRank = null;
		String currentSuit = null;
		
		
		mg.displayMessage(3, readyCards.size());
		 
		 for ( CardVO card : readyCards ) {
			 System.out.println(card);
			 //mg.displayMessage(3, currentRank, currentSuit);
		 }

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
