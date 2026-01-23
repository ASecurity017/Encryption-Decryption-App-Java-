


public class CaesarCipher {

    private static final String createdBy = "Julius Caesar";

    private static final String yearCreated = "N/A" ;
    
    // Encrypts a plaintext message using the Caesar Cipher with the provided shift amount
    // Each alphabetical character is shifted forward by the given amount, while spaces are preserved
    public static String encryptString(String message, int shift){
      
      String newMessage = "";
      // Iterate through each chracter in the message
      for (char character: message.toCharArray()){
        // Encrypt only non-space characters
        if(character != ' '){
          // Determine the character's position in the alphabet (0-25)
          int originalAlphabetPosition = character - 'a';

          int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
          char newCharacter = (char) ('a' + newAlphabetPosition);
          newMessage += (newCharacter);
        } else {
          // Append the encrypted character to the result string 
          newMessage += (character);
        }
      }
      // Return the encrypted message 
      return newMessage;
    }

    // Decrypts a message that was encrypted using the Caesar Cipher
    // Decryption is performed by reversing the original shift value
    public static String decryptString(String messageToDecrypt, int shift){

        // Calculate the inverse shift required to reverse the encryption
        int decryptShift = 26 - (shift - 26);

         // Reuse the encryption method with the inverse shift to decrypt the message
        String decryptedMessage = encryptString(messageToDecrypt, decryptShift);

        // Return the decrypted plaintext message
        return decryptedMessage;
    }



    // Getter method to return created by property
    public static String getCreatedBy(){

      return CaesarCipher.createdBy;

    }

    public static String getYearCreated(){

      return CaesarCipher.yearCreated;
    }

    
}
