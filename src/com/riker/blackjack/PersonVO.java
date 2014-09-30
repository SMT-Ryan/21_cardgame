package com.riker.blackjack;

/**
 * <b>Title</B>: PersonVO.java Description: Java code of a person. A person object
 * 		will at minimum hold a first and last name as strings, and personalID 
 * 		and age as integers.  
 * 
 * Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
 *
 * @author: Ryan Riker
 * @version 1.0
 * @since 09/23/2014 
 * last update: never
 */

public class PersonVO {

	private String firstName = null;
	private String lastName = null;
	private int personalID = 0;
	private int age = 0;
	
	
	
		//Empty constructor
	public PersonVO() {
		
	}

		//setters and getter methods
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPersonalID() {
		return personalID;
	}

	public void setPersonalID(int personalID) {
		this.personalID = personalID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
