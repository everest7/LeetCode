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
        rl.reverseList(linkedList.head);
        System.out.println("After reversing: ");
        linkedList.printList(linkedList.head);

    }
    public ListNode reverseList(ListNode node) {
        ListNode curNode = node;
        ListNode next, prev = null;
        while (curNode != null){
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }
        head = prev;
        return head;
    }
}
