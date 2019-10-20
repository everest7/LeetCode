package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vincent
 * @Date 9/20/19
 */
public class ConstructDoublyLinkedListFromBST426 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(4);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(5);
        bt.root.left.right= new TreeNode(3);
        bt.root.left.left = new TreeNode(1);
        ConstructDoublyLinkedListFromBST426 cd = new ConstructDoublyLinkedListFromBST426();
        TreeNode cur = cd.treeToDoublyList(bt.root);
        Set<Integer> set = new HashSet<>();
        while (cur != null) {
            System.out.println(cur.val);
            set.add(cur.val);
            cur = cur.right;
            if (set.contains(cur.val)) break;

        }
    }
//
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode head = root;
        TreeNode tail = root;

        TreeNode leftHead = treeToDoublyList(root.right);
        TreeNode rightHead = treeToDoublyList(root.left);

        if (leftHead != null) {
            TreeNode leftTail = leftHead.left;
            head = leftHead;
            leftTail.right = root;
            root.left = leftTail;
        }
        if (rightHead != null) {
            TreeNode rightTail = rightHead.left;
            tail = rightTail;
            root.right = rightHead;
            rightHead.left = root;
        }

        head.left = tail;
        tail.right = head;
        return head;
    }

//    TreeNode head = null, prev = null;
//    public TreeNode treeToDoublyList(TreeNode root) {
//        if (root == null) return null;
//        inorder(root);
//        head.left = prev;
//        prev.right = head;
//        return head;
//    }
//
//    public void inorder(TreeNode root) {
//        if (root == null) return ;
//        inorder(root.left);
//        if (head == null) {
//            head = root;
//            prev = root;
//        } else {
//            root.left = prev;
//            prev.right = root;
//            prev = root;
//        }
//        inorder(root.right);
//    }

//    TreeNode tail = null, next = null;
//    public TreeNode treeToDoublyList(TreeNode root) {
//        if (root == null) return null;
//        inorder(root);
//        next.left = tail;
//        tail.right = next;
//        return tail;
//    }
//
//    public void inorder(TreeNode root) {
//        if (root == null) return ;
//        inorder(root.right);
//        if (tail == null) {
//            tail = root;
//            next = root;
//        } else {
//            root.right = next;
//            next.left = root;
//            next = root;
////            if (next.right != null) {
////                next.right.left = root;
////            }
//        }
//        inorder(root.right);
//    }

//    TreeNode head = null, prev = null;
//    public TreeNode treeToDoublyList(TreeNode root) {
//        if (root == null) return null;
//        inorder(root);
//        head.left = prev;
//        prev.right = head;
//        return head;
//    }
//
//    public void inorder(TreeNode root) {
//        if (root == null) return ;
//        inorder(root.right);
//        if (head == null) {
//            head = root;
//            prev = root;
//        } else {
//            root.left = null;
//            root.right = null;
//            root.left = prev;
//            prev.right = root;
//            prev = root;
//        }
//        inorder(root.left);
//    }


}
