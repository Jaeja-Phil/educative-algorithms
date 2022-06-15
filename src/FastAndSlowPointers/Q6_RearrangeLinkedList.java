package FastAndSlowPointers;

public class Q6_RearrangeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        solution(head);
        while (head != null) {
            System.out.print(head.value + " "); // 2 --> 12 --> 4 --> 10 -->  6 --> 8
            head = head.next;
        }
    }

    public static void solution(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headSecondHalf = reverse(slow);
        ListNode headFirstHalf = head;

        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode tmp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = tmp;

            tmp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = tmp;
        }

        if (headFirstHalf != null) {
            headFirstHalf.next = null;
        }
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
