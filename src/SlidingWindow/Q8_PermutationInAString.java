package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q8_PermutationInAString {
    public static void main(String[] args) {
        System.out.println("Permutation exist: " + solution("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + solution("odicf", "dc"));
        System.out.println("Permutation exist: " + solution("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + solution("aaacb", "abc"));
    }

    public static boolean solution(String str, String pattern) {
        int left = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) {
                return true;
            }

            if (right >= pattern.length() - 1) {
                char leftChar = str.charAt(left);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
                left++;
            }
        }
    }
}
