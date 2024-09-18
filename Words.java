package words;

import java.util.List;
import java.util.ArrayList;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
    	// Remove all the punctuation in the string and split the string into a list of strings
    	// by splitting the sentence with every space
    	String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    	List<String> indi_words = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
        	// Checking if the word in the sentence is already in the individual words list
        	if(indi_words.contains(words[i]) == false) {
        		indi_words.add(words[i]);
        	}
        }
        return indi_words;
    }
}
