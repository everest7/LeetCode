package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycleII142 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(3);
        ll.append(2);
        ll.append(0);
        ll.append(4);
        ll.head.next.next.next.next = ll.head.next;
        LinkedListCycleII142 lc = new LinkedListCycleII142();
        System.out.println(lc.detectCycle(ll.head).data);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

//    public ListNode detectCycle(ListNode head) {
//        ListNode intersec = getIntersect(head);
//        if (intersec == null) return null;
//        ListNode ptr1 = head;
//        ListNode ptr2 = intersec;
//        while (ptr1 != ptr2) {
//            ptr1 = ptr1.next;
//            ptr2 = ptr2.next;
//        }
//        return ptr1;
//    }
//
//    public ListNode getIntersect(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while (slow != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                return slow;
//            }
//        }
//        return null;
//    }

    /**
     * Using hash set
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param head
     * @return
     */
//    public ListNode detectCycle(ListNode head) {
//        HashSet<ListNode> set = new HashSet<>();
//        ListNode cur = head;
//        while (cur != null) {
//            if (set.contains(cur)) {
//                return cur;
//            }
//            set.add(cur);
//            cur = cur.next;
//        }
//        return null;
//    }

}
