package cryptography;

public class CipherDriver {

	public static void main(String[] args) {
		//CaesarCipher cipher = new CaesarCipher("ONE"); //this creates an object that uses one key
		//CaesarCipher cipher1 = new CaesarCipher("THREE"); //this creates an object that uses three keys (three digit int key)
		
		//CaesarCipher cipherNenc = new CaesarCipher("N", 10); //max for int is 10 digits
		//CaesarCipher cipherNdec = new CaesarCipher("N", 10); 
		//CaesarCipher cipherNenc2 = new CaesarCipher("N", 19); //max for a long is 19 digits
		//CaesarCipher cipherNdec2 = new CaesarCipher("N", 19);
		CaesarCipher cipherNenc3 = new CaesarCipher("N", 343); //max is 2,147,483,647 digits
		CaesarCipher cipherNdec3 = new CaesarCipher("N", 343);
		
	}

}
