package LinkedListDemo;

import LinkedListDemo.LinkedList.ListNode;

public class MiddleLinkedList876 {


    public static void main(String[] args) {
        MiddleLinkedList876 ml = new MiddleLinkedList876();
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
//        linkedList.append(6);
        linkedList.printAfter(ml.middleNode(linkedList.head));

    }
    public LinkedListDemo.LinkedList.ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode curNode = head;
        while (curNode.next != null){
            count++;
            curNode = curNode.next;
        }

        ListNode cur = head;
        int index = 0;
        while (cur.next != null){
            cur = cur.next;
            index++;
            if (index == count / 2){
                break;
            }
        }
        return cur;
    }


}
