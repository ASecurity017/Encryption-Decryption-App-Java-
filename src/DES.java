
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class DES {


  // Fullname of the DES encryption standard
  private static String fullName = "Data Encryption Stnadard";

  // For User Information only does not affect the mode actually being selected 
  private static final String modeSelected = "ECB - Electonic Code Book";

  // Names of the company who designed the DES algorithm
  private static String createdBy = "IBM";
  // Year the DES algorithm was originally created
  private static int yearCreated = 1970;
  // Specifies the encryption algorithm, mode of operation, and padding scheme
  // DES algorithm using ECB mode with PKCS5 padding
  private static String ALGO = "DES/ECB/PKCS5Padding";

  // Method that Encrypts a plaintext message using DES encryption
  public static String encrypt(String message, SecretKey key) throws Exception {

    // Create a Cipher instance configured with the specified algorithm, mode, and padding
    Cipher cipher = Cipher.getInstance(ALGO);
    
    // Initialize the cipher in encryption mode using the provided secret key 
    cipher.init(Cipher.ENCRYPT_MODE, key);

    // Convert the plaintext message into bytes and encrypt it
    byte[] ciphertext = cipher.doFinal(message.getBytes());
    
    // Encoding the ciphertext into a Base64 string so it can be safely stored or transmitted as text
    return Base64.getEncoder().encodeToString(ciphertext);
  }


  // Method that decrypts a Base-64 encoded ciphertext message using DES encryption 
  public static String decrypt(String encryptedMsg, SecretKey key) throws Exception{
    
    // Create an instnace of the cipher object defining what algorithm, mode, and padding it will be using
    Cipher cipher = Cipher.getInstance(ALGO);

    // Initialize the cipher in decryption mode using the provided secret key 
    cipher.init(Cipher.DECRYPT_MODE, key);

     // Decode the Base64-encoded ciphertext and decrypt it into a byte array
    byte[] ciphertext = Base64.getDecoder().decode(encryptedMsg);

    // Convert the decrypted byte array back into a readable String
    byte[] plaintextAsBytes = cipher.doFinal(ciphertext);
    
    //Return the original plaintext message 
    return new String(plaintextAsBytes);


  }


   // Getter Methods 

  public static String getCreatedBy(){

    return DES.createdBy;

  }

  public static int getYearCreated(){

    return DES.yearCreated;
  }

  public static String getFullName(){

    return DES.fullName;
  }

  public static String getMode(){

    return DES.modeSelected;
  }
}
