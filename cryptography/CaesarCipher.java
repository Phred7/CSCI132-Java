package cryptography;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * @author Maddi Tandberg and Walker Ward
 * @version 2.0
 * @since 2/24/2019
 *
 */

public class CaesarCipher {

	protected char[] encoder = new char[26];
	protected char[] decoder = new char[26];

	private static Scanner input = new Scanner(System.in); // used to take in inputs from the user

	/**
	 * given... unchanged
	 * 
	 * @param rotation
	 */
	public CaesarCipher(int rotation) {
		for (int k = 0; k < 26; k++) {
			encoder[k] = (char) ('A' + (k + rotation) % 26);
			decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
		}
	}

	/**
	 * used to run a cipher with one or three keys. This method will run all of the
	 * correct methods in the correct order for either.
	 * 
	 * @param str pass in "ONE" to use one key or any other string for a three digit
	 *            key
	 */
	public CaesarCipher(String str) {
		int cryption;
		String message;
		if (str == "ONE") {
			int key = getKeyOne();
			cryption = choice();
			message = getMessage(cryption);
			for (int k = 0; k < 26; k++) {
				encoder[k] = (char) ('A' + (k + key) % 26);
				decoder[k] = (char) ('A' + (k - key + 26) % 26);
			}
			if (cryption == 0) {
				message = encrypt(message);
				System.out.println(message);
			} else if (cryption == 1) {
				message = decrypt(message);
				System.out.println(message);
			}
		} else if (str == "THREE"){
			int key[] = getKeyThree();
			cryption = choice();
			message = getMessage(cryption);
			if (cryption == 0) {
				message = encryptThree(message, key);
				System.out.println(message);
			} else {
				message = decryptThree(message, key);
				System.out.println(message);
			}
		}else {
			System.out.println("Error reading string");
		}
	}
	
	public CaesarCipher(String str, int numDigits) {
		int cryption;
		String message;
		if(numDigits <= 10) {
			int keyN[] = getKeyN(numDigits);
			cryption = choice();
			message = getMessage(cryption);
			if (cryption == 0) {
				message = encryptN(message, keyN, numDigits);
				System.out.println(message);
			} else {
				message = decryptN(message, keyN, numDigits);
				System.out.println(message);
			}
		}else if(numDigits <= 19) {
			int keyN[] = getKeyNLong(numDigits);
			cryption = choice();
			message = getMessage(cryption);
			if (cryption == 0) {
				message = encryptN(message, keyN, numDigits);
				System.out.println(message);
			} else {
				message = decryptN(message, keyN, numDigits);
				System.out.println(message);
			}
		}else {
			int keyN[] = getKeyNBigInt(numDigits);
			cryption = choice();
			message = getMessage(cryption);
			if (cryption == 0) {
				message = encryptN(message, keyN, numDigits);
				System.out.println(message);
			} else {
				message = decryptN(message, keyN, numDigits);
				System.out.println(message);
			}
		}
		
	}

	/**
	 * given... unchanged
	 * 
	 * @param message
	 * @return
	 */
	public String encrypt(String message) {
		return transform(message, encoder);
	}

	/**
	 * given... unchanged
	 * 
	 * @param secret
	 * @return
	 */
	public String decrypt(String secret) {
		return transform(secret, decoder);
	}

	/**
	 * given... unchanged
	 * 
	 * @param original
	 * @param code
	 * @return
	 */
	private String transform(String original, char[] code) {
		char[] msg = original.toCharArray();
		for (int k = 0; k < msg.length; k++) {
			if (Character.isUpperCase(msg[k])) {
				int j = msg[k] - 'A';
				msg[k] = code[j];
			} else if (Character.isLowerCase(msg[k])) {

			}
		}
		return new String(msg);
	}

	/**
	 * This method will encrypt any message with a three digit key. It converts the
	 * message to a character array in order to index. Then it uses ASCII int values
	 * to determine what to do with each character
	 * 
	 * @param message string message that user wants to encrypt
	 * @param key     int array with three indices which are equal to each digit of
	 *                the key
	 * @return the encrypted message
	 */
	private String encryptThree(String message, int[] key) {
		char[] charMessage = message.toCharArray(); //converts the message to a char array for manipulation
		for (int i = 0; i < charMessage.length; i++) { //runs through every character in the message
			if (charMessage[i] > 90 || charMessage[i] < 65) { //if message is not uppercase
				if (charMessage[i] > 96 && charMessage[i] < 122) { //if char ASCII value is lowercase
					if (charMessage[i] + key[i % 3] > 122) { //if char ASCII value is greater than z = 122 when the key is added 
						charMessage[i] = (char) (charMessage[i] + key[i % 3] - 26); //sets the char value = to encrypted value and ensure stays in alphbet
					} else {
						charMessage[i] = (char) (charMessage[i] + key[i % 3]); //sets the char value to new encrypted value
					}
				} else {
					charMessage[i] = charMessage[i]; //keeps non-alphabetic characters as themself ie. space
				}
			} else if (charMessage[i] + key[i % 3] > 90) { //if an upper case and value + key out of alphabet keep inside by subtracting 26
				charMessage[i] = (char) (charMessage[i] + key[i % 3] - 26); //sets new value
			} else {
				charMessage[i] = (char) (charMessage[i] + key[i % 3]); //sets new value
			}
		}
		message = new String(charMessage); //converts char array back to string for return
		return message;
	}

