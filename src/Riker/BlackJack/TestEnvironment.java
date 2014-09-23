package Riker.BlackJack;

/**
* <b>Title</B>: TestEnvironment.java Description: The location of test code 
* 
* Copyright: Copyright (c) 2014 Company: Silicon Mountain Technologies
*
* @author: Ryan Riker
* @version 1.0
* @since 09/23/2014 
* last update: never
**/

public class TestEnvironment {
	
	//empty constructor
	public TestEnvironment() {
	}
	//location of the main method
	public static void main(String[] args) {

		TestEnvironment TestEnviroment = new TestEnvironment();
		TestEnviroment.process();
		
	}
	
	/**
	 * The process method performs the functionality of the game.
	 * 
	 */
	
	public void process() {
		
		int playerPopulation = 0;

		Card testCard = new Card();
		
		testCard.setRank(2);
		testCard.setSuit(21);
		testCard.setValue(1138);
		
		System.out.println("card rank: " + testCard.getRank() + " card suit: " 
				+ testCard.getSuit() + " card value: " + testCard.getValue());
		
		Player testPerson = new Player();
		playerPopulation++;
		
		testPerson.setFirstName("Baron_duke");
		testPerson.setLastName("Ferdinand");
		testPerson.setAge(151);
		testPerson.setPersonalID(1138);
	
		
		System.out.println("first name: " + testPerson.getFirstName() + 
				" last name: " + testPerson.getLastName() + " age: " + 
				testPerson.getAge() + " personal ID:#" + 
				testPerson.getPersonalID());
		
		Card testCard2 = new Card();
		
		testCard2.setRank(1);
		testCard2.setSuit(77);
		testCard2.setValue(1979);
		
		Hand testHand = new Hand();
		testHand.addCardToHand(testCard);
		System.out.println("the hands value is: " + testHand.getValue());
		testHand.addCardToHand(testCard2);
		System.out.println("the hands value is: " + testHand.getValue());
		System.out.println("the num of cards in hand is: " + 
				testHand.getNumberOfCardsInHand());
		//perhaps write a way to display cards.
		
		testPerson.setHand(testHand);
		
		Dealer testDealer = new Dealer();
		playerPopulation++;
		
		testDealer.setFirstName("Lester");
		testDealer.setLastName("Alabama");
		testDealer.setAge(35);
		testDealer.setPersonalID(1139);
		
		System.out.println("population is: " + playerPopulation);
	
		System.out.println("first name: " + testDealer.getFirstName() + 
				" last name: " + testDealer.getLastName() + " age: " + 
				testDealer.getAge() + " personal ID:#" + 
				testDealer.getPersonalID());
	}

}
