package LinkedListDemo;

import LinkedListDemo.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNodeAtStart(1);
        linkedList.addNodeAtEnd(2);
        linkedList.addNodeAtEnd(3);
        linkedList.addNodeAtEnd(2);
//        linkedList.append(1);
//        linkedList.append(2);
//        linkedList.append(3);
//        linkedList.append(3);
//        linkedList.append(3);

        LinkedListCycle141 lc = new LinkedListCycle141();
        System.out.println(lc.hasCycle(linkedList.head));
    }

    // Using HashSet to check if a node has been added, which means it is cyclic
//    public boolean hasCycle(ListNode head) {
//        ListNode cur = head;
//        Set<ListNode> visited = new HashSet<>();
//        while (cur != null){
//            if (visited.contains(cur)) return true;
//            else {
//                visited.add(cur);
//            }
//            cur = cur.next;
//        }
//        return false;
//
//    }

    // Using Two Pointer
    // The fast pointer goes two nodes at one time, the slow
    // pointer goes one node at one time. If it is a cyclic list, two pointer will meet eventually
    public boolean hasCycle(ListNode head){
        ListNode slower = head;
        ListNode faster = head.next;
        while (faster != null && faster.next != null){
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) return true;
        }
        return false;
    }
}
