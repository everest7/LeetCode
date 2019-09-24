package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;


public class InsertionSort147 {
    public static void main(String[] args) {
        InsertionSort147 is = new InsertionSort147();
        LinkedList linkedList = new LinkedList();
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(1);
//        linkedList.append(2);
//        linkedList.append(5);
        linkedList.printList(is.insertionSortList(linkedList.head));
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        while (cur != null){
            ListNode node = dummy;
            while (node.next != null && node.next.data < cur.data){
                node = node.next;
            }
            ListNode temp = cur.next;
            cur.next = node.next;
            node.next = cur;
            cur = temp;

        }
        return dummy.next;
    }
}
