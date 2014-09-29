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
		loadDealer(dealer);

		players.add(dealer);

		playerPopulation++;
		
		//calls game set up
		playerPopulation = gameSetUp(dealer, playerPopulation, players, deck);
		
		//collect bets from all players
		//play players hands 
		
		playHand(players, deck, dealer);
		
		//dealer draws
		playDealerHand(players, deck, dealer);
		
		//check win
		
		//move funds
		
		//discard hands set hand value to zero
		
		//check deck size and request shuffle or just re-shuffle at the end of
		//each hand
		
	}
	
	private void playDealerHand(List<Player> players, Deck deck, Dealer dealer) {
		// TODO Auto-generated method stub
		
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
				
			/*
			 * collects bets from all non dealer players
			 */
					placeBet(i, players);

			/*
			 * give non dealer players two cards
			 */

				playerDeal(players.get(i).getHand() , deck, dealer);

 			/*
			 *assigns a value to players hand
			 */

				setHandValue(players.get(i).getHand(), dealer , deck);
			
			//loops while not busted
			while (players.get(i).getHand().getValue() < 21){
				String input = null;
				//hit or stay message
				mg.displayEnglishMessage(5 , players.get(i).getHand().getValue());
				
				//collect response from user
				input = ms.nextLine().toUpperCase();
				if (input.equals("H")) {
					dealer.drawCardToHand(players.get(i).getHand(), deck);
					setHandValue(players.get(i).getHand(), dealer, deck);
					players.get(i).getHand().printHand(deck);	
					mg.displayEnglishMessage(6, players.get(i).getHand().getValue());
					//TODO bug check message remove later
					System.out.println("hit");
				}
				if (input.equals("S")) {
					//stay
					players.get(i).getHand().printHand(deck);
					mg.displayEnglishMessage(6, players.get(i).getHand().getValue());
					//TODO bug check remove
					System.out.println("stay");
					break;
				} 
				///TODO remove testing message
				System.out.println("busted");
				players.get(i).getHand().printHand(deck);
				mg.displayEnglishMessage(6, players.get(i).getHand().getValue());
				
			}
			}else{
				//do nothing dealer
			}
				
		}
		
		System.out.println("dealer draw up");
			

					
		
	}
		
	/**
	 * This method will be replaced with a shorter one
	 * @param i element to select correct player
	 * @param players list of players
	 */
	private void addressUser(int i, List<Player> players) {
		Message mg = new Message();
		if (players.get(i).isDealer()){
			//skips over the dealer-player due to them not betting
		}else if (players.get(i).getFirstName().equals("") && 
					players.get(i).getPlayerAlias().equals("")){
				/*
				 * address user by player number
				 */
				mg.displayEnglishMessage(1, i, 
						players.get(i).getWallet());
		}else if(players.get(i).getFirstName().equals("")  &&
					!players.get(i).getPlayerAlias().equals("") ){
				/*
				 * address user by nickname
				 */
				mg.displayEnglishMessage(1, players.get(i).getWallet(), 
						players.get(i).getPlayerAlias());
		}else if (players.get(i).getPlayerAlias().equals("")  && 
					!players.get(i).getFirstName().equals("") ){
				/*
				 * address user by first name
				 */
				mg.displayEnglishMessage(1, players.get(i).getWallet(), 
						players.get(i).getFirstName());
		}else if (!players.get(i).getPlayerAlias().equals("")  && 
					!players.get(i).getFirstName().equals("")){
			/*
			 * address user by nickname
			 */
			mg.displayEnglishMessage(1, players.get(i).getWallet(), 
					players.get(i).getPlayerAlias());
		}else{					
			//error
				mg.displayEnglishMessage(5);
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
		
		System.out.println("this is working");
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
 * @param dealer
 */
	private void loadDealer(Dealer dealer) {
		dealer.setAge(34);
		dealer.setFirstName("Baron_Duke");
		dealer.setLastName("Ferdinand");
		dealer.setPersonalID(1138);
		dealer.setDealer(true);
		dealer.setPlayerAlias("The Baron");		
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
		 * This method generates the new players by user input
		 */
		for (int count = 0; count < numberOfPlayers; count++ ){
			if (count != 1138){
				
				Player newPlayer = new Player();
				
				newPlayer.setPersonalID(count);	
				newPlayer.setWallet(200);
				newPlayer.setDealer(false);
		
				mg.displayEnglishMessage(4, (count+1));
		
				newPlayer.setFirstName(getInput());
				
				mg.displayEnglishMessage(6);


				newPlayer.setPlayerAlias(getInput());
				player.add(newPlayer);
				
				//TODO make a preferred name in player class if both are blank 
				//set name to player [count]
			
			}
		}

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
