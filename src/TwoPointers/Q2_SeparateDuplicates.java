package TwoPointers;

public class Q2_SeparateDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(solution(arr)); // 4, [2, 3, 6, 9]

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(solution(arr)); // 2, [2, 11]
    }

    public static int solution(int[] arr) {
        int nextNonDuplicate = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }
}
