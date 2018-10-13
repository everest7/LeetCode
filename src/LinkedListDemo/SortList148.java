package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

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

    // Using merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = middleNode(head);
        ListNode nextofMiddle = middle.next;
        middle.next = null;
        ListNode low = sortList(head);
        ListNode high = sortList(nextofMiddle);
        ListNode sortedList = mergeParts(low, high);
        return sortedList;

    }
    public ListNode mergeParts(ListNode low, ListNode high){
        ListNode result = null;
        if (low == null){
            return high;
        }
        if (high == null){
            return low;
        }
        if (low.data < high.data){
            result = low;
            result.next = mergeParts(low.next, high);
        } else {
            result = high;
            result.next = mergeParts(low, high.next);
        }
        return result;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
