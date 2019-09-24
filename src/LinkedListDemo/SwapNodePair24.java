package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

public class SwapNodePair24 {
    public static void main(String[] args) {
        SwapNodePair24 sn = new SwapNodePair24();
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.printAfter(list.head);
        System.out.println("After swapping");
        list.printList(sn.swapPairs(list.head));

    }
    // Recursion
    // Traverse through the list, swap the last pair of node, connecting it with the rest node
    // by returning its first node
    public ListNode swapPairs(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
    }
//    //
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode cur = dummy;
//        while (cur.next != null && cur.next.next != null){
//            ListNode temp = cur.next.next;
//            cur.next.next = temp.next;
//            temp.next = cur.next;
//            cur.next = temp;
//            cur = cur.next.next;
//        }
//        return dummy.next;
//    }
}
