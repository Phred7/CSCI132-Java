package slotMachineII;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Simulation of a slot machine.
 * 
 * Note: A slot machine functions by removing the bet every time you play regardless of if you win any money back. 
 * This issue was not addressed in V1.0 or V2.0 and is fixed now. 
 * 
 * @author Walker Ward
 * @version 3.0
 */
public class SlotMachineII {
	
	/**
	 * these are used for debugging and file output
	 */
	public File file = new File("file.csv");
	FileWriter fileWriter = null;
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//Header
	private static final String FILE_HEADER = "round, bet, winnings, balance";
	
	
	/**
	 * Fields 
	 * Some are statics so that the writeCsvFile() method fuctions properly
	 */
	private static int bet = 0; //default user bet
	private int lastBet = 0; //used for automatically played round updates through reset()
	private static int round = 1; //round number
	private static double winnings = 0; //how much the user wins in a given round
	private static double balance = 100; //starting user balance will be updated later
	private int[] score = new int[3]; //array used to store the current slots ie: 7, 3, 1
	private boolean gameover = false; //if the user decides to end the game this is used to ensure the game ends
	private boolean betValidity = false; //used to determine if the user's bet is with in the specified bounds !0, =-1 || <100
	
	
	/**
	 * Object declarations
	 */
	Scanner input = new Scanner(System.in); //used to get inputs from the user
	Random rand = new Random(); //used to generate slots as random numbers
	
	/**
	 * Constructor
	 */
	public SlotMachineII() {

	}
	
	/**
	 * Is used to set this bet of an instance of the class.
	 * Also checks to ensure that the bet is valid and will not end without one.
	 * a bet of -1 will cause the game to end. The current bet limit is 100.
	 * Uses Scanner class to get the input
	 */
	private void setBet() {
		while(betValidity == false) {
			System.out.println("Bet Amount: ");
			while(!input.hasNextInt()) {
				System.out.println("Error: Please enter an integer: ");
				String x = input.next();
			}
			bet = this.input.nextInt();
			if(bet == -1) {
				this.gameover = true;
				betValidity = true;
			}else if(bet < -1 || bet == 0) { //|| bet > 100
				System.out.println("That bet is invalid. Please enter a valid bet (max bet: $100)");
			}else {
				betValidity = true;
			}
		}
		betValidity = false;
	}
	
	/**
	 * resets all values (that need it) to their defaults.
	 * lastBet is updated
	 */
	private void reset() {
		round += 1;
		winnings = 0;
		if(bet != -1) {
			lastBet = bet;
			bet = 0;
		}
	}
	
	/**
	 * fills the score[] with random values between (and including) 1-7
	 */
	private void generateSlots() {
		for(int i = 0; i < this.score.length; i++) {
			this.score[i] = this.rand.nextInt(7) + 1;
		}
	}
	
	/**
	 * @deprecated
	 * used for debugging
	 */
	private void generateSlotsD() {
		this.score[0] = this.rand.nextInt(7) + 1;
		this.score[1] = this.rand.nextInt(7) + 1;
		this.score[2] = this.rand.nextInt(7) + 1;
	}
	
	/**
	 * Calculates the balance based on the users score
	 * Fixed through debugging: bet was not removed prior to score calculation resulting in a positive output after 
	 */
	private void getScore() {
		balance -= Math.abs(bet); //initial bet
		if(this.score[0] == this.score[1] && this.score[1] == this.score[2]) {
			balance += Math.abs(bet) * 5 * this.score[0];
			winnings = Math.abs(bet) * 5 * this.score[0];
		}else if(this.score[0] == this.score[1]) {
			balance += Math.abs(bet) * this.score[0];
			winnings = Math.abs(bet) * this.score[0];
		}else {
			winnings = -Math.abs(bet);
		}
		
		
	}
	
	/**
	 * @deprecated
	 * See method getScore() for brief explanation.
	 * Basically it gives a positive number after 1mill runs.
	 */
	private void getScoreDep() {
		if(this.score[0] == this.score[1] && this.score[1] == this.score[2]) {
			balance += Math.abs(bet) * 5 * this.score[0];
			winnings = Math.abs(bet) * 5 * this.score[0];
		}else if(this.score[0] == this.score[1]) {
			balance += Math.abs(bet) * this.score[0];
			winnings = Math.abs(bet) * this.score[0];
		}else {
			winnings = -Math.abs(bet);
		}
		
		
	}
	
	/**
	 * Prints the title scene
	 */
	private void printTitles() {
		System.out.format("Welcome to Carbon Drangon Slots%nYou have $%1.2f to start.%nEnter -1 as your bet to cash out.%n%n", balance);
	}
	
	/**
	 * Prints the default credits
	 */
	private void printCredits() {
		System.out.format("Thanks for playing! Ending balance: $%1.2f%n%n", balance);
	}
	
