import java.time.LocalDateTime;
import java.util.Scanner;


public class MyKeyProvider {

  // All properties declared as private constants

  private static String keyName = "";
  private static String keyPassword = "";
  private static String secretPassword = "";
  private static int keyId;
  private static LocalDateTime dateCreated;

  // Constructor Method (Allows us to create mutiple instances of the same class)
  public void MyKeyProvider(String keyName,  String keyPassword, String secretPassword, int keyId, LocalDateTime dateCreated){

    this.keyName = keyName;
    this.keyPassword = keyPassword;
    this.secretPassword = secretPassword;
    this.keyId = keyId;
    this.dateCreated = dateCreated;

  }


  // Getter and Setter Methods 

  public void setKeyName(String keyName){
    this.keyName = keyName;
  }

  public void setKeyPassword(String keyPassword){
    this.keyPassword = keyPassword;
  }

  public void setSecretPassword(String secretPassword){
    this.secretPassword = secretPassword;
  }

  public void setKeyId(int keyId){

    this.keyId = keyId;
  }

  public void setDateCreated(LocalDateTime dateCreated){
    this.dateCreated = dateCreated;
  }


  public String getKeyName(){
    
    return keyName;
  }

  public String getKeyPassword(){
    
    return keyPassword;
  }

  public String getSecretPassword(){
    return secretPassword;
  }

  public int getKeyId(){

    return keyId;
  }

  public LocalDateTime getDateCreated(){
    return dateCreated;
  }

  // Creates and initializes a new secret key by prompting the user for required information 
  public static MyKeyProvider createKey(MyKeyProvider newKey){
    
    // Create a Scanner object to read user input from the console
    Scanner inputScanner = new Scanner(System.in);

    System.out.println("###############");
    System.out.println("Key Generator");
    System.out.println("###############");
    // Prompt the user to enter a unique ID number for the secret key
    System.out.println();
    System.out.println("Enter an id number for your secret key:");
    String userInput = inputScanner.nextLine();

    // Convert user input from string to int
    int userInputAsInt = Integer.parseInt(userInput);

    // Assign the entered ID number to the key object
    newKey.setKeyId(userInputAsInt);

   // Prompt the user to enter a password for the secret key 
    System.out.println("Enter a secure password for your secret key:");
    userInput = inputScanner.nextLine();

     // Store the entered password in the key object 
    newKey.setKeyPassword(userInput);

    // Prompt the user to enter a secondary (secret) password for added security 
    System.out.println("Enter a Secret password for your secret key:");
    userInput = inputScanner.nextLine();

    // Store the secret password in the key object
    newKey.setSecretPassword(userInput);

    // Prompt user to enter a name for the secret key 
    System.out.println("Enter a name for your secret key:");
    userInput = inputScanner.nextLine();

    // Assign the entered name to the key object 
    newKey.setKeyName(userInput);

     // Set the creation timestamp of the key to the current date and time
    newKey.setDateCreated(LocalDateTime.now());
   
    
   // Return the fully populated key object 
    return newKey;


  }


  // Method to find a user's key and display its information 
  public static void findMyKey(MyKeyProvider newKey){

    // Call function to verify the user attempting to find a key
    Boolean userAuthorised = verifyUser(newKey);

    // If user is verifed 
    if (userAuthorised == true){
    // Println statements to display the key information to the verified user 
    System.out.println();
    System.out.println("##############################");
    System.out.println("#" + " Name of Key:" + newKey.getKeyName());
    System.out.println("#" + " Password for Key:" + newKey.getKeyPassword());
    System.out.println("#" + " Secret Password for Key:" + newKey.getSecretPassword());
    System.out.print("#" + " Key Id:" );System.out.println(newKey.getKeyId());
    System.out.println("#" + " Date of Creation:");
    System.out.println("#" + newKey.getDateCreated());
    System.out.println("##############################");
    }
  
  }

  // Method that verifies the user before allowing them to find their key 
  public static Boolean verifyUser(MyKeyProvider newKey){
    // Scanner object to read in the user input 
    Scanner myScanner = new Scanner(System.in);
    // String variable to store the user input 
    String userInput;
    // Assume the user is not verified by default 
    Boolean isVerified = false;

    System.out.println("---User Verification System---");
    System.out.println("Enter your key name: ");
    userInput = myScanner.nextLine();
    // If user inputs the correct key name continue with verification process 
    if(userInput.equals(newKey.getKeyName())){

        System.out.println("Enter your key's password: ");
        userInput = myScanner.nextLine();
        if(userInput.equals(newKey.getKeyPassword())){

          // Set isVerified flag to true 
          isVerified = true;

          
        }


    } else {
      // Else tell the user they have failed to enter the correct credentials 
      System.out.println("Incorrect Credentials Provided - Try Again Later");
    }

    // Return isVerified flag to function call 
    return isVerified;


  }

}
