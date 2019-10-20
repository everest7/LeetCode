package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

public class RemoveLinkedListElements203 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(1);
        ll.append(2);
        ll.append(6);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        RemoveLinkedListElements203 rl = new RemoveLinkedListElements203();
        ll.printList(rl.removeElements(ll.head, 6));
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, prev = dummy;
        while (cur != null) {
            if (cur.data == val) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;

    }
}
