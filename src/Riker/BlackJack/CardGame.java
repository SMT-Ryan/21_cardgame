package Riker.BlackJack;

import java.util.List;

/**
 * <b>Title</B>: CardGame.java Description: Java code of a card game interface. 
 * 		A card game object Must have a process, checkWin and requestShuffle 
 * 		method.
 * 
 * Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
 *
 * @author: Ryan Riker
 * @version 1.0
 * @since 09/24/2014 
 * last update: never
 */
public interface CardGame {
	
	//mandatory methods
	public void process();
	public void checkWin(List<Player> players, int population);
	public void requestShulle();
	
}
