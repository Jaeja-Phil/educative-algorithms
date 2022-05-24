package TwoPointers;

import java.util.Arrays;

public class Q8_DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        solution(arr);
        System.out.print(Arrays.toString(arr)); // [0, 0, 1, 1, 2]

        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        solution(arr);
        System.out.print(Arrays.toString(arr)); // [0, 0, 1, 2, 2, 2]
    }

    public static void solution(int[] arr) {
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high;) {
            if (arr[i] == 0) {
                swap(arr, i++, low++);
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, high--);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
