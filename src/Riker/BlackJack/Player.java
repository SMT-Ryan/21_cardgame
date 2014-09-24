package Riker.BlackJack;

import java.util.ArrayList;

/**
* <b>Title</B>: Player.java Description: Java Code for a player Object.  
* 
* Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
*
* @author: Ryan Riker
* @version 1.0
* @since 09/23/2014 
* last update: never
 */
public class Player extends Person {

	private String playerAlias = null;
	private boolean isDealer = false;
	private int wallet = 0;
	private Hand hand = new Hand();

	
	
	//empty constructor
	public Player() {
		
	}
	
	//write the code to place a bet here
	//
	//
	//
	//
	//
	//
	//
	//
	
	
	
	public void printHand(){
		hand.printHand();
	}

	
	//getters and setters
	public String getPlayerAlias() {
		return playerAlias;
	}

	public void setPlayerAlias(String playerAlias) {
		this.playerAlias = playerAlias;
	}

	public boolean isDealer() {
		return isDealer;
	}

	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