	/**
	 * This method will encrypt any message with a three digit key. It converts the
	 * message to a character array in order to index. Then it uses ASCII int values
	 * to determine what to do with each character
	 * 
	 * @param coded encrypted message that the user enters
	 * @param key   int array with three indices which are equal to each digit of
	 *              the key
	 * @return String array for the decrypted message
	 */
	private String decryptThree(String coded, int[] key) {
		char[] charMessage = coded.toCharArray(); // converts String message to char Array for manipulation
		for (int i = 0; i < charMessage.length; i++) { // loops through entire message
			if (charMessage[i] > 90 || charMessage[i] < 65) { // if not upper case
				if (charMessage[i] > 96 && charMessage[i] < 123) { // if lower case
					if (charMessage[i] - key[i % 3] < 96) { // if the ASCII value is less than a (96)
						charMessage[i] = (char) (charMessage[i] - key[i % 3] + 26); // sets the value by adding 26
					} else {
						charMessage[i] = (char) (charMessage[i] - key[i % 3]); // sets the value
					}
				} else {
					charMessage[i] = charMessage[i]; // set the value of any character other than an upper case or lower
														// case as itself
				}
			}
			if (charMessage[i] > 64 && charMessage[i] < 91) { // if upper case
				if (charMessage[i] - key[i % 3] < 65) { // if the value - respective key is less than A add 26 to get
														// back into alphabet
					charMessage[i] = (char) (charMessage[i] - key[i % 3] + 26); // sets value
				} else {
					charMessage[i] = (char) (charMessage[i] - key[i % 3]); // sets value
				}
			}
		}
		coded = new String(charMessage); // converts decrypted message into a string for return
		return coded;
	}
	
	private String encryptN(String message, int[] key, int n) {
		char[] charMessage = message.toCharArray(); //converts the message to a char array for manipulation
		for (int i = 0; i < charMessage.length; i++) { //runs through every character in the message
			if (charMessage[i] > 90 || charMessage[i] < 65) { //if message is not uppercase
				if (charMessage[i] > 96 && charMessage[i] < 122) { //if char ASCII value is lowercase
					if (charMessage[i] + key[i % n] > 122) { //if char ASCII value is greater than z = 122 when the key is added 
						charMessage[i] = (char) (charMessage[i] + key[i % n] - 26); //sets the char value = to encrypted value and ensure stays in alphbet
					} else {
						charMessage[i] = (char) (charMessage[i] + key[i % n]); //sets the char value to new encrypted value
					}
				} else {
					charMessage[i] = charMessage[i]; //keeps non-alphabetic characters as themself ie. space
				}
			} else if (charMessage[i] + key[i % n] > 90) { //if an upper case and value + key out of alphabet keep inside by subtracting 26
				charMessage[i] = (char) (charMessage[i] + key[i % n] - 26); //sets new value
			} else {
				charMessage[i] = (char) (charMessage[i] + key[i % n]); //sets new value
			}
		}
		message = new String(charMessage); //converts char array back to string for return
		return message;
	}

	private String decryptN(String coded, int[] key, int n) {
		char[] charMessage = coded.toCharArray(); // converts String message to char Array for manipulation
		for (int i = 0; i < charMessage.length; i++) { // loops through entire message
			if (charMessage[i] > 90 || charMessage[i] < 65) { // if not upper case
				if (charMessage[i] > 96 && charMessage[i] < 123) { // if lower case
					if (charMessage[i] - key[i % n] < 96) { // if the ASCII value is less than a (96)
						charMessage[i] = (char) (charMessage[i] - key[i % n] + 26); // sets the value by adding 26
					} else {
						charMessage[i] = (char) (charMessage[i] - key[i % n]); // sets the value
					}
				} else {
					charMessage[i] = charMessage[i]; // set the value of any character other than an upper case or lower
														// case as itself
				}
			}
			if (charMessage[i] > 64 && charMessage[i] < 91) { // if upper case
				if (charMessage[i] - key[i % n] < 65) { // if the value - respective key is less than A add 26 to get
														// back into alphabet
					charMessage[i] = (char) (charMessage[i] - key[i % n] + 26); // sets value
				} else {
					charMessage[i] = (char) (charMessage[i] - key[i % n]); // sets value
				}
			}
		}
		coded = new String(charMessage); // converts decrypted message into a string for return
		return coded;
	}

