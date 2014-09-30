package com.riker.blackjack;

/****************************************************************************
 * <b>Title</b>: Suit.java <p/>
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
public class Suit {

	private int value = 0;
	private String name = null;
	
	/**
	 * 
	 */
	public Suit(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * 
	 */
	public Suit() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
