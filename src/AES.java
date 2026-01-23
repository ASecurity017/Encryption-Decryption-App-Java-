
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AES {

  // All properties declared as private constants 


  // Full name of the AES encryption standard
  private static final String fullName = "Advanced Encryption Standard";

  // For User Information only does not affect the mode actually being selected 
  private static final String modeSelected = "CBC - Cipher Block Chaining";

  // Names of the cryptographers who designed the AES algorithm
  private static final String createdBy = "Joan Daemen and Vincent Rijmen";

   // Year the AES algorithm was originally created
  private static final int yearCreated = 1998;

  // Specifies the encryption algorithm, mode of operation, and padding scheme
  // AES algorithm using CBC mode with PKCS5 padding
  private static final String ALGO = "AES/CBC/PKCS5Padding";

   // Method that Encrypts a plaintext message using AES encryption 
  public static String encrypt(String message, IvParameterSpec iv, SecretKey key) throws Exception {

    // Create a Cipher instance configured with the specified algorithm, mode, and padding
    Cipher cipher = Cipher.getInstance(ALGO);

     // Initialize the cipher in encryption mode using the provided secret key and IV
    cipher.init(Cipher.ENCRYPT_MODE,key, iv);

     // Convert the plaintext message into bytes and encrypt it
    byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

    // Encoding the ciphertext into a Base64 string so it can be safely stored or transmitted as text

    // Note: The Iv must be stored alongside the ciphertext 
    // for decryption 
    return Base64.getEncoder().encodeToString(encryptedBytes);

  }

  // Method that Decrypts a Base64-encoded ciphertext message using AES decryption
  public static String decrypt(String messageToDecrypt, SecretKey secretKey, IvParameterSpec iv) throws Exception {
    
    // Create an instnace of the cipher object defining what algorithm, mode, and padding it will be using
    Cipher cipher = Cipher.getInstance(ALGO);

    // Initializing the cipher to decrypt mode , passing the secret key and iv in as parameters
    cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

    // Decode the Base64-encoded ciphertext and decrypt it into a byte array
    byte[] MessageToDecryptInBytes = cipher.doFinal(Base64.getDecoder().decode(messageToDecrypt));

     // Convert the decrypted byte array back into a readable String
    String decryptedMessage = new String(MessageToDecryptInBytes);

    // Return the original plaintext message 
    return decryptedMessage;

  }
  
  // Method to convert the new Secret Key to a String 
  public static String convertSecretKeyToString(SecretKey secretKey) throws NoSuchAlgorithmException {
    // Encoding the secret key passed into a byte array called rawData
    byte[] rawData = secretKey.getEncoded();
    // Encoding the byte array as a String then encoding it using Base64 
    String encodedKey = Base64.getEncoder().encodeToString(rawData);

    // Return the encoded key 
    return encodedKey;

  }

  // Getter Methods 

  public static String getCreatedBy(){

    return AES.createdBy;

  }

  public static int getYearCreated(){

    return AES.yearCreated;
  }

  public static String getFullName(){

    return AES.fullName;
  }

  public static String getMode(){

    return AES.modeSelected;
  }



}
