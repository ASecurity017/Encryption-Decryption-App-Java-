
import java.security.SecureRandom;
import javax.crypto.spec.IvParameterSpec;

// AES in CBC mode requires an IV (initialization vector) to ensure unique encryption for identical inputs

public class AESIVProvider {
  
 public static IvParameterSpec generateIv(){
  byte[] iv = new byte[16];   // Creating a 16-byte array as AES works on 16-byte blocks 
  new SecureRandom().nextBytes(iv); // Using the SecureRandom to fill the array with random bytes, ensuring uniqueness for the same input
  return new IvParameterSpec(iv); // Wrap the obtained the IV array in IvParamaterSpec class which will be required for enc/dec
 }
}
