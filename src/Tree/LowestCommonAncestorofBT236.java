package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.*;

public class LowestCommonAncestorofBT236 {
    public static void main(String[] args) {
        LowestCommonAncestorofBT236 lca = new LowestCommonAncestorofBT236();
        BinaryTree bt = new BinaryTree(6);
        bt.root.left = new BinaryTree.TreeNode(2);
        bt.root.left.left = new BinaryTree.TreeNode(0);
        bt.root.left.right = new BinaryTree.TreeNode(4);
        bt.root.left.right.left = new BinaryTree.TreeNode(3);
        bt.root.left.right.right = new BinaryTree.TreeNode(5);
        bt.root.right = new BinaryTree.TreeNode(8);
        bt.root.right.left = new BinaryTree.TreeNode(7);
        bt.root.right.right = new BinaryTree.TreeNode(9);
        BinaryTree.TreeNode p = new BinaryTree.TreeNode(2);
        BinaryTree.TreeNode q = new BinaryTree.TreeNode(8);
        System.out.println(lca.lowestCommonAncestor(bt.root, bt.root.left, bt.root.right).val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        stack.push(root);
        while (!map.containsKey(p) || !map.containsKey(q)){
            TreeNode node = stack.pop();
            if (node.left != null){
                stack.push(node.left);
                map.put(node.left, node);
            }
            if (node.right != null){
                stack.push(node.right);
                map.put(node.right, node);
            }
        }
        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null){
            ancestor.add(map.get(p));
        }
        while (!ancestor.contains(q)){
            q = map.get(q);
        }
        return q;



    }

    /**
     * Recursive approach
     * @param root
     * @param p
     * @param q
     * @return
     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null){
//            return null; // Base case
//        }
//        if (root.val == p.val || root.val == q.val){
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null){
//            return root;
//        } else {
//            return left == null ? right : left;
//        }
//
//    }
}