	/**
	 * Used to print the end results when the instance is automatically played a given number of times
	 * 
	 * @param numRounds how many round have been played (total)
	 * @param multi set to true if a given number of round was automatically played otherwise false
	 */
	private void printCredits(int numRounds, boolean multi) {
		if(multi == true) {
			System.out.format("After automatically playing %d round.%n", numRounds);
			printValues(false);
			//System.out.format();
		}else {
			printCredits();
		}
	}
	
	/**
	 * Prints the slot arrangement, current winnings and current balance
	 */
	private void printValues() {
		System.out.println("+---+---+---+");
		System.out.println("| " + this.score[0] + " | " + this.score[1] + " | " + this.score[2] + " |");
		System.out.println("+---+---+---+");
		System.out.format("Win: $%1.2f%nBalance: $%1.2f%n", winnings, balance);
	}
	
	/**
	 * Prints the slot arrangement, current winnings and current balance with the current round number
	 * @param roundNumber when true the current round is printed as well if false it defaults to the normal method
	 */
	private void printValues(boolean roundNumber) {
		if(roundNumber == true) {
			System.out.format("Round: %d%n", round);
			System.out.println("+---+---+---+");
			System.out.println("| " + this.score[0] + " | " + this.score[1] + " | " + this.score[2] + " |");
			System.out.println("+---+---+---+");
			System.out.format("Win: $%1.2f%nBalance: $%1.2f%n", winnings, balance);
		}else {
			printValues();			
		}
	}
	
	/**
	 * plays the slot machine until a user enters -1 as the bet.
	 * Runs all methods in specific order and closes input stream (another method cannot be called by the same instance)
	 */
	public void play() {
		printTitles();
		setBet();
		while(!this.gameover) {
			generateSlots();
			getScore();
			printValues(true);
			reset();
			setBet();			
		}
		printCredits();
		this.gameover = false;
	}
	
	/**
	 * Plays the slot machine until a user enters -1 as the bet or the number of round has been met (which ever is first)
	 * Runs all methods in specific order and closes input stream (another method cannot be called by the same instance)
	 * Note: Bet will be reset in every round
	 * @param numRounds maximum number of round to be played. 
	 */
	public void play(int numRounds) {
		if(numRounds <= 1) {
			printTitles();
			setBet();
			for(int i = 0; i<numRounds; i++) {
				generateSlots();
				getScore();
				printValues(true);
				reset();
				setBet();	
			}
		}else {
			System.out.println("Why do you only want to play 1?... \n--End--");
		}
		printCredits();
		this.gameover = false;
	}
	
	/**
	 * Plays the slot machine until a user enters -1 as the bet or the number of round has been met (which ever is first)
	 * Runs all methods in specific order and closes input stream (another method cannot be called by the same instance)
	 * Note: Bet will not be reset after every round. User will be prompted once and then the same bet will be used in ever round
	 * Note: If you have previously played rounds the last bet you entered (before -1) will be used as you bet through the automatic processing
	 * @param numRounds how round to automatically play to
	 * @param autoPlay if true automatically plays until the inputed numRounds has been reached false defaults to play(numRounds)
	 */
	public void play(int numRounds, boolean autoPlay) {
		if(numRounds >= 1 && autoPlay == true) {
			if(bet == 0) {
				printTitles();
				setBet();
				lastBet = bet;
			}
			for(int i = 0; i < numRounds; i++) {
				bet = lastBet;
				generateSlots();
				getScore();
				if(i != numRounds - 1) {
					reset();
				}								
			}
			printCredits(numRounds, true);
		}else if(numRounds <= 1){
			System.out.println("Why do you only want to play 1?... \n--End--");
		}else {
		}
	}	
	
	/**
	 * This method was used for debugging. It exports a csv file with all the changing values in this Class.
	 * 
	 * @param fileName name of the output file (do not include .csv or other type. A csv is automatically added to the name.
	 * @param numRounds Number of rounds to play through
	 */
	public void writeCsvFile(String fileName, int numRounds) {
		try {
			File file = new File(fileName + ".csv");
	        file.setWritable(true);
	        file.setReadable(true);
	        file.getAbsolutePath();
	        
	        fileWriter = new FileWriter(file);
	        
			//Write the header
			fileWriter.append(FILE_HEADER.toString());
			
			fileWriter.append(NEW_LINE_SEPARATOR);
			System.out.println("Start");
			for(int i = 0; i<numRounds; i++) {
				bet = 10;
				generateSlots(); 
				getScore();
				printValues(true);
				fileWriter.append(String.valueOf(round));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(bet));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(winnings));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(balance));
				fileWriter.append(NEW_LINE_SEPARATOR);
				if(i != numRounds - 1) {
					reset();
				}
			}
			printCredits(numRounds, true);
			System.out.println("CSV file sucessfully generated");
		}catch (Exception e) {
			System.out.println("Error writing to file");
			e.printStackTrace();
		} finally {
            
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
		}	
	}
}
