package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

public class OddEvenList328 {
    public static void main(String[] args) {
        OddEvenList328 ol = new OddEvenList328();
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.printList(ol.oddEvenList(linkedList.head));

    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
//        odd.next = head.next; // Can't use head.next here, because head is also odd, whose next was already been replaced.
        return head;

    }
}
