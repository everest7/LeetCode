package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(2);
        ll.append(4);
        ll.append(3);
        LinkedList ll2 = new LinkedList();
        ll2.head = new ListNode(5);
        ll2.append(6);
        ll2.append(4);
        AddTwoNumbers2 at = new AddTwoNumbers2();
        ll.printList(at.addTwoNumbers(ll.head, ll2.head));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.data;
            int n2 = l2 == null ? 0 : l2.data;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) cur.next = new ListNode(1);
        return dummy.next;
    }
}
