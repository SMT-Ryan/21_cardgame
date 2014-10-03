package com.riker.blackjack;

/**
 * <b>Title</B>: CardVO.java Description: Java code of a card. A card object will 
 * 		at minimum hold a rank, suit, and value.
 * 
 * Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
 *
 * @author: Ryan Riker
 * @version 1.0
 * @since 09/23/2014 
 * last update: never
 */

public class CardVO {

	private int rank = 0;
	private int suit = 0;
	private int value = 0;
	
	private Suit suitVo = null;
	private Rank rankVo = null;
	
	private Boolean visible = false;
	
	public static void main(String[] args) {
		CardVO card = new CardVO(new Suit("Diamonds", 1), new Rank("Jack", 11));
		System.out.println(card);
	}
	
	//empty constructor
	public CardVO() {
		
	}
	
	public CardVO(Suit suiteVo, Rank rankVo) {
		this.suitVo = suiteVo;
		this.rankVo = rankVo;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return rankVo.getName() + " of " + suitVo.getName();
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

	/**
	 * @return the suitVo
	 */
	public Suit getSuitVo() {
		return suitVo;
	}

	/**
	 * @param suitVo the suitVo to set
	 */
	public void setSuitVo(Suit suitVo) {
		this.suitVo = suitVo;
	}

	/**
	 * @return the rankVo
	 */
	public Rank getRankVo() {
		return rankVo;
	}

	/**
	 * @param rankVo the rankVo to set
	 */
	public void setRankVo(Rank rankVo) {
		this.rankVo = rankVo;
	}

	/**
	 * @return the visible
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

}
