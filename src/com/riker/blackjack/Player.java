package com.riker.blackjack;



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
public class Player extends PersonVO {

	private String playerAlias = null;
	private boolean isDealer = false;
	private int wallet = 0;
	private int betPool = 0;
	private Hand hand = new Hand();
	private String playerPreferredName;

	//empty constructor
	public Player() {
		this.setPlayerPreferredName("Player");
	}
	
	public void printHand(DeckInterface deck){
		hand.printHand(deck);
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

	public int getBetPool() {
		return betPool;
	}

	public void setBetPool(int betPool) {
		this.betPool = betPool;
	}

	public String getPlayerPreferredName() {
		return playerPreferredName;
	}

	public void setPlayerPreferredName(String playerPreferredName) {
		this.playerPreferredName = playerPreferredName;
	}

}
