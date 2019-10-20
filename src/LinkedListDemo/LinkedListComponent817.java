package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vincent
 * @Date 2019-03-13
 */
public class LinkedListComponent817 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(0);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        LinkedListComponent817 lc = new LinkedListComponent817();
        System.out.println(lc.numComponents(ll.head, new int[]{0,1,3}));
    }

    public int numComponents(ListNode head, int[] G) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.data)) {
                while (cur.next != null && set.contains(cur.data)) {
                    cur = cur.next;
                }
                res++;
            }
            cur = cur.next;
        }
        return res;
    }
}
