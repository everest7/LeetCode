package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

public class PalindromeLinkedList234 {
    public LinkedList.ListNode head;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(2);
        linkedList.append(1);
//        linkedList.append(4);
        PalindromeLinkedList234 pl = new PalindromeLinkedList234();
        System.out.println(pl.isPalindrome(linkedList.head));
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;
        ListNode cur = head;
        ListNode mid = middle(head);
        ListNode after = reverlist(mid.next);
        while (cur != null && after != null){
            if(cur.data != after.data){
                return false;
            }
            after = after.next;
            cur = cur.next;
        }
        return true;

    }

    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverlist(ListNode node){
        ListNode cur = node;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node = prev;
        return node;
    }

}
