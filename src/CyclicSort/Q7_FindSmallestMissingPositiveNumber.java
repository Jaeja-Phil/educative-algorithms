package CyclicSort;

public class Q7_FindSmallestMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(solution(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(solution(new int[] { 3, 2, 5, 1 }));
    }

    public static int solution(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
