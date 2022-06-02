package TwoPointers;

public class Q10_ComparingStringsContainingBackspaces {
    public static void main(String[] args) {
        System.out.println(solution("xy#z", "xzz#")); // true
        System.out.println(solution("xy#z", "xyz#")); // false
        System.out.println(solution("xp#", "xyz##")); // true
        System.out.println(solution("xywrrmp", "xywrrmu#p")); // true
    }

    public static boolean solution(String str1, String str2) {
        int idx1 = str1.length() - 1, idx2 = str2.length() - 1;
        while (idx1 >= 0 || idx2 >= 0) {
            int str1NextValidIdx = getNextValidCharIdx(str1, idx1);
            int str2NextValidIdx = getNextValidCharIdx(str2, idx2);

            if (str1NextValidIdx < 0 && str2NextValidIdx < 0) {
                return true;
            }

            if (str1NextValidIdx < 0 || str2NextValidIdx < 0) {
                return false;
            }

            if (str1.charAt(str1NextValidIdx) != str2.charAt(str2NextValidIdx)) {
                return false;
            }

            idx1 = str1NextValidIdx - 1;
            idx2 = str2NextValidIdx - 1;
        }

        return true;
    }

    private static int getNextValidCharIdx(String str, int idx) {
        int backSpaceCount = 0;
        while (idx >= 0) {
            if (str.charAt(idx) == '#') {
                backSpaceCount++;
            } else if (backSpaceCount > 0) {
                backSpaceCount--;
            } else {
                break;
            }

            idx--;
        }

        return idx;
    }
}
