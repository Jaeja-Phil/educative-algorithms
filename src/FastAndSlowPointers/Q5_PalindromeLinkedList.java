package FastAndSlowPointers;

public class Q5_PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + solution(head)); // true

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + solution(head)); // false
    }

    public static boolean solution(ListNode head) {
        // if head is empty, or only has 1 element, it is palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // set slow and fast pointers to head
        ListNode slow = head, fast = head;
        // proceed with slow & fast
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // flip slow pointer (from slow ~ end of the list)
        // and store the head of flipped half to revert back after comparing for palindrome
        ListNode headSecondHalf = reverse(slow);
        ListNode copySecondHalf = headSecondHalf;

        // start comparing reversed second half and head
        while (head != null && headSecondHalf != null) {
            // if values dont match, break and start prepping for reverting
            if (head.value != headSecondHalf.value) {
                break;
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        // revert secondhalf back to it's normal order
        reverse(copySecondHalf);
        // if either one of head or secondhalf reached null, both halves match, return true
        if (head == null || headSecondHalf == null) {
            return true;
        }
        // or return false cause it didnt match
        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
