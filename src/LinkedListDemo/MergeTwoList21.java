package LinkedListDemo;

import LinkedListDemo.LinkedList.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;


public class MergeTwoList21 {
    public static void main(String[] args) {
        LinkedList lklist1 = new LinkedList();
        LinkedList lklist2 = new LinkedList();
        lklist1.append(1);
        lklist1.append(3);
//        lklist1.append(4);
        lklist2.append(2);
//        lklist2.append(3);
        lklist2.append(4);
        MergeTwoList21 mt = new MergeTwoList21();
        LinkedList newlist = new LinkedList();
        newlist.printList(mt.mergeTwoLists(lklist1.head,lklist2.head));

    }

    // Compare two LinkedList, using curNode to connect all the ListNode together
    // in a ascending order.
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        ListNode cur = new ListNode(0);
//        ListNode head = cur;
//        while (l1 != null && l2 != null){
//            if (l1.data < l2.data){
//                cur.next = l1;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = l1 == null ? l2 : l1;
//        return head.next;
//    }

    // Recursive Way
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.data < l2.data){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        Queue<Integer> queue1 = new PriorityQueue<Integer>();
//        Queue<Integer> queue2 = new PriorityQueue<Integer>();
//        while (l1 != null){
//            queue1.add(l1.data);
//            l1 = l1.next;
//        }
//        while (l2 != null){
//            queue2.add(l2.data);
//            l2 = l2.next;
//        }
//        LinkedList linklist = new LinkedList();
//        while (!queue1.isEmpty() || !queue2.isEmpty()){
//            if (queue1.peek() >= queue2.peek()){
//                linklist.append(queue2.poll());
//            } else {
//                linklist.append(queue1.poll());
//            }
//        }
//        return linklist.head;
//
//    }
}
