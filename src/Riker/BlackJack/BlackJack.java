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
		//play players hands in order 1-?
		playHand(players, deck, dealer);
		
	}
	
	/**
	 * sets all the non dealer players bets.
	 * @param players
	 * @param dealer 
	 */
	public void playHand(List<Player> players, Deck deck, Dealer dealer) {
	
		//int bet = 0;
		//boolean b = true;
		
		System.out.println("its time for everyone to anti up!");
		
		
		for (int i = 0 ; i < players.size(); i++){
				if (players.get(i).isDealer() == true){
					System.out.println("So partners whats your bets?");
				}else{
					if (players.get(i).getFirstName().equals("") && 
							players.get(i).getPlayerAlias().equals("")){
					/*
					 * address user by player number
					 */
					System.out.println("player " + i + " you have " +
							players.get(i).getWallet() + 
							" left in your wallet.1");
					
					
					System.out.println("Player " + i + 
							" please enter the amount "
							+ "you wish to risk.");
					
					}else if(players.get(i).getFirstName().equals("")  ||
							!players.get(i).getPlayerAlias().equals("") ){
						/*
						 * address user by nickname
						 */
						System.out.println(players.get(i).getPlayerAlias() + 
								" you have " + players.get(i).getWallet() + 
								" left in your wallet.2");
						
						System.out.println(players.get(i).getPlayerAlias() + 
								" please enter the amount "+ 
								"you wish to risk.");

					}else if (players.get(i).getPlayerAlias().equals("")  || 
							!players.get(i).getFirstName().equals("") ){
						/*
						 * address user by first name
						 */
						System.out.println(players.get(i).getFirstName() + 
								" you have " + players.get(i).getWallet() + 
								" left in your wallet.3");
						
						System.out.println(players.get(i).getFirstName() + 
								" please enter the amount "+ 
								"you wish to risk.");
					}else{
						//error
						System.out.println("selecting a name has gone horribly "
								+ "wrong.");
					}
				}
				//collect bets from all players
				placeBet(i, players);
				//give players two cards and ask if they want to hit or stay.
				playerDeal(players.get(i).getHand() , deck);
		}

	}

	
	/**
	 * gives the current player two cards, calls a method hit  
	 * until player busts or stays
	 */
	private void playerDeal(Hand hand, Deck deck) {
		
		
	}

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
			Message em = new Message();
			//title message
			em.displayEnglishMessage(1);
			
			//welcome message
			em.displayEnglishMessage(1, dealer);
			
			//start game setup.
			//get number of players, declare and set all players.
			em.displayEnglishMessage(2);
			playerPopulation = playerPopulation + addNewPlayers(players);
			
			//draw cards for dealer
			for (int i = 0 ; i <2; i++){
			dealer.drawCardToHand(dealer.getHand(), deck);
			}		
			
			//display dealers cards for all
			dealer.getHand().printDealerHand(deck);
			//end game setup
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
		int numberOfPlayers = 0;
		
		while(numberOfPlayers == 0){
			try{
			
				numberOfPlayers = Integer.parseInt(getInput());
	
			} catch (java.util.NoSuchElementException e){
				System.out.println("That was not a number, plase try again");
			
			}
		}
		
		for (int count = 0; count < numberOfPlayers; count++ ){
			if (count != 1138){
					
				Player newPlayer = new Player();
				
				newPlayer.setPersonalID(count);	
				newPlayer.setWallet(200);
				newPlayer.setDealer(false);
		
				System.out.println("Please, enter player" + (count+1) + 
						"'s first name ");
			
				newPlayer.setFirstName(getInput());
				
				System.out.println("let me know what you would prefer to be "
						+ "called?");
				System.out.println("Its alrght if you dont want to be called "
						+ "something special just press the ENTER key");
				newPlayer.setPlayerAlias(getInput());
				player.add(newPlayer);
			
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
		
		
		System.out.println("******************");
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
