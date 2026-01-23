
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DESKeyProvider {
  
  // Method that generates a secret key 
  public static SecretKey generateKey() throws NoSuchAlgorithmException{
    // Creates an insatnce of KeyGenerator
    KeyGenerator generator = KeyGenerator.getInstance("DES");

    generator.init(56); // DES uses a 56-bit symmetric key 

    SecretKey newKey = generator.generateKey(); // Generate the new 56-bit symmetric key in a variable called newKey

    return newKey; // return the newly generated key


  }
}
