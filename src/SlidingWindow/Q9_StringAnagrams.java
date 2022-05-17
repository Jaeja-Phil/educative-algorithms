package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q9_StringAnagrams {
    public static void main(String[] args) {
        System.out.println(solution("ppqp", "pq")); // [1, 2]
        System.out.println(solution("abbcabc", "abc")); // [2, 3, 4]
    }

    public static List<Integer> solution(String str, String pattern) {
        int left = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();

        for (int right = 0; right < str.length(); right++) {
            Character rightChar = str.charAt(right);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) {
                ans.add(left);
            }

            if (right >= pattern.length() - 1) {
                Character leftChar = str.charAt(left++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return ans;
    }
}
