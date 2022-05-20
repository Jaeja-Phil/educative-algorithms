package TwoPointers;

public class Q3_SquaringASortedArray {
    public static void main(String[] args) {
        int[] result = solution(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " "); // [0, 1, 4, 4, 9]
        System.out.println();

        result = solution(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " "); // [0, 1, 1, 4, 9]
        System.out.println();
    }

    public static int[] solution(int[] arr) {
        int left = 0, right = arr.length - 1, cursor = arr.length - 1;
        int[] ans = new int[arr.length];
        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                ans[cursor--] = arr[left] * arr[left];
                left++;
            } else {
                ans[cursor--] = arr[right] * arr[right];
                right--;
            }
        }

        return ans;
    }
}
