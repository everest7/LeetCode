package LinkedListDemo;
import LinkedListDemo.LinkedList.ListNode;

import java.util.Stack;

public class AddTwoNumII445 {
    public static void main(String[] args) {
        LinkedList lklist1 = new LinkedList();
        LinkedList lklist2 = new LinkedList();
        lklist1.append(7);
        lklist1.append(2);
        lklist1.append(4);
        lklist1.append(3);
        lklist2.append(5);
        lklist2.append(6);
        lklist2.append(4);
        AddTwoNumII445 ad = new AddTwoNumII445();
        LinkedList new_list = new LinkedList();
        new_list.printList(ad.addTwoNumbers(lklist1.head,lklist2.head));

    }
    public LinkedListDemo.LinkedList.ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.data);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.data);
            l2 = l2.next;
        }
        LinkedList newlist = new LinkedList();
        int sum = 0;
        LinkedListDemo.LinkedList.ListNode listnode = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()) sum += stack1.pop();
            if(!stack2.isEmpty()) sum += stack2.pop();
            listnode.data = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = listnode;
            listnode = head;
            sum /= 10;

        }
        return listnode.data == 0 ? listnode.next : listnode;

    }
}
