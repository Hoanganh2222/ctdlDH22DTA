import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Utils {

	 public static Set<String> loadWord(String fileName) throws FileNotFoundException {
		    // Create a set to store the words
		    Set<String> words = new HashSet<>();
		    // Create a scanner to read the file
		    Scanner scanner = new Scanner(new File(fileName));
		    // Loop through each line in the file
		    while (scanner.hasNextLine()) {
		      // Get the next line and split it by whitespace
		      String line = scanner.nextLine();
		      String[] tokens = line.split("\\s+");
		      // Loop through each token and add it to the set
		      for (String token : tokens) {
		        // Remove any punctuation and convert to lower case
		        token = token.replaceAll("\\p{Punct}", "").toLowerCase();
		        // Add the token to the set if it is not empty
		        if (!token.isEmpty()) {
		          words.add(token);
		        }
		      }
		    }
		    // Close the scanner
		    scanner.close();
		    // Return the set of words
		    return words;
		  }
}
