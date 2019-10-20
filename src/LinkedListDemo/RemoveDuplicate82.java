package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

public class RemoveDuplicate82 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);
        list.append(4);
        list.append(5);
        RemoveDuplicate82 rd = new RemoveDuplicate82();
        list.printList(rd.deleteDuplicates(list.head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode temp = cur.next;
            while (temp.next != null && temp.data == temp.next.data) {
                temp = temp.next;
            }
            if (cur.next != temp) {
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
