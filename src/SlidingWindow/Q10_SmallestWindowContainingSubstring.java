package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q10_SmallestWindowContainingSubstring {
    public static void main(String[] args) {
        System.out.println(solution("aabdec", "abc")); // "abdec"
        System.out.println(solution("aabdec", "abac")); // "aabdec"
        System.out.println(solution("abdbca", "abc")); // "bca"
        System.out.println(solution("adcad", "abc")); // ""
    }

    public static String solution(String str, String pattern) {
        int left = 0, matched = 0, minLen = str.length() + 1, subStrLeft = 0;
        String ans = "";
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) >= 0) {
                    matched++;
                }
            }

            while (matched == pattern.length()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    ans = str.substring(left, left + minLen);
                }

                char leftChar = str.charAt(left++);
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