	/**
	 * this method gets the message from the user regardless of encryption or
	 * decryption
	 * 
	 * @param choice used to determine which message to print (encoder/decoder)
	 * @return the string message input by the user
	 */
	private String getMessage(int choice) {
		input.nextLine();
		String message = "";
		if (choice == 0) {
			System.out.println("Enter message to encrypt:");
			message = input.nextLine();
			// System.out.println(message);
		} else if (choice == 1) {
			System.out.println("Enter message to decrypt:");
			message = input.nextLine();
			// System.out.println(message);
		}
		return message;
	}

	/**
	 * this method asks the user if they want to encrypt or decrypt their message
	 * 
	 * @return int value representing encryption (0) or decryption (1) or 2 if an
	 *         impropper value is entered
	 */
	private int choice() {
		System.out.print("0 for encrypt, 1 for decrypt:");
		while (!input.hasNextInt()) {
			System.out.println("Need a digit");
			String x = input.next();
		}
		int choice = input.nextInt();
		if (choice == 0) {
			return 0;
		} else if (choice == 1) {
			return 1;
		} else {
			System.out.println("NOPE");
			return 2;
		}
	}

	/**
	 * used to get a one digit key from the user
	 * 
	 * @return key
	 */
	private int getKeyOne() {
		System.out.print("Enter one digit key: ");
		while (!input.hasNextInt()) {
			System.out.println("Need a digit");
			String x = input.next();
		}
		int key = input.nextInt();
		System.out.println(key);
		return key;
	}

	/**
	 * gets a three digit integer key from the user
	 * 
	 * @return key as a three digit integer array with the first digit as key[0]
	 */
	private int[] getKeyThree() {
		int keyInt;
		int key[] = new int[3];
		System.out.print("Enter three digit key: ");
		while (!input.hasNextInt()) {
			System.out.println("Need an integer");
			String x = input.next();
		}
		keyInt = input.nextInt();
		key[2] = keyInt % 10;
		key[1] = ((keyInt - key[2]) % 100) / 10;
		key[0] = ((keyInt - key[1]) % 1000) / 100;
		System.out.println(key[0] + " - " + key[1] + " - " + key[2] + "\n");
		return key;
	}
	
	public int[] getKeyN(int n) {
		int keyInt;
		int key[] = new int[n];
		System.out.printf("Enter your %d digit key: ", n);
		while (!input.hasNextInt()) {
			System.out.println("Need an integer");
			String x = input.next();
		}
		keyInt = input.nextInt();
		int j = 1;
		key[n-1] = keyInt % 10;
		for(int i = n-2; 0 <= i; i--) {
			key[i] = (((keyInt - key[i+1]) % (int)(Math.pow(10, j+1))) / (int)(Math.pow(10, j)));
			j++;
			
		}
		for(int k = 0; k < n - 1; k++) {
			System.out.printf("%d - ", key[k]);
		}
		System.out.printf("%d\n", key[n-1]);
		return key;
	}
	
	public int[] getKeyNLong(int n) {
		long keyInt;
		int key[] = new int[n];
		System.out.printf("Enter your %d digit key: ", n);
		while (!input.hasNextLong()) {
			System.out.println("Need an long integer");
			String x = input.next();
		}
		keyInt = input.nextLong();
		int j = 1;
		key[n-1] = (int)(keyInt % 10);
		for(int i = n-2; 0 <= i; i--) {
			key[i] = (int)(((keyInt - key[i+1]) % (long)(Math.pow(10, j+1))) / (long)(Math.pow(10, j)));
			j++;
			
		}
		for(int k = 0; k < n - 1; k++) {
			System.out.printf("%d - ", key[k]);
		}
		System.out.printf("%d\n", key[n-1]);
		return key;
	}
	
	public int[] getKeyNBigInt(int n) {
		int key[] = new int[n];
		System.out.println("\n**NOTICE: Will throw NumberFormatException and crash if characters other than numbers are entered**\n\n");
		System.out.printf("Enter your %d digit key: ", n);
		BigInteger keyInt = new BigInteger(input.next());
		BigInteger modulo = BigInteger.TEN;
		BigInteger divisor = BigInteger.ONE;
		BigInteger remainder;
		int smallRemainder;
		remainder = keyInt.mod(modulo);
		//System.out.println(remainder);
		remainder = remainder.divide(divisor);
		//System.out.println(remainder);
		smallRemainder = remainder.intValue();
		//System.out.println(smallRemainder);
		key[n-1] = (smallRemainder); //last value = 9 should result in (keyInt%10)/1
		for(int i = n-2; 0 <= i; i--) {
			modulo = modulo.multiply(BigInteger.TEN);
			divisor = divisor.multiply(BigInteger.TEN);
			keyInt = keyInt.subtract(remainder);
			remainder = keyInt.mod(modulo);
			remainder = remainder.divide(divisor);
			smallRemainder = remainder.intValue();
			//System.out.println(smallRemainder);
			key[i] = smallRemainder; //(((KeyInt - lastRemainder) % 10^(j+1)) / (10^j);			
		}
		for(int k = 0; k < n - 1; k++) {
			System.out.printf("%d - ", key[k]);
		}
		System.out.printf("%d\n", key[n-1]);
		return key;
	}
}
