package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists23 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//        ll.head = new ListNode(1);
//        ll.append(4);
//        ll.append(5);
        LinkedList ll2 = new LinkedList();
        ll2.head = new ListNode(1);
        ll2.append(3);
        ll2.append(4);
        LinkedList ll3 = new LinkedList();
//        ll3.head = new ListNode(2);
//        ll3.append(6);
        LinkedList ll4 = new LinkedList();
        ll4.head = new ListNode(7);
        ll4.append(8);
        ListNode[] lists = new ListNode[3];
        lists[0] = ll.head;
        lists[1] = ll2.head;
        lists[2] = ll3.head;
        MergekSortedLists23 mk = new MergekSortedLists23();
        ll.printList(mk.mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 ) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        }
        int mid = low + (high - low) / 2;
        ListNode l = sort(lists, low, mid);
        ListNode r = sort(lists, mid + 1, high);
        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (l != null && r != null) {
            if (l.data < r.data) {
                dummy.next = l;
                l = l.next;
            } else {
                dummy.next = r;
                r = r.next;
            }
            dummy = dummy.next;
        }
        if (l != null) {
            dummy.next = l;
        }
        if (r != null) {
            dummy.next = r;
        }
        return head.next;
    }

//    public ListNode merge(ListNode a, ListNode b) {
//        if (a == null) return b;
//        if (b == null) return a;
//        if (a.data < b.data) {
//            a.next = merge(a.next, b);
//            return a;
//        }
//        b.next = merge(a, b.next);
//        return b;
//    }

    /**
     * Using priority queue
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        Comparator<ListNode> comparator = new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.data - o2.data;
//            }
//        };
//        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(comparator);
//        for (int i = 0; i < lists.length; i++) {
//            if (lists[i] != null){
//                pq.add(lists[i]);
//            }
//        }
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        while (!pq.isEmpty()) {
//            ListNode node = pq.poll();
//            cur.next = node;
//            cur = cur.next;
//            if (cur.next != null) {
//                pq.add(cur.next);
//            }
//
//        }
//        return dummy.next;
//
//    }
}
