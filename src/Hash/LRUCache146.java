package Hash;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/8/19
 */
public class LRUCache146 {
    public static void main(String[] args) {
        LRUCache146 obj = new LRUCache146(1);
        obj.put(2,1);
        obj.put(3,2);

        int param_1 = obj.get(2);
        System.out.println(param_1);
    }

    int cap;
    Node head, tail;
    Map<Integer, Node> map;
    public LRUCache146(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = null;
        tail = null;

    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        setHead(node);
        return node.val;

    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() >= cap) {
                map.remove(tail.key);
                removeNode(tail);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            setHead(node);
        } else {
            Node node = map.get(key);
            removeNode(node);
            node.val = value;
            setHead(node);
        }
    }

    public void removeNode(Node node) {
        Node prev = node.left;
        Node next = node.right;
        if (node == head) head = next;
        if (node == tail) tail = prev;
        if (prev != null) prev.right = next;
        if (next != null) next.left = prev;
    }

    public void setHead(Node node) {
        node.right = head;
        node.left = null;
        if (head != null) head.left = node;
        head = node;
        if (tail == null) tail = head;
    }

    class Node {
        int key;
        int val;
        Node left;
        Node right;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
            this.left = null;
            this.right = null;
        }
    }
}
