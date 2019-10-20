package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-06
 */
public class DeleteNodesAndReturnForest1110 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new BinaryTree.TreeNode(2);
        bt.root.left.left = new BinaryTree.TreeNode(4);
        bt.root.left.right = new BinaryTree.TreeNode(3);
//        bt.root.right = new BinaryTree.TreeNode(3);
//        bt.root.right.left = new BinaryTree.TreeNode(6);
//        bt.root.right.right = new BinaryTree.TreeNode(7);
//        bt.root.left = new BinaryTree.TreeNode(2);
//        bt.root.left.left = new BinaryTree.TreeNode(4);
//        bt.root.left.right = new BinaryTree.TreeNode(5);
//        bt.root.right = new BinaryTree.TreeNode(3);
//        bt.root.right.left = new BinaryTree.TreeNode(6);
//        bt.root.right.right = new BinaryTree.TreeNode(7);
        DeleteNodesAndReturnForest1110 dl = new DeleteNodesAndReturnForest1110();
        List<TreeNode> res = dl.delNodes(bt.root, new int[] {3, 2});
        for (TreeNode node : res) {
            bt.levelorder(node);
            System.out.println();
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<TreeNode> nodes = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(root, parent);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
            if (set.contains(temp.val)) {
                if (temp.left != null) parent.remove(temp.left);
                if (temp.right != null) parent.remove(temp.right);
                TreeNode par = parent.get(temp);
                if (par != null && par.left == temp) {
                    par.left = null;
                } else if (par != null && par.right == temp){
                    par.right = null;
                }
            } else {
                TreeNode par = null;
                while (parent.containsKey(temp)) {
                    temp = parent.get(temp);
                }
                if (!nodes.contains(temp)) {
                    res.add(temp);
                }
                nodes.add(temp);
            }
        }
        return res;
    }


    public void findParent(TreeNode node, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        if (node.left != null) parent.put(node.left, node);
        if (node.right != null) parent.put(node.right, node);
        findParent(node.left, parent);
        findParent(node.right, parent);
    }
}
