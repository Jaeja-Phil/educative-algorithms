package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q5_LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + solution("aabccbb"));
        // 3: longest substring with distinct characters is "abc"
        System.out.println("Length of the longest substring: " + solution("abbbb"));
        // 2: longest substring with distinct characters is "ab"
        System.out.println("Length of the longest substring: " + solution("abccde"));
        // 3: longest substring with distinct characters is "abc" & "cde"
    }

    public static int solution(String str) {
        // initialize the left side of the window
        // initialize maxLen to keep track of the max window size (max length of distinct character substring)
        int left = 0, maxLen = 0;
        // create a hashmap to store character indexes
        Map<Character, Integer> charIdxMap = new HashMap<>();
        // initialize and increment right side of the window
        for (int right = 0; right < str.length(); right++) {
            // pull out character from the right side of the window
            Character rightChar = str.charAt(right);
            // if right character is already in charIdxMap, slide left 1 right to the "right"
            // of the last right character's index
            // this way, you can guarantee that there is only one right character within the window
            if (charIdxMap.containsKey(rightChar)) {
                left = Math.max(left, charIdxMap.get(rightChar) + 1);
            }
            // store right index of the window
            charIdxMap.put(rightChar, right);
            // compare and replace maxLen with current window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
