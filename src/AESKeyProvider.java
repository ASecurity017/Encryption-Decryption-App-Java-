import java.security.NoSuchAlgorithmException;
import javax.crypto.*;

public class AESKeyProvider {

  public static SecretKey generateKey() throws NoSuchAlgorithmException{
    
    KeyGenerator generator = KeyGenerator.getInstance("AES");  // Create an instance of a key generator specifically for AES
    generator.init(256);  // Set key size for key as 256 (for strong encryption)
    SecretKey newGeneratedKey = generator.generateKey();
    
    return newGeneratedKey; // return generated key 
  }
}
