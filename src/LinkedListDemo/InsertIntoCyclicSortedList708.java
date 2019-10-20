package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

/**
 * @author Vincent
 * @Date 10/3/19
 */
public class InsertIntoCyclicSortedList708 {
    public static void main(String[] args) {
        
    }
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            ListNode node = new ListNode(insertVal);
            node.next = node;
            return node;
        }
        ListNode prev = head, cur = head.next;
        while (cur != head) {
            if (prev.data <= insertVal && insertVal <= cur.data) break;
            if (prev.data > cur.data && (prev.data <= insertVal || insertVal <= cur.data)) break;
            prev = cur;
            cur = cur.next;
        }

//        ListNode newListNode = new ListNode(insertVal, cur);
//        prev.next = newListNode;
        return head;
    }
}
