package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;
/**
 * @author Vincent
 * @Date 2019-03-13
 */
public class PlusOneLinkedList369 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        PlusOneLinkedList369 po = new PlusOneLinkedList369();
        ll.printList(po.plusOne(ll.head));
    }

    /**
     * Recursion solution
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        int carry = dfs(head);
        if (carry == 1) {
            ListNode dummy = new ListNode(1);
            dummy.next = head;
            return dummy;
        }
        return head;
    }

    public int dfs(ListNode head) {
        if (head == null) return 1;
        int carry = dfs(head.next);
        int sum = head.data + carry;
        head.data = sum % 10;
        return sum / 10;
    }


    /**
     * 
     */
//    public ListNode plusOne(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode left = dummy, right = dummy;
//        while (right.next != null) {
//            if (right.data != 9) {
//                left = right;
//            }
//            right = right.next;
//        }
//        if (right.data != 9) {
//            right.data++;
//        } else {
//            left.data++;
//            left = left.next;
//            while (left != null) {
//                left.data = 0;
//                left = left.next;
//            }
//        }
//        return dummy.data == 0 ? dummy.next : dummy;
//    }
}
