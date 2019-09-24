package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

/**
 * @Author Vincent
 * @Date
 * @Review 2019-3-7
 */
public class SortList148 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(5);
        linkedList.append(3);

        SortList148 sl = new SortList148();
        sl.sortList(linkedList.head);
        linkedList.printList(linkedList.head);

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextToMiddle = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(nextToMiddle));
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return dummy.next;
    }

    // Using merge sort
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        ListNode middle = middleNode(head);
//        ListNode nextofMiddle = middle.next;
//        middle.next = null;
//        ListNode low = sortList(head);
//        ListNode high = sortList(nextofMiddle);
//        ListNode sortedList = mergeParts(low, high);
//        return sortedList;
//
//    }
//    public ListNode mergeParts(ListNode low, ListNode high){
//        ListNode result = null;
//        if (low == null){
//            return high;
//        }
//        if (high == null){
//            return low;
//        }
//        if (low.data < high.data){
//            result = low;
//            result.next = mergeParts(low.next, high);
//        } else {
//            result = high;
//            result.next = mergeParts(low, high.next);
//        }
//        return result;
//    }
//    public ListNode middleNode(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast.next != null && fast.next.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }

}
