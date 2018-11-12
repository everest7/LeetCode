package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftValue513 {
    public static void main(String[] args) {
        FindBottomLeftValue513 fb = new FindBottomLeftValue513();
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.left.right.left = new TreeNode(7);
        bt.root.right.right = new TreeNode(6);
        System.out.println(fb.findBottomLeftValue(bt.root));
    }

    // Using BFS to iterate the tree from right to left
    // The last element polled is the answer we're looking for
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.right != null){
                ((LinkedList<TreeNode>) queue).add(root.right);
            }
            if (root.left != null){
                ((LinkedList<TreeNode>) queue).add(root.left);
            }
        }
        return root.val;
    }

    // Using Level Order Traversal
    // We replace the result with the first element in each row
    // The element at the last row is the answer we're looking for
//    public int findBottomLeftValue(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        int res = 0;
//        TreeNode cur = root;
//        ((LinkedList<TreeNode>) queue).add(cur);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            List<Integer> inner = new ArrayList<>();
//            for (int i = 0; i < size; i++){
//                cur = queue.poll();
//                inner.add(cur.val);
//                if (cur.left != null){
//                    ((LinkedList<TreeNode>) queue).add(cur.left);
//                }
//                if (cur.right != null){
//                    ((LinkedList<TreeNode>) queue).add(cur.right);
//                }
//            }
//            res = inner.get(0);
//        }
//        return res;
//
//    }
}
