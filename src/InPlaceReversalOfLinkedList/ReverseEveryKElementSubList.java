package InPlaceReversalOfLinkedList;

public class ReverseEveryKElementSubList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = solution(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    public static ListNode solution(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode curr = head, prev = null;
        while (true) {
            ListNode lastNodeOfPreviousPart = prev;
            ListNode lastNodeOfSubList = curr;
            ListNode next = null;
            for (int i = 0; i < k && curr != null; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = prev;
            } else {
                head = prev;
            }

            lastNodeOfSubList.next = curr;

            if (curr == null) {
                break;
            }

            prev = lastNodeOfSubList;
        }

        return head;
    }
}
