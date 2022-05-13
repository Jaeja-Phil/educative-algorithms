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
        // initialize left side of the window
        int left = 0;
        // create a variable maxLen to keep track of the max length of same letter substring after replacement
        int maxLen = 0;
        // create a variable to keep track of the max repeating letter
        // - this variable does not need to keep track of "current window"'s max repeating letter count
        //   rather, keep the max repeating letter so far because we are only interested in max substring (window) size
        int maxRepeatLetterCount = 0;
        // create a hashmap to store frequency of character occurrences
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        // initialize and start extending window to the right
        for (int right = 0; right < str.length(); right++) {
            // pull out character from the right side of the window
            Character rightChar = str.charAt(right);
            // and record it to characterFrequencyMap
            characterFrequencyMap.put(rightChar, characterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // compare & replace maxRepeateLetterCount
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, characterFrequencyMap.get(rightChar));
            // if curent window size - max repeat letter count is greater than k, all replacements have been made
            // and the window needs to shrink
            if (right - left + 1 - maxRepeatLetterCount > k) {
                Character leftChar = str.charAt(left);
                characterFrequencyMap.put(leftChar, characterFrequencyMap.get(leftChar) - 1);
                left++;
            }
            // compare & replace maxLen with current window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
