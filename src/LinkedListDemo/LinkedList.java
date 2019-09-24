package LinkedListDemo;

public class LinkedList {
    public ListNode head;
    public ListNode tail;
    public int size = 0;

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }


    }

    public void addNodeAtStart(int data) {
        ListNode n = new ListNode(data);
        if (size == 0) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            ListNode temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
        size++;
    }

    public void addNodeAtEnd(int data) {
        if (size == 0) {
            addNodeAtStart(data);
        } else {
            ListNode n = new ListNode(data);
            tail.next = n;
            tail = n;
            tail.next = head;
            size++;
        }
    }

    public void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insert(ListNode node, int data) {
        if (node == null) {
            System.out.println("Current node cannot be null");
            return;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    public void addNodeAtLast(ListNode node) {
        if (head == null) {
            head = node;
        } else {

            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    public void append(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
//        newNode.next = head;
        return;

    }

    public void printList(ListNode node) {
//        if (node == head) {
//            ListNode curNode = head;
//            while (curNode != null) {
//                System.out.print(curNode.data + " ");
//                curNode = curNode.next;
//            }
//        }
        ListNode curNode = node;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
    }

    public void printAfter(ListNode node) {

        ListNode curNode = head;
        while (curNode != node) {
            curNode = curNode.next;
        }
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
    }

    public ListNode reverseList(ListNode node) {
        ListNode curNode = node;
        ListNode next, prev = null;
        while (curNode != null) {
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
