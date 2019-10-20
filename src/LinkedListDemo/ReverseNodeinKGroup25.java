package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;
/**
 * @author Vincent
 * @Date 2019-07-15
 */
public class ReverseNodeinKGroup25 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ReverseNodeinKGroup25 rs = new ReverseNodeinKGroup25();
        ll.printList(rs.reverseKGroup(ll.head, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy, subHead = head, subTail = head;
        while (subHead != null) {
            int i = k;
            while (i - 1 > 0) {
                subTail = subTail.next;
                if (subTail == null) { // processing is all done, return result
                    return dummy.next;
                }
                i--;
            }
            ListNode nextHead = subTail.next;
            subTail.next = null;
            tail.next = reverse(subHead);
            tail = subHead;
            tail.next = nextHead;
            subHead = nextHead;
            subTail = nextHead;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || k == 1) return head;
//        ListNode dummy = new ListNode(-1);
//        ListNode prev = dummy, cur = head;
//        dummy.next = head;
//        for (int i = 1; cur != null; i++) {
//            if (i % k == 0) {
//                prev = reverse(prev, cur.next);
//                cur = prev.next;
//            } else {
//                cur = cur.next;
//            }
//        }
//        return dummy.next;
//
//    }
//
//    public ListNode reverse(ListNode begin, ListNode end) {
//        ListNode cur = begin.next, first = cur;
//        ListNode prev = begin;
//        while (cur != end) {
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        begin.next = prev;
//        first.next = cur;
//        return first;
//    }

}
