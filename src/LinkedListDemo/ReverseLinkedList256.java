package LinkedListDemo;

import LinkedListDemo.LinkedList.ListNode;

public class ReverseLinkedList256 {
    public LinkedList.ListNode head;

    public static void main(String[] args) {
        ReverseLinkedList256 rl = new ReverseLinkedList256();
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        System.out.println("Before reversing:");
        linkedList.printList(linkedList.head);

        System.out.println("After reversing: ");
        linkedList.printList(rl.reverseListRecur(linkedList.head));
//        linkedList.printList(rl.reverseList(linkedList.head, linkedList.head.next.next.next));

    }

    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
//    public ListNode reverseList(ListNode node) {
//        ListNode curNode = node;
//        ListNode next, prev = null;1
//        while (curNode != null){
//            next = curNode.next;
//            curNode.next = prev;
//            prev = curNode;
//            curNode = next;
//        }
//        return prev;
//    }
    public ListNode reverseList(ListNode node, ListNode end) {
        ListNode curNode = node;
        ListNode next, prev = null;
        while (curNode != null){
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
            if (curNode == end) {
                curNode.next = null;
                break;
            }
        }
        return prev;
    }
}
