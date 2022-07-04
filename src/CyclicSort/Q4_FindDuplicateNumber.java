package CyclicSort;

public class Q4_FindDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 4, 4, 3, 2 })); // 4
        System.out.println(solution(new int[] { 2, 1, 3, 3, 5, 4 })); // 3
        System.out.println(solution(new int[] { 2, 4, 1, 4, 4 })); // 4
    }

    public static int solution(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[nums[i] - 1]);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
