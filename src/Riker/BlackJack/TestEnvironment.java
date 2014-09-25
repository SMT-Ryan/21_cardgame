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
	 * This is the testing class here i will be writing code to test before adding it to my game.
	 * 
	 */
	
	public void process() {
		
		int playerPopulation = 0;

		Player testPerson = new Player();
		playerPopulation++;
		
		testPerson.setFirstName("Baron_duke");
		testPerson.setLastName("Ferdinand");
		testPerson.setAge(151);
		testPerson.setPersonalID(1138);
		
		Dealer testDealer = new Dealer();
		playerPopulation++;
		
		testDealer.setFirstName("Lester");
		testDealer.setLastName("Alabama");
		testDealer.setAge(35);
		testDealer.setPersonalID(1139);

		System.out.println("population is: " + playerPopulation);
		System.out.println(testPerson.getFirstName() + " and " +
				testDealer.getFirstName() + " are playing");
		
		/*Hand testHand = new Hand();
		testHand.addCardToHand();
		System.out.println("the hands value is: " + testHand.getValue());
		testHand.addCardToHand(testCard2);
		System.out.println("the hands value is: " + testHand.getValue());
		System.out.println("the number of cards in hand is: " + 
				testHand.getNumberOfCardsInHand());*/


		
		Deck testDeck = new StandardDeck();
		testPerson.printHand(testDeck);
		testDeck = testDeck.shuffle(testDeck);	
		
		((StandardDeck) testDeck).printDeck();
		
		testDealer.drawCardToHand(testDealer.getHand(), testDeck);
		testDealer.drawCardToHand(testDealer.getHand(), testDeck);
		testDealer.drawCardToHand(testDealer.getHand(), testDeck);
		
		((StandardDeck) testDeck).printDeck();
		
		testDealer.getHand().printDealerHand(testDeck);
	}
	
	

}
