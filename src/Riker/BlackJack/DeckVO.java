package Riker.BlackJack;

import java.util.List;

/**
 * <b>Title</B>: DeckVO.java Description: Java code for a interface that controls
 * 		a deck of cards. A deck will have at minimum a shuffle and reload 
 * 		method.
 * 
 * Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
 *
 * @author: Ryan Riker
 * @version 1.0
 * @since 09/23/2014 
 * last update: never
 */

public interface DeckVO {
	
	//mandatory methods
public DeckVO shuffle(DeckVO deck);
public void reload();
public List<CardVO> getReadyCards();



}
