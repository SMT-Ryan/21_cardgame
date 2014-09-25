package Riker.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack implements CardGame {

	
	// empty constructor
	public BlackJack() {
		
	}
	
	public static void main(String[] args) {

		BlackJack blackJack = new BlackJack();
		blackJack.process();
		
	}

	/**
	 * This process method inside the BlackJack class is the game object and 
	 * 	acts as its environment.
	 * 
	 * @Override
	 */
	public void process() {
		
		int playerPopulation = 0;
		int increaseBy = 0;
		int betPool = 0;
		List<Player> players = new ArrayList<Player>();
		
		
		//declares a deck followed by shuffling the deck
		Deck deck = new StandardDeck();
		deck = deck.shuffle(deck);
		
		//declares a dealer, and sets its variables
		Dealer dealer = new Dealer();
		dealer.setAge(34);
		dealer.setFirstName("Baron_Duke");
		dealer.setLastName("Ferdinand");
		dealer.setPersonalID(1138);
		dealer.setDealer(true);
		dealer.setPlayerAlias("The Baron");
		players.add(dealer);
		playerPopulation++;
		
		//title message
		System.out.println("Black Jack: A work in progress by Ryan J. Riker");
		System.out.println("(c)  Copyright 2014");
		System.out.println("");
		
		//welcome message
		System.out.println("Welcome, my name is " + dealer.getFirstName() + " "
				+ dealer.getLastName() + " but my friends call me " + 
				dealer.getPlayerAlias() +".");
		System.out.println("I will be dealing today");
		
		//start game setup.
		//get number of players, declare and set all players.
		System.out.println("How many of you folks are joining us today?");
		increaseBy = addNewPlayers(players);
		playerPopulation = playerPopulation + increaseBy;
		
		//draw cards for dealer
		System.out.println("The Dealers Hand:");
		for (int i = 0 ; i <2; i++){
		dealer.drawCardToHand(dealer.getHand(), deck);
		}		
		
		//display first card
		System.out.println("The dealer is showing a ");
		dealer.getHand().printDealerHand(deck);
		//end game setup
		
		
		
		//play players hands in order 1-?
	
		
		//testing code
		System.out.println("number of players " + playerPopulation);
		//test players list
		for (int i = 0; i<players.size(); i++){
			System.out.println("name: " + players.get(i).getFirstName());
		}
		
		
	}
	


	/**
	 * This method iterates once per new none dealer player, it sets the variables 
	 * for one new player per loop.
	 * @param player passed in  the list of current players.
	 * @return number of players added.
	 */
	private int addNewPlayers(List<Player> player) {
		Scanner sc = new Scanner(System.in);
		int numberOfPlayers = 0;
		
		numberOfPlayers = sc.nextInt();
		//consumes extra new line char.
		sc.nextLine();
		
	
		for (int count = 0; count < numberOfPlayers; count++ ){
		if (count != 1138){
			
		Player newPlayer = new Player();
		
		newPlayer.setPersonalID(count);	
		newPlayer.setWallet(200);
		newPlayer.setDealer(false);
		
		System.out.println("Please, enter player" + (count+1) + "'s first name ");
		newPlayer.setFirstName(sc.nextLine());
		System.out.println("Please, enter player" + (count+1) + "'s last name ");
		newPlayer.setLastName(sc.nextLine());
		System.out.println("let me know what you would prefer to be called?");
		System.out.println("Its alrght if you dont want to be called something "
				+ "special just press the ENTER key");
		newPlayer.setPlayerAlias(sc.nextLine());
		
		player.add(newPlayer);
		
		}
		}
		
		sc.close();
		return numberOfPlayers;
	}

	@Override
	public void checkWin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestShulle() {
		// TODO Auto-generated method stub
		
	}

	
	
}
