package Riker.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BlackJack implements CardGame {
	//globally declared instance of scanner used through out program.
	Scanner ms = new Scanner(System.in);
	
	// empty constructor
	public BlackJack() {
		
	}
	/**
	 * Main method contains instance of BlackJack() and calls the process 
	 * method
	 * @param args
	 */
	public static void main(String[] args) {

		BlackJack blackJack = new BlackJack();
		blackJack.process();
		
	}

	/**
	 * The process method inside the BlackJack class 
	 * 	controls the flow of login for one round of Black Jack
	 * 
	 * @Override
	 */
	public void process() {
		
		int playerPopulation = 0;
		List<Player> players = new ArrayList<Player>();
		Message mg = new Message();
		
		//declare a deck followed by shuffling the deck
		DeckVO deck = new StandardDeck();
		deck = deck.shuffle(deck);
		
		//declares a dealer, and sets its variables
		Dealer dealer = new Dealer();
		loadDealer(players, dealer, playerPopulation);
		
		//calls game set up
		playerPopulation = gameSetUp(dealer, playerPopulation, players, deck, 
				mg);
		
		//collects bets and plays non dealer player's hand 
		playHand(players, deck, dealer, mg);
		
		//plays the dealers hand
		playDealerHand(deck, dealer, mg);
		
		//check win
		checkWin(players, playerPopulation, mg);
		
		//discard hands set hand value to zero
		handsToDiscard(players, (StandardDeck) deck);
		
		//check deck size and request shuffle
		requestShuffle(deck);
		
		//restart process at continue some point after players were added.
		requestContinue(players, deck, dealer, mg);
		
	}
	/**
	 * Over rides the original process, when there is no need to re-make the 
	 * deck	or players.
	 * @param players
	 * @param deck
	 */
	private void reprocess(List<Player> players, DeckVO deck, Dealer dealer, 
		 Message mg) {
		int playerPopulation = players.size() -1;
		
		//draw cards for dealer
		dealerSetup(dealer, deck);		
		
		//collects bets and plays non dealer player's hand 
		playHand(players, deck, dealer, mg);

		//plays the dealers hand
		playDealerHand(deck, dealer, mg);

		//check win
		checkWin(players, playerPopulation, mg);
		
		//discard hands set hand value to zero
		handsToDiscard(players, (StandardDeck) deck);
		
		//check deck size and request shuffle
		requestShuffle(deck);
		
		//restart process at continue some point after players were added.
		requestContinue(players, deck, dealer, mg);
		
	}
	/**
	 * draws the two cards for the dealers hand at the start of the game
	 * @param dealer current dealer
	 * @param deck a standard deck of 52
	 */
	private void dealerSetup(Dealer dealer, DeckVO deck) {
		for (int i = 0 ; i <2; i++){
			dealer.drawCardToHand(dealer.getHand(), deck);
		}
		
	}
	/**
	 * This method will let the users decide to run the game again.
	 * @param deck 
	 * @param players 
	 * @param playerPopulation 
	 * @param dealer 
	 * @param mg instance of the message class.
	 */
	private void requestContinue(List<Player> players, DeckVO deck, 
			Dealer dealer, Message mg) {
		String input = null;
		while(true){
			try {
				mg.displayMessage(Message.CONTINUE_MESSAGE);
				input = ms.nextLine().toUpperCase();
				if (input.equals("Y")){
					this.reprocess(players, deck, dealer, mg);
					break;
				}else if (input.equals("N")){
					mg.displayMessage(Message.THANKYOU);
					break;
				}else{
					mg.displayMessage(Message.INCORRECT_INPUT);
				}
			}catch(NumberFormatException e){
				
			}
		}
	}

	/**
	 * This method will take all cards from all players hands and place them
	 * into the discard pile.
	 * @param players the list of all active players
	 * @param deck a standard deck of 52 cards
	 */
	private void handsToDiscard(List<Player> players, StandardDeck deck) {
	
		for (int i = 0; i < players.size(); i++){
			//copies cards to discard pile
			for(int c = 0; c < players.get(i).getHand()
					.getNumberOfCardsInHand(); c++){
				
				deck.discardCard(players.get(i).getHand().
						getCardsInHand().get(c));
			}
			players.get(i).getHand().getCardsInHand().clear();
			players.get(i).getHand().setValue(0);
			players.get(i).getHand().setNumberOfCardsInHand(0);
		}
	}

	/**
	 * method that contains the dealer playing its hand.  
	 * @param deck a standard deck of 52 cards
	 * @param dealer 
	 */
	private void playDealerHand(DeckVO deck, Dealer dealer, Message mg) {
		
		//sets dealers hands value
		setHandValue(dealer.getHand(), dealer , deck);
		
		dealer.printHand(deck);
		
		//loops while not busted
		while (dealer.getHand().getValue() < 21){
			//if hand value is less 17 forces dealer to take a card
			if (dealer.getHand().getValue() <= 17) {
				
				mg.displayMessage(2, dealer.getHand().getValue(), 
						dealer.getPlayerAlias());
				
				dealer.drawCardToHand(dealer.getHand(), deck);
				setHandValue(dealer.getHand(), dealer, deck);
				dealer.getHand().printHand(deck);	
				mg.displayMessage(6, dealer.getHand().getValue());

			}else if (dealer.getHand().getValue() >16) {
				
				mg.displayMessage(3, dealer.getHand().getValue(), 
						dealer.getPlayerAlias());
				
				dealer.getHand().printHand(deck);
				mg.displayMessage(6, dealer.getHand().getValue());
				break;
			} 
			if (dealer.getHand().getValue() == 21) {
			dealer.getHand().printHand(deck);
			mg.displayMessage(6, dealer.getHand().getValue());
			break;
			}
		}
	}

	/**
	 * sets all the non dealer players bets, and executes hit or stay logic.
	 * @param players
	 * @param dealer 
	 */
	public void playHand(List<Player> players, DeckVO deck, Dealer dealer,
			Message mg) {
		
		mg.displayMessage(4);
		
		for (int i = 0 ; i < players.size(); i++){
			
			addressUser(i, players);
			
			if (!players.get(i).isDealer()){
				
			 	// collects bets from all non dealer players
				placeBet(i, players, mg);

				//give non dealer players two cards
				playerDeal(players.get(i).getHand() , deck, dealer);

				//assigns a value to players hand
				setHandValue(players.get(i).getHand(), dealer , deck);
				
				//this method loops a request for hit or stay response from user
				requestHitStay(players.get(i), dealer, deck, mg);
			}	
		}
	}
	/**
	 * This method handles a loop of hit requests until bust or stay is issued 
	 * @param activePlayer the active player object
	 * @param dealer the dealer
	 * @param deck	a standard deck of 52 cards
	 * @param mg the message handling class
	 */
	private void requestHitStay(Player activePlayer, Dealer dealer, DeckVO deck,
			Message mg) {
		if (activePlayer.getHand().getValue() == 21){
			
			mg.displayMessage(12);
		}
		
		//loops while not busted
		while (activePlayer.getHand().getValue() < 21){
			String input = null;
		
			//hit or stay message
			mg.displayMessage(5 , 
					activePlayer.getHand().getValue());
		try{
			//collect response from user
			input = ms.nextLine().toUpperCase();
			//hit logic
			if (input.equals("H")) {
				
				mg.displayMessage(8);
				dealer.drawCardToHand(activePlayer.getHand(), deck);
				setHandValue(activePlayer.getHand(), dealer, deck);
			}else if (input.equals("S")) {
			
				mg.displayMessage(11);
				break;
			} 
		}catch(NumberFormatException e){
			//let loop repeat
		}
			//player bust
			if (activePlayer.getHand().getValue() > 21){
				mg.displayMessage(10);
			}
			
			activePlayer.getHand().printHand(deck);
			mg.displayMessage(6, 
					activePlayer.getHand().getValue());
		
		}
		
	}

	/**
	 * This method addresses the user by player or their preferred name
	 * @param i the current element in the list of players
	 * @param players list of players
	 */
	private void addressUser(int i, List<Player> players) {
		Message mg = new Message();
		if (!players.get(i).isDealer()){
			if(players.get(i).getPlayerPreferredName().equals("Player")) {
				
				//address user by player number
				mg.displayMessage(1, i, 
						players.get(i).getWallet());
			}else {
				
				//address user by preferred name
				mg.displayMessage(1, players.get(i).getWallet(), 
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
	private void setHandValue(Hand hand, Dealer dealer, DeckVO deck) {
		
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
	 * @param i the current element in the list of players
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
				mg.displayMessage(7);
				hand.getCardsInHand().get(i).setValue(11);
			}
	}

	/**
	 * gives the current player two cards, calls a method hit  
	 * until player busts or stays
	 * @param dealer 
	 */
	private void playerDeal(Hand hand, DeckVO deck, Dealer dealer) {
		for (int i = 0 ; i <2; i++){
		dealer.drawCardToHand(hand, deck);
		}
		hand.printHand(deck);
	}

	/**
	 * This method sets the user input for bet into the players betPool 
	 * attribute
	 * @param i the current element in the list of players
	 * @param players  the current list of players
	 */
	private void placeBet(int i, List<Player> players, Message mg) {

		while(true){
			try {
				int bet = Integer.parseInt(getInput());
				if (players.get(i).getWallet() >  bet) {
				//set input to bet pool
				players.get(i).setBetPool(bet);
				//remove funds from wallet
				players.get(i).setWallet(players.get(i).getWallet() - 
						players.get(i).getBetPool());
				break;
				}else{
					mg.displayMessage(Message.LOW_FUND, 
							players.get(i).getWallet());
				}
			}catch(NumberFormatException e){
				mg.displayMessage(3);		
			}
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
		DeckVO deck, Message mg) {
	
			//title message
			mg.displayMessage(Message.WELCOME);
			
			//welcome message
			mg.displayMessage(Message.WELCOME, dealer);
			
			//start game setup.
			//get number of players, declare and set all players.
			mg.displayMessage(Message.REQUEST_NUMBER_OF_PLAYERS);
			playerPopulation = playerPopulation + addNewPlayers(players, mg);
			
			//draw cards for dealer
			dealerSetup(dealer, deck);		

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
		dealer.setPlayerPreferredName(dealer.getPlayerAlias());
	
		players.add(dealer);
		playerPopulation++;
	}

	/**
	 * This method iterates once per new none dealer player, it sets the 
	 * variables for one new player per loop.
	 * @param player passed in  the list of current players.
	 * @return number of players added.
	 */
	private int addNewPlayers(List<Player> player, Message mg) {
		int numberOfPlayers = 0;
		
		while(numberOfPlayers == 0){
			try{
				numberOfPlayers = Integer.parseInt(getInput());
			} catch (NumberFormatException e){
				mg.displayMessage(3);		
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
		
				mg.displayMessage(4, (count+1));
				fn = getInput();
				newPlayer.setFirstName(fn);
				
				if (!fn.equals("") && !fn.equals(null)){
					newPlayer.setPlayerPreferredName(fn);
				}
				
				mg.displayMessage(6);
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
	 * @param mg2 
	 * @param playerPopulation 
	 * 
	 * @Override
	 */
	public void checkWin(List<Player> players, int population, Message mg) {
		for(int i = 0; i <= population; i++){
			if (!players.get(i).isDealer()) {
	
				//if dealer busts all non busted players get their bet + 10
				if (players.get(0).getHand().getValue() >= 22){
					mg.displayMessage(13);
					playerWin(players.get(i), players.get(0), 10);
				}else{
					//if dealer didn't bust compare values
					//players hand is higher but not busted win bet +15
					if(players.get(i).getHand().getValue() < 21 && players
						.get(i).getHand().getValue() > 	players.get(0).getHand()
						.getValue()){
						
						mg.displayMessage(14);
						playerWin(players.get(i), players.get(0), 15);
					}
					//dealer hand is higher player loses bet pool
					if(players.get(i).getHand().getValue() < 21 && 	players
						.get(i).getHand().getValue() < players.get(0).getHand()
						.getValue()){
						mg.displayMessage(15);
						playerLose(players.get(i), players.get(0));
					}
					//if player has a 21 player wins their bet + 25, extra bonus 
					//only if the dealer didn't bust
					if ( players.get(i).getHand().getValue() == 21){
						mg.displayMessage(16);
						playerWin(players.get(i), players.get(0), 25);
					} 
					//if player bust they lose
					if (players.get(i).getHand().getValue() > 21){
						mg.displayMessage(17);
						playerLose(players.get(i), players.get(0));
					}
				}
			}
		}
	}

	
/**
 * This method moves funds from the wallet of the dealer, and the bet pool of 
 * 	the player to the wallet in the player.
 * @param winner Winner player
 * @param dealer dealer player
 * @param bonusAmount extra amount of funds based on win conditions
 */
	public void playerWin(Player winner, Player dealer, int bonusAmount){
		int totalPrize = 0;
		
		//sets the total prize for winning
		totalPrize = winner.getBetPool() + bonusAmount;
		//removes the bonus winnings from the dealers wallet
		dealer.setWallet(dealer.getWallet() - bonusAmount);
		//takes the prize and deposits it in the winners wallet
		winner.setWallet(winner.getWallet() + totalPrize);
		//winners bet pool reset to 0 state
		winner.setBetPool(0);
	}
	
	/**
	 * This method moves funds from the losers bet pool into the dealers wallet
	 * @param loser losing player
	 * @param dealer dealer player
	 */
	public void playerLose(Player loser, Player dealer){
		
		//losers bet pool is moved to dealers wallet
		dealer.setWallet(dealer.getWallet() + loser.getBetPool());
		//losers bet pool reset to zero
		loser.setBetPool(0);	
	}
	
	/**
	 * This method make sure at least half the deck is in the ready cards list
	 * if not the method will instruct the discard pile to add it self to the 
	 * ready cards and shuffle.
	 * @Override
	 */
	public void requestShuffle(DeckVO deck) {

		if (deck.getReadyCards().size() < 25){
			deck.reload();
			deck.shuffle(deck);
		}
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
