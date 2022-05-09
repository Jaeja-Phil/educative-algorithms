package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q4_FruitsIntoBaskets {
    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " + solution(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        // 3, ['C', 'A', 'C'] will return maximum number of fruits in both baskets
        System.out.println("Maximum number of fruits: " + solution(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
        // 5, ['B', 'C', 'B', 'B', 'C'] will return maximum number of fruits in both baskets
    }

    public static int solution(char[] arr) {
        // initialize the left side of the window
        // initialize maxFruits to keep track of the max window size (max number of fruits)
        int left = 0, maxFruits = 0;
        // create a hashmap to store character frequencies
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        // initialize and increment right side of the window
        for (int right = 0; right < arr.length; right++) {
            // pull out fruit from the right side of the window and add it to the fruitFrequencyMap
            char rightFruit = arr[right];
            fruitFrequencyMap.put(rightFruit, fruitFrequencyMap.getOrDefault(rightFruit, 0) + 1);
            // if size of the charFrequencyMap (number of distinct characters) exceed 2,
            // shrink the window size until fruitFrequencyMap's size is equal to 2
            while (fruitFrequencyMap.size() > 2) {
                char leftFruit = arr[left];
                fruitFrequencyMap.put(leftFruit, fruitFrequencyMap.get(leftFruit) - 1);
                if (fruitFrequencyMap.get(leftFruit) == 0) {
                    fruitFrequencyMap.remove(leftFruit);
                }
                left++;
            }
            // finally, compare & replace maxFruits with current window size
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
