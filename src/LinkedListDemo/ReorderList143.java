package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

public class ReorderList143 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ReorderList143 rl = new ReorderList143();
        rl.reorderList(ll.head);
        ll.printList(ll.head);
    }
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode reversed = reverse(mid);
        while (cur != null && reversed != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = reversed.next;
            cur.next = reversed;
            reversed.next = temp1;
            cur = temp1;
            reversed = temp2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
