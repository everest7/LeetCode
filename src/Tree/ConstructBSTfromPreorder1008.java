package Tree;
import Tree.BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

/**
 * @author Vincent
 * @Date 2019-06-08
 */
public class ConstructBSTfromPreorder1008 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
//        bt.root = new BinaryTree.TreeNode(8);
//        bt.root.left = new TreeNode(5);
//        bt.root.right = new TreeNode(10);
//        bt.root.right.right = new TreeNode(12);
//        bt.root.left.left = new TreeNode(1);
//        bt.root.left.right = new TreeNode(1);
        ConstructBSTfromPreorder1008 cs = new ConstructBSTfromPreorder1008();
//        int[] nums = new int[] {4, 2};
        int[] nums = new int[] {3,1,2};
        bt.inorder(cs.bstFromPreorder(nums));
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return construct(preorder, 0, preorder.length - 1);
    }

    public TreeNode construct(int[] nums, int begin, int end) {
        if (begin > end) return null;
        TreeNode root = new TreeNode(nums[begin]);
        int pos = begin;
        boolean found = false;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > nums[begin]) {
                pos = i;
                found = true;
                break;
            }
        }
        if (!found) {
            root.left = construct(nums, begin + 1, end);
        } else {

            root.left = construct(nums, begin + 1, pos - 1);
            root.right = construct(nums, pos, end);
        }
        return root;
    }
}
