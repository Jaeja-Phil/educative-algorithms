package CyclicSort;

public class Q6_FindCorruptPair {
    public static void main(String[] args) {
        int[] nums = solution(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]); // [2, 4]

        nums = solution(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]); // [3, 5]

        nums = solution(new int[] { 1, 2, 3, 4, 6, 7, 7 });
        System.out.println(nums[0] + ", " + nums[1]); // [7, 5]
    }

    public static int[] solution(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] {nums[i], i + 1};
            }
        }

        return new int[] {-1, -1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
