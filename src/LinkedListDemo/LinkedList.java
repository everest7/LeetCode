package LinkedListDemo;

public class LinkedList {
    public ListNode head;

    public static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insert(ListNode node, int data){
        if (node == null){
            System.out.println("Current node cannot be null");
            return;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    public void append(int data){
        ListNode newNode = new ListNode(data);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode curNode = head;
        while (curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
        return;

    }

    public void printList(ListNode node){
        ListNode curNode = node;
        while (curNode != null){
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
    }
    public void printAfter(ListNode node){
        ListNode curNode = head;
        while (curNode != node){
            curNode = curNode.next;
        }
        while (curNode != null){
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
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

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        System.out.println("Printing LinkedListDemo:");
        linkedList.printList(linkedList.head);
        System.out.println("Printing after node:");
        linkedList.printAfter(linkedList.head.next.next);
        System.out.println("After reversing: ");
        linkedList.reverseList(linkedList.head);
        linkedList.printList(linkedList.head);
    }
}
