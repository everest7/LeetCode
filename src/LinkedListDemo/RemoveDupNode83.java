package LinkedListDemo;

import LinkedListDemo.LinkedList.ListNode;

public class RemoveDupNode83 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(2);
        list.append(4);
        list.append(4);
        list.append(4);
        RemoveDupNode83 rp = new RemoveDupNode83();
        list.printAfter(rp.deleteDuplicates(list.head));
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur.next != null && cur != null){
            if (cur.data == cur.next.data){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;

    }
}
