package Riker.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BlackJack implements CardGame {
	Scanner ms = new Scanner(System.in);
	
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
		List<Player> players = new ArrayList<Player>();
		
		
		//declares a deck followed by shuffling the deck
		Deck deck = new StandardDeck();
		deck = deck.shuffle(deck);
		
		//declares a dealer, and sets its variables
		Dealer dealer = new Dealer();
		loadDealer(players, dealer, playerPopulation);
		
		//calls game set up
		playerPopulation = gameSetUp(dealer, playerPopulation, players, deck);
		
		//collects bets and plays non dealer player's hand 
		playHand(players, deck, dealer);
		
		//plays the dealers hand
		playDealerHand(deck, dealer);
		
		//check win
		checkWin(players, playerPopulation);
		
		//move funds
		
		//discard hands set hand value to zero
		
		//check deck size and request shuffle or just re-shuffle at the end of
		//each hand
		
		//restart process at some point after players were added.
		
	}
	
	/**
	 * method that contains the dealer playing its hand.  
	 * @param deck a standard deck of 52 cards
	 * @param dealer 
	 */
	private void playDealerHand(Deck deck, Dealer dealer) {
		Message mg = new Message();
		
		//sets dealers hands value
		setHandValue(dealer.getHand(), dealer , deck);
		
		dealer.printHand(deck);
		
		//loops while not busted
		while (dealer.getHand().getValue() < 21){
			

			if (dealer.getHand().getValue() <= 15) {
				
				mg.displayEnglishMessage(2, dealer.getHand().getValue(), 
						dealer.getPlayerAlias());

				dealer.drawCardToHand(dealer.getHand(), deck);
				setHandValue(dealer.getHand(), dealer, deck);
				dealer.getHand().printHand(deck);	
				mg.displayEnglishMessage(6, dealer.getHand().getValue());

			}else if (dealer.getHand().getValue() >16) {
				
				mg.displayEnglishMessage(3, dealer.getHand().getValue(), 
						dealer.getPlayerAlias());
				
				dealer.getHand().printHand(deck);
				mg.displayEnglishMessage(6, dealer.getHand().getValue());
				break;
			} 
			
			if (dealer.getHand().getValue() == 21) {
			///TODO remove testing message
			System.out.println("dealer 21");
			dealer.getHand().printHand(deck);
			mg.displayEnglishMessage(6, dealer.getHand().getValue());
			break;
			}
			
		}
		
		
		
	}

	/**
	 * sets all the non dealer players bets, and executes hit or stay logic.
	 * @param players
	 * @param dealer 
	 */
	public void playHand(List<Player> players, Deck deck, Dealer dealer) {
		Message mg = new Message();
		
		mg.displayEnglishMessage(4);
		
		for (int i = 0 ; i < players.size(); i++){
			
			addressUser(i, players);
			
			if (!players.get(i).isDealer()){
				
			 	// collects bets from all non dealer players

				placeBet(i, players);

				//give non dealer players two cards
			 	
				playerDeal(players.get(i).getHand() , deck, dealer);

				//assigns a value to players hand

				setHandValue(players.get(i).getHand(), dealer , deck);
				
				//loops while not busted
				while (players.get(i).getHand().getValue() < 21){
					String input = null;
				
					//hit or stay message
					mg.displayEnglishMessage(5 , 
							players.get(i).getHand().getValue());
				
					//collect response from user
					input = ms.nextLine().toUpperCase();
				
					//hit logic
					if (input.equals("H")) {
					
						mg.displayEnglishMessage(8);
						
						dealer.drawCardToHand(players.get(i).getHand(), deck);
					
						setHandValue(players.get(i).getHand(), dealer, deck);
					
						players.get(i).getHand().printHand(deck);	
					
						mg.displayEnglishMessage(6, 
								players.get(i).getHand().getValue());
					}
				
					//stay logic
					if (input.equals("S")) {
					
						mg.displayEnglishMessage(11);
		
						players.get(i).getHand().printHand(deck);
					
						mg.displayEnglishMessage(6, 
								players.get(i).getHand().getValue());

						break;
					} 
				
					//player bust
					mg.displayEnglishMessage(10);
				
					players.get(i).getHand().printHand(deck);
					mg.displayEnglishMessage(6, 
							players.get(i).getHand().getValue());
				
				}
			}	
		}
	}
		
	/**
	 * This method will be replaced with a shorter one
	 * @param i element to select correct player
	 * @param players list of players
	 */
	private void addressUser(int i, List<Player> players) {
		Message mg = new Message();
		if (!players.get(i).isDealer()){
			if(players.get(i).getPlayerPreferredName().equals("Player")) {
				/*
				 * address user by player number
				 */
				mg.displayEnglishMessage(1, i, 
						players.get(i).getWallet());
			}else {
				/*
				 * address user by preferred name
				 */
				mg.displayEnglishMessage(1, players.get(i).getWallet(), 
						players.get(i).getPlayerPreferredName());
			}
		}
	}

	/**
	 *This Method assigns a value to players hand, requests hit or stay or 
	 * issues bust 
	 * @param hand the players hand
	 * @param dealer the games dealer
	 * @param deck a standard 52 card deck
	 */
	private void setHandValue(Hand hand, Dealer dealer, Deck deck) {
		
		Message mg = new Message();

		hand.setValue(0);

		//assign current hand value
		for (int i = 0; i < hand.getNumberOfCardsInHand(); i++){
			
			setCardValue(i, hand, mg);
			hand.setValue(hand.getValue() + 
					hand.getCardsInHand().get(i).getValue()) ;

		}

	}

	/**
	 * This method sets the card values for a hand 
	 * @param i 
	 * @param hand is the current players hand
	 * @param mg is the message class
	 */
	private void setCardValue(int i, Hand hand, Message mg) {

			if(hand.getCardsInHand().get(i).getRank() <= 10 && 
					hand.getCardsInHand().get(i).getRank() != 1){
			 	hand.getCardsInHand().get(i).setValue
			 		(hand.getCardsInHand().get(i).getRank());
			}
			
			 //if rank is greater than ten value is ten
			if (hand.getCardsInHand().get(i).getRank() > 10){
				hand.getCardsInHand().get(i).setValue(10);
			}
			
			//ace handling
			if (hand.getCardsInHand().get(i).getRank() == 1){
				mg.displayEnglishMessage(7);
				hand.getCardsInHand().get(i).setValue(11);
			}
		
	}

	/**
	 * gives the current player two cards, calls a method hit  
	 * until player busts or stays
	 * @param dealer 
	 */
	private void playerDeal(Hand hand, Deck deck, Dealer dealer) {
		for (int i = 0 ; i <2; i++){
		dealer.drawCardToHand(hand, deck);
		}
		hand.printHand(deck);
		
		
	}

	/**
	 * This method sets the user input for bet into the players betPool 
	 * attribute
	 * @param i
	 * @param players
	 */
	private void placeBet(int i, List<Player> players) {
		if(i !=0){
			players.get(i).setBetPool(Integer.parseInt(getInput()));
		}
	}

	/**
	 * This method sets up the game by gathering and adding the players to the
	 * 	player list.  it also welcomes the user(s) and lets the dealer draw 
	 * 	its two cards.
	 * @param dealer
	 * @param playerPopulation
	 * @param players
	 * @param deck
	 * @return
	 */
