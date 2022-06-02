package TwoPointers;

public class Q11_MinimumWindowSort {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 })); // 5
        System.out.println(solution(new int[] { 1, 3, 2, 0, -1, 7, 10 })); // 5
        System.out.println(solution(new int[] { 1, 2, 3 })); // 0
        System.out.println(solution(new int[] { 3, 2, 1 })); // 3
    }

    public static int solution(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < arr.length - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == arr.length - 1){
            return 0;
        }

        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        int subArrayMax = Integer.MIN_VALUE, subArrayMin = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            subArrayMax = Math.max(subArrayMax, arr[i]);
            subArrayMin = Math.min(subArrayMin, arr[i]);
        }

        while (left > 0 && arr[left - 1] > subArrayMin) {
            left--;
        }
        while(right < arr.length - 1 && arr[right + 1] < subArrayMax) {
            right++;
        }

        return right - left + 1;
    }
}
