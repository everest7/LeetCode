package Tree;
import Tree.BinaryTree.TreeNode;
/**
 * @author Vincent
 * @Date 2019-07-12
 */
public class ConvertBSTtoGreaterTree538 {
    public static void main(String[] args) {

    }

    /**
     *
     * Using Traversal similar to inorder traversal, but we traverse the right child first
     * Use a number to track all keys greater than current node.
     * root.val += sum
     * sum = root.val
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int[] sum = new int[1];
        reverseOrder(root, sum);
        return root;
    }

    public void reverseOrder(TreeNode root, int[] sum) {
        if (root == null) return;
        reverseOrder(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;
        reverseOrder(root.left, sum);
    }
}
