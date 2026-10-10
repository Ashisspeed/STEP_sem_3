import java.util.*;

public class A5 {
    public static void printFilteredWordFrequency(String feedback) {
        List<String> stopWords = Arrays.asList("the", "was", "and", "a", "is", "of", "in");
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");
        
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String word : words) {
            if (word.isEmpty()) continue;
            if (!stopWords.contains(word)) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}