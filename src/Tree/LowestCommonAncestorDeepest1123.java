package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-13
 */
public class LowestCommonAncestorDeepest1123 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        LowestCommonAncestorDeepest1123 ld = new LowestCommonAncestorDeepest1123();
        System.out.println(ld.lcaDeepestLeaves(bt.root).val);

    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        Map<TreeNode, Integer> dep = new HashMap<>();
        int deepest = inorder(root, map, dep);
        List<TreeNode> list = map.get(deepest);
        TreeNode res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            TreeNode first = list.get(i - 1);
            TreeNode second = list.get(i);
            TreeNode temp = lowestCommonAncestor(root, first, second);
            if (dep.get(temp) < dep.get(res)) {
                res = temp;
            }
        }
        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return right == null ? left : right;
        }
    }

    public int inorder(TreeNode root, Map<Integer, List<TreeNode>> map, Map<TreeNode, Integer> dep) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                dep.put(temp, d);
                if (!map.containsKey(d)) {
                    map.put(d, new ArrayList<>());
                }
                map.get(d).add(temp);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            d++;
        }
        return d - 1;
    }
}
