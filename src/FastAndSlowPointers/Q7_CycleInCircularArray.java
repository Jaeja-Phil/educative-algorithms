package FastAndSlowPointers;

public class Q7_CycleInCircularArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 2, -1, 2, 2 })); // true
        System.out.println(solution(new int[] { 2, 2, -1, 2 })); // true
        System.out.println(solution(new int[] { 2, 1, -1, -2 })); // false
    }

    public static boolean solution(int[] arr) {
        for (int i =  0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0;
            int slow = i, fast = i;

            do {
                slow = findIdx(arr, isForward, slow);
                fast = findIdx(arr, isForward, fast);
                if (fast != -1) {
                    fast = findIdx(arr, isForward, fast);
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static int findIdx(int[] arr, boolean isForward, int currentIdx) {
        boolean direction = arr[currentIdx] >= 0;
        if (isForward != direction) {
            return -1;
        }

        int nextIdx = (currentIdx + arr[currentIdx]) % arr.length;
        if (nextIdx < 0) {
            nextIdx += arr.length;
        }

        if (nextIdx == currentIdx) {
            nextIdx = -1;
        }

        return nextIdx;
    }
}
