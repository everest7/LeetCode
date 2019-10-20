package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;
public class RemoveNthNodeFromEndList19 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(1);
//        ll.append(2);
//        ll.append(3);
//        ll.append(4);
//        ll.append(5);
        RemoveNthNodeFromEndList19 rn = new RemoveNthNodeFromEndList19();
        ll.printList(rn.removeNthFromEnd(ll.head, 1));
    }

    /**
     * One pass solution.
     * Set two pointers. Move the first point by n steps.
     * Then move two pointers, when the first pointers reaches the end of the list,
     * the second pointer now reaches the position where it is n steps from right boundary.
     * dummy -> 1 -> 2 -> 3 -> 4 -> 5  n = 2;
     *   S           F
     *                    S         F
     *                    S.next = S.next.next
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;


    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int length = 0;
//        ListNode current = head;
//        while (current != null) {
//            length++;
//            current = current.next;
//        }
//        current = head;
//        int cut = 1;
//        while(cut < length - n - 1) {
//            current = current.next;
//            cut++;
//
//        }
//        current.next = current.next.next;
//        return head;
//    }
}
