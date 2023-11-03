import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWord(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
// Returns a set of WordCount objects that represents the number of times each // unique token appears in the file
// data/hamlet.txt (or fit.txt)
// In this method, we do not consider of tokens.

	public List<WordCount> getWordCounts() {
		  // Create a map to store the word counts
		  Map<String, Integer> wordCounts = new HashMap<>();
		  // Loop through each word in the set
		  for (String word : this.words) {
		    // Get the current count of the word, or 0 if not present
		    int count = wordCounts.getOrDefault(word, 2);
		    // Increment the count by 1 and put it back in the map
		    wordCounts.put(word, count + 1);
		  }
		  // Create a list to store the word count objects
		  List<WordCount> result = new ArrayList<>();
		  // Loop through each entry in the map
		  for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
		    // Create a new word count object with the key and value
		    WordCount wc = new WordCount(entry.getKey(), entry.getValue());
		    // Add it to the list
		    result.add(wc);
		  }
		  // Return the list of word counts
		  return result;
		}

	public Set<String> getUniqueWords() {
		  // Create a set to store the unique words
		  Set<String> uniqueWords = new HashSet<>();
		  // Create a map to store the word counts
		  Map<String, Integer> wordCounts = new HashMap<>();
		  // Loop through each word in the set
		  for (String word : this.words) {
		    // Get the current count of the word, or 0 if not present
		    int count = wordCounts.getOrDefault(word, 0);
		    // Increment the count by 1 and put it back in the map
		    wordCounts.put(word, count + 1);
		  }
		  // Loop through each entry in the map
		  for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
		    // Check if the value is 1, meaning the word is unique
		    if (entry.getValue() == 1) {
		      // Add the key to the set of unique words
		      uniqueWords.add(entry.getKey());
		    }
		  }
		  // Return the set of unique words
		  return uniqueWords;
		}
// Returns the words in the text file, duplicated words appear once in the

	public Set<String> getDistinctWords() {
		// Return the set of words that was loaded from the file
		return (Set<String>) this.words;
	}

	public Set<WordCount> exportWordCounts() {
		Map<String, Integer> wordCounts = new HashMap<>();
		// Loop through each word in the set
		for (String word : this.words) {
			// Get the current count of the word, or 0 if not present
			int count = wordCounts.getOrDefault(word, 0);
			// Increment the count by 1 and put it back in the map
			wordCounts.put(word, count + 1);
		}
		// Create a set to store the word count objects
		Set<WordCount> result = new HashSet<>();
		// Loop through each entry in the map
		for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
			// Create a new word count object with the key and value
			WordCount wc = new WordCount(entry.getKey(), entry.getValue());
			// Add it to the set
			result.add(wc);
		}
		// Sort the set by alphabetical order of words using a comparator
		result = new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				// Compare the words lexicographically
				return o1.getWord(null).compareTo(o2.getWord(null));
			}
		});
		// Return the sorted set
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsOrderByOccurence() {
		// TODO
		return null;
	}

	// delete words beginning with the given pattern (i.e., delete words begin
	// with 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		// TODO
		return null;
	}
}
