package LinkedListDemo;

import LinkedListDemo.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectOfTwoList160 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(4);
        linkedList.append(1);
        linkedList.append(2);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.append(8);
        linkedList2.append(9);
        LinkedList list3 = new LinkedList();
//        list3.append(100);
//        list3.append(200);
//        list3.append(300);
        linkedList.addNodeAtLast(list3.head);
        linkedList2.addNodeAtLast(list3.head);
        IntersectOfTwoList160 it = new IntersectOfTwoList160();
        linkedList2.printAfter(it.getIntersectionNode(linkedList.head, linkedList2.head));
    }
    //

    /**
     * Two Pointer
     * pointerA = pointerA.next == null ? headB : pointerA.next;
     * pointerB = pointerB.next == null ? headA : pointerB.next;
     * This is incorrect since pA and pB will never become null pointer and since there are no same element, the loop will
     * become a infinite one.
     *
     * pointerA = pointerA == null ? headB : pointerA.next;
     * pointerB = pointerB == null ? headA : pointerB.next;
     * Using the transition above, pA and pB will both be null after list1 and list2 exactly once. 3 + 2 = 2 + 3
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode pointerA = headA, pointerB = headB;
        while (pointerA != pointerB){
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }
        return pointerA;
    }


    // Brute Force
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        while (headA != null){
//            ListNode cur = headB;
//            while (cur != null){
//                if (headA == cur){
//                    return cur;
//                }
//                cur = cur.next;
//            }
//            headA = headA.next;
//        }
//        return null;
//    }

    // HashTable
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//        Set<ListNode> set = new HashSet<>();
//        while (headA != null){
//            set.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null){
//            if (set.contains(headB)){
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }
}
