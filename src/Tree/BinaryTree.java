package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int item){
            val = item;
            left = null;
            right = null;
        }

    }
    public void inorder(TreeNode temp){
        if (temp == null){
            return;
        }
        inorder(temp.left);
        System.out.print(temp.val + " ");
        inorder(temp.right);
    }

    // Inorder without using recursion
    public static void inorder_nonrec(TreeNode temp){
        if (temp == null) return;
        TreeNode cur = temp;
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(temp);
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;

        }
    }

    public void preorder(TreeNode temp){
        if (temp == null){
            return;
        }
        System.out.print(temp.val + " ");
        preorder(temp.left);
        preorder(temp.right);
    }

    public void postorder(TreeNode temp){
        if (temp == null){
            return;
        }
        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.val);
    }

    public void levelorder(TreeNode temp){
        if (temp == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = temp;
        ((LinkedList<TreeNode>) queue).add(cur);
        while (!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null){

                ((LinkedList<TreeNode>) queue).add(cur.left);
            }
            if (cur.right != null){

                ((LinkedList<TreeNode>) queue).add(cur.right);
            }

        }
    }

    public void insert(TreeNode temp, int key){
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(temp);
        while (!queue.isEmpty()){
            temp = queue.poll();
            if (temp.left == null){
                temp.left = new TreeNode(key);
                break;
            } else{
                ((LinkedList<TreeNode>) queue).add(temp.left);
            }
            if (temp.right == null){
                temp.right = new TreeNode(key);
                break;
            } else {
                ((LinkedList<TreeNode>) queue).add(temp.right);
            }
        }
    }

    TreeNode root;
    public BinaryTree(){
        root = null;
    }

    public BinaryTree(int item){
        root = new TreeNode(item);

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(10);
        bt.root.left = new TreeNode(11);
        bt.root.left.left = new TreeNode(7);
        bt.root.right = new TreeNode(9);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(8);
        bt.insert(bt.root,6);
//        inorder(bt.root);
        System.out.println();
//        inorder_nonrec(bt.root);
        bt.levelorder(bt.root);
//        preorder(bt.root);

//        System.out.println(bt.root.left.key);
//        System.out.println(bt.root.right.key);

    }
}
