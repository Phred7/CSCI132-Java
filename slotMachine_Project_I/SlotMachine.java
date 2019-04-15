package slotMachine_Project_I;

import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
	
		//ints used for debugging
		private int wins = 0;
		private int tris = 0;
		private int losses = 0;
	
		//for us in the program
		public int bet = 1;
		private int lastBet = -1;
		private int round = 1;
		private double winnings = 0;
		private double balance = 100;
		private int[] score = new int[3];
		private boolean win = false; //if the user won something
		private boolean tri = false; //if the user got three identical
		private boolean duo = false; //if the user got two identical (in the proper arrangement)
		private boolean gameover = false;
		private boolean betValidity = false;
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
	public SlotMachine() { //constructor

	}
	
	public void setBet() { //method to allow the user to input a bet. It also checks to see if a bet is valid or if the user wants to cash out
		while(betValidity == false) { 
			System.out.println("Bet Amount: ");
			bet = input.nextInt();
			if(bet == -1) { //cash out
				gameover = true;
				betValidity = true;
			}else if(bet < -1 || bet == 0) { //invalid bet
				System.out.println("That bet is invalid please enter a valid bet");
			}else {
				betValidity = true;
			}
		}
		betValidity = false;
	}
	
	private void setWinnings(int _bet) { //calculates the winnings for a certain combination of scores
		if(win == true && tri == true) { //if won and got three
			winnings = score[0] * _bet * 5;
			tris++;
			//System.out.format("Round#: %d. Balance += winnings: %d += %d%n", round, balance, winnings);
		}else if(win == true && duo == true) { //if won and got two
			winnings = score[0] * _bet;
			wins++;
			//System.out.format("Round#: %d. Balance += winnings: %d += %d%n", round, balance, winnings);
		}else {
			winnings = -_bet; //lost
			losses++;
			//System.out.format("Round#: %d. Balance += winnings: %d += %d%n", round, balance, winnings);
		}
		balance = balance + winnings;
	}
	
	public int getBet() { //returns the bet
		return bet;
	}
	
	public double getBalance() { //returns the balance
		return balance;
	}
	
	public double getWinnings() { //returns the winnings
		return winnings;
	}
	
	public void reset() { //used after each round
		round += 1;
		win = false;
		duo = false;
		tri = false;
		winnings = 0;
		if(bet != -1) { //if the user has ended the game
			lastBet = bet;
		}
	}
	
	public void generateSlot() { //populates the array with three random ints
		for(int i = 0; i < score.length; i++) { 
			score[i] = rand.nextInt(7) + 1; //adds a random number between 1 and 7 (inclusive)
		}
	}
	
	public void setScore() { //sets score booleans
		if(score[0] == score[1] && score[0] == score[2]) { //same three
			win = true;
			tri = true;
		}else if(score[0] == score[1] && score[0] != score[2]) { //same two (at the right location)
			win = true;
			duo = true;
		}
	}
	
	public void printTitles() { //prints the intro
		System.out.format("Welcome to Dragons of Thunder Slots%nYou have $%f to start.%nEnter -1 for your bet to cash out%n%n", balance);
	}
	
	public void printCredits() { //prints the credits
		System.out.format("Thanks for playing! Ending balance: $%lf%n%n%n", balance);
	}
	
	public void printCredits(boolean multi) { //used to print the end result for a play to a given number of rounds
		if(multi == true) {
			System.out.format("After automatically playing %d rounds:%n", round-1);
			printValues(false);
			System.out.format("wins: %d, tri's: %d, losses: %d%n", wins, tris, losses); //used for debugging
		}else {
			printCredits();
		}
		input.close();
	}
	
	public void printValues() { //prints arrangement		
		System.out.println("+---+---+---+");
		System.out.println("| " + score[0] + " | " + score[1] + " | " + score[2] + " |");
		System.out.println("+---+---+---+");
		System.out.format("Win: $%f%n", winnings);
		System.out.format("Balance: $%f%n", balance);
	}
	
	public void printValues(boolean roundNumber) { //prints arrangement with rounds number if true
		if(roundNumber == true) {
			System.out.format("Round: %d%n", round);		
			System.out.println("+---+---+---+");
			System.out.println("| " + score[0] + " | " + score[1] + " | " + score[2] + " |");
			System.out.println("+---+---+---+");
			System.out.format("Win: $%f%n", winnings);
			System.out.format("Balance: $%f%n", balance);
		}else {
			printValues();
		}
	}
	
	public void play() { //method to play rounds until the user inputs -1 for the bet (see method setBet fo logic)
		printTitles();
		setBet();
		while(gameover == false) { //makes sure the user has not asked to end the game
			generateSlot();
			setScore();
			setWinnings(bet);
			printValues(true);
			reset();
			setBet();
		}
		printCredits();
	}
	
	public void play(int numRounds) { //method to play a given number of rounds (bet must be reentered)
		printTitles();
		while(gameover == false) {
			for(int i = 0; i < numRounds; i++) {
				setBet();
				reset();
				generateSlot();
				setScore();
				setWinnings(bet);
			}
			gameover = true;
		}
		printCredits();
		input.close();
	}
	
	public void play(int numRounds, boolean autoPlay) { //method to play a entered number of rounds automatically bet is the same as the last bet
		if(autoPlay == true) {
			if(lastBet == -1) {
				setBet();
			}
			for(int i = 0; i < numRounds; i++) { //runs given number of rounds withour changing the bet
				reset();
				generateSlot();
				setScore();
				setWinnings(lastBet); //uses last be because bet will equal -1 or 0 if used at specific times
			}
			printCredits(true);
		}else {
			play(numRounds);
		}
	}
}
