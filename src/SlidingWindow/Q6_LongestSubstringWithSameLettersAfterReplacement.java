package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q6_LongestSubstringWithSameLettersAfterReplacement {
    public static void main(String[] args) {
        System.out.println(solution("aabccbb", 2));
        // 5: replace two 'c' with 'b' to have the longest repeating substring "bbbbb"
        System.out.println(solution("abbcb", 1));
        // 4: replace one 'c' with 'b' to have the longest repeating substring "bbbb"
        System.out.println(solution("abccde", 1));
        // 3: replace 'b' or 'c' with 'c' to have the longest repeating substring "ccc"
    }

    public static int solution(String str, int k) {
        int left = 0, maxLen = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            Character rightChar = str.charAt(right);
            characterFrequencyMap.put(rightChar, characterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, characterFrequencyMap.get(rightChar));

            if (right - left + 1 - maxRepeatLetterCount > k) {
                Character leftChar = str.charAt(left);
                characterFrequencyMap.put(leftChar, characterFrequencyMap.get(leftChar) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
