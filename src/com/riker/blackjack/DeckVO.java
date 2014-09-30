package com.riker.blackjack;

import java.util.List;

/**
 * <b>Title</B>: DeckVO.java Description: Java code for a interface that
 * controls a deck of cards. A deck will have at minimum a shuffle and reload
 * method.
 * 
 * Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
 *
 * @author: Ryan Riker
 * @version 1.0
 * @since 09/23/2014 last update: never
 */

public interface DeckVO {
   
	// mandatory methods
	public DeckVO shuffle(DeckVO deck);

	public void reload();

	/**
	 * method that returns the list of cards in a deck.
	 * @return blah
	 */
	public List<CardVO> getReadyCards();
	
	/**
	 * A method used to print all the cards in the ready deck.  does not include 
	 * cards in discard list 
	 */
	public void printDeck();

}
