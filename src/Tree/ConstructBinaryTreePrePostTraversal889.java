package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-03-18
 */
public class ConstructBinaryTreePrePostTraversal889 {
    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        ConstructBinaryTreePrePostTraversal889 cb = new ConstructBinaryTreePrePostTraversal889();
        BinaryTree bt = new BinaryTree();
        bt.inorder(cb.constructFromPrePost(pre, post));
    }

    /**
     * pre  [1,2,4,5,3,6,7]
     * post [4,5,2,6,7,3,1]
     * A preorder traversal is:
     * (root node) (preorder of left branch) (preorder of right branch)
     * While a postorder traversal is:
     * (postorder of left branch) (postorder of right branch) (root node)
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length < 1) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        int index = 0;
        for (int i = 0; i < post.length; i++) {
            if (post[i] == pre[1]) {
                index = i + 1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(post, 0, index));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(post, index, post.length));
        return root;
    }
}
