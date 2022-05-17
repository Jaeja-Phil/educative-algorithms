package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q11_WordsConcatenation {
    public static void main(String[] args) {
        List<Integer> result = solution("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result); // [0, 3]
        result = solution("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result); // [3]
    }

    public static List<Integer> solution(String str, String[] words) {
        int wordsCount = words.length, wordLength = words[0].length();
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < str.length() - wordLength * wordsCount; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIdx = i + j * wordLength;
                String word = str.substring(nextWordIdx, nextWordIdx + wordLength);
                if (!wordFrequencyMap.containsKey(word)) {
                    break;
                }
                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0)) {
                    break;
                }
                if (j + 1 == wordsCount) {
                    ans.add(i);
                }
            }
        }

        return ans;
    }
}
