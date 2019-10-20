package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

public class ReverseLinkedListII92 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ReverseLinkedListII92 rl = new ReverseLinkedListII92();
        ll.printList(rl.reverseBetween(ll.head, 2, 4));
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode end = start.next;
        for (int i = m; i < n; i++) {
            start.next = end.next;
            end.next = pre.next;
            pre.next = end;
            end = start.next;
        }
        return dummy.next;
    }
}
