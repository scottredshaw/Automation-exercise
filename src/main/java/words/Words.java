package words;

import java.util.List;
import java.util.ArrayList;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
    	// throw new UnsupportedOperationException();
    	String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    	List<String> indi_words = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
        	if(indi_words.contains(words[i]) == false) {
        		indi_words.add(words[i]);
        	}
        }
        return indi_words;
        
        
        // first thing is to split all the strings into individual words
        // make all the words lower case
        // store all the individual words in a list 
    }
}
