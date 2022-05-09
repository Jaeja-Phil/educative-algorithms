package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q3_LongestSubstringWithMaximumKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + solution("araaci", 2));
        // 4, Longest substring with no more than 2 distinct characters is 'araa'
        System.out.println("Length of the longest substring: " + solution("araaci", 1));
        // 2, Longest substring with no more than 1 distinct characters is 'aa'
        System.out.println("Length of the longest substring: " + solution("cbbebi", 3));
        // 5, Longest substring with no more than 3 distinct characters is 'cbbeb'
    }

    public static int solution(String str, int k) {
        // initialize the left side of the window
        // initialize maxLen to keep track of the max window size which
        // - length of window with 'k' distinct characters
        int left = 0, maxLen = 0;
        // create a hashmap to store character frequencies
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // initialize and increment right side of the window
        for (int right = 0; right < str.length(); right++) {
            // pull out character from the right side of the window and add it to the charFrequencyMap
            Character rightChar = str.charAt(right);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // if size of the charFrequencyMap (number of distinct characters) exceed k,
            // shrink the window size until charFrequencyMap's size is equal or less than k
            while(charFrequencyMap.size() > k) {
                char leftChar = str.charAt(left);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar); // shrinking the size of charFrequencyMap
                }
                left++;
            }
            // finally, compare & replace maxLen with current window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
