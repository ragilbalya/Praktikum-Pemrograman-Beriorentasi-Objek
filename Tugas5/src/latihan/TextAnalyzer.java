package latihan;

import java.util.HashSet;
import java.util.Set;

public class TextAnalyzer {

    public int countUniqueWords(String text) {
        if (text == null || text.trim().isEmpty()) return 0;

        String[] words = text.toLowerCase().split("\\s+");

        Set<String> unique = new HashSet<String>();
        for (String w : words) {
            if (!w.trim().isEmpty()) {
                unique.add(w);
            }
        }
        return unique.size();
    }
}