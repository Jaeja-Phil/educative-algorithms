package FastAndSlowPointers;

public class Q4_MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + solution(head).value); // 3

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + solution(head).value); // 4

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + solution(head).value); // 4
    }

    public static ListNode solution(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
