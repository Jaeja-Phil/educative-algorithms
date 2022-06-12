package FastAndSlowPointers;

public class Q3_HappyNumber {
    public static void main(String[] args) {
        System.out.println(solution(23)); // true
        System.out.println(solution(12)); // false
    }

    public static boolean solution(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
