package Tree;
import Tree.BinaryTree.TreeNode;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-20
 */
public class LargestBSTSubtree333 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(10);
        bt.root.left = new BinaryTree.TreeNode(5);
        bt.root.left.left = new BinaryTree.TreeNode(1);
        bt.root.left.right = new BinaryTree.TreeNode(8);
        bt.root.right = new BinaryTree.TreeNode(15);
        bt.root.right.right = new BinaryTree.TreeNode(9);
        LargestBSTSubtree333 lb = new LargestBSTSubtree333();
        System.out.println(lb.largestBSTSubtree(bt.root));
    }

    /**
     * Create a new wrapper for each node, the wrapper contains information about the size,
     * the lower and upper range of current node,
     *
     * @param root
     * @return
     */
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return max;
    }

    // Return a wrapper for a node.
    public Wrapper traverse (TreeNode root) {
        if (root == null) {
            return new Wrapper(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Wrapper left = traverse(root.left);
        Wrapper right = traverse(root.right);
        // conditions that violates BST property
        if (left.size == -1 || right.size == -1 || left.upper >= root.val || right.lower <= root.val) {
            return new Wrapper(-1, 0, 0);
        }
        int size = left.size + right.size + 1; // size for current node
        max = Math.max(max, size); // update the maximum size of BST
        return new Wrapper(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }

    class Wrapper {
        int size;
        int lower;
        int upper;

        public Wrapper (int size, int lower, int upper){
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    /**
     * Naive approach, O(n^2)
     */
//    public int largestBSTSubtree(TreeNode root) {
//        if (root == null) return 0;
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
//        int max = 0;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        while (!q.isEmpty()) {
//            TreeNode tmp = q.poll();
//            if (validate(tmp) && numNodes(tmp) > max) {
//                max = numNodes(tmp);
//            }
//            if (tmp.left != null) {
//                q.offer(tmp.left);
//            }
//            if (tmp.right != null) {
//                q.offer(tmp.right);
//            }
//        }
//        return max;
//
//    }
//
//    public int numNodes(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        int num = 0;
//        q.offer(root);
//        while (!q.isEmpty()) {
//            TreeNode tmp = q.poll();
//            num++;
//            if (tmp.left != null) q.offer(tmp.left);
//            if (tmp.right != null) q.offer(tmp.right);
//        }
//        return num;
//    }
//
//    public boolean validate(TreeNode root) {
//        return validHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    public boolean validHelper(TreeNode root, int min, int max) {
//        if (root == null) return true;
//        if (root.val <= min || root.val >= max) return false;
//        return validHelper(root.left, min, root.val) && validHelper(root.right, root.val, max);
//    }
}