private int gameSetUp(Dealer dealer, int playerPopulation, List<Player> players, 
		Deck deck) {
			Message mg = new Message();
			//title message
			mg.displayEnglishMessage(1);
			
			//welcome message
			mg.displayEnglishMessage(1, dealer);
			
			//start game setup.
			//get number of players, declare and set all players.
			mg.displayEnglishMessage(2);
			playerPopulation = playerPopulation + addNewPlayers(players);
			
			//draw cards for dealer
			for (int i = 0 ; i <2; i++){
			dealer.drawCardToHand(dealer.getHand(), deck);
			}		

			//display dealers cards for all
			dealer.getHand().printDealerHand(deck);

		return playerPopulation;
	}

/**
 * This method inputs hard coded data in the dealer object.
 * @param players 
 * @param dealer
 * @param playerPopulation 
 */
	private void loadDealer(List<Player> players, Dealer dealer, 
			int playerPopulation) {
		dealer.setAge(34);
		dealer.setFirstName("Baron_Duke");
		dealer.setLastName("Ferdinand");
		dealer.setPersonalID(1138);
		dealer.setDealer(true);
		dealer.setPlayerAlias("The Baron");	
	
		players.add(dealer);
		playerPopulation++;
	}

	/**
	 * This method iterates once per new none dealer player, it sets the 
	 * variables for one new player per loop.
	 * @param player passed in  the list of current players.
	 * @return number of players added.
	 */
	private int addNewPlayers(List<Player> player) {
		Message mg = new Message();
		int numberOfPlayers = 0;
		
		while(numberOfPlayers == 0){
			try{
			
				numberOfPlayers = Integer.parseInt(getInput());
	
			} catch (java.util.NoSuchElementException e){
				mg.displayEnglishMessage(3);		
			}
		}
		
		/*
		 * This code generates the new players by user input
		 */
		for (int count = 0; count < numberOfPlayers; count++ ){
			if (count != 1138){
				String fn = null;
				String an = null;
				
				Player newPlayer = new Player();
				
				newPlayer.setPersonalID(count);	
				newPlayer.setWallet(200);
				newPlayer.setDealer(false);
		
				mg.displayEnglishMessage(4, (count+1));
				fn = getInput();
				newPlayer.setFirstName(fn);
				
				if (!fn.equals("") && !fn.equals(null)){
				newPlayer.setPlayerPreferredName(fn);
				}
				
				mg.displayEnglishMessage(6);
				an = getInput();
				newPlayer.setPlayerAlias(an);
				
				if (!an.equals("") && !an.equals(null)){
				newPlayer.setPlayerPreferredName(an);
				}
				
				player.add(newPlayer);
						
			}
		}

		return numberOfPlayers;
	}

	/**
	 * Checks for player win conditions, uses a separate method to move funds
	 * @param playerPopulation 
	 * 
	 * @Override
	 */
	public void checkWin(List<Player> players, int playerPopulation) {
		
		for(int i = 0; i < players.size(); i++){
			if (!players.get(i).isDealer()) {
		
		//if dealer busts all non busted players get their bet + 10
		if (players.get(0).getHand().getValue() >= 22){
			System.out.println("dealer busted win bet+10");
		}else{
			//if dealer didn't bust compare values
			//players hand is higher but not busted win bet +15
			if(players.get(i).getHand().getValue() < 21 && 
				players.get(i).getHand().getValue() > 
				players.get(0).getHand().getValue()){
				System.out.println("Dealer stayied higher values win "
						+ "bet+15");
			}
			//if player has a 21 player wins their bet + 25

			if ( players.get(i).getHand().getValue() == 21){
				System.out.println("player is not the dealer and player "
						+ "has 21");
				}
			}
		}
		}
	}

	@Override
	public void requestShulle() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * opens a new scanner returns the string value entered by the user.
	 * @return
	 */
	public String getInput(){
		String input = "";
		
		try {
			input = ms.nextLine();
		
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (NullPointerException e){		
			e.printStackTrace();
		}
		
		return input;
		
	}
	
	
}
