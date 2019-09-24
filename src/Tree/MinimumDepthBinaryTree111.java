package Tree;
import Tree.BinaryTree.TreeNode;
public class MinimumDepthBinaryTree111 {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(3);
        bt.root.left = new TreeNode(9);
        bt.root.right = new TreeNode(20);
        bt.root.left.left = new TreeNode(15);
        bt.root.left.right = new TreeNode(7);
        MinimumDepthBinaryTree111 md = new MinimumDepthBinaryTree111();
        System.out.println(md.minDepth(bt.root));

    }
    public int minDepth(TreeNode root) {
        if (root == null)return 0;
        if (root.left == null && root.right == null){
            return 1;
        }
        if (root.left == null){

            return minDepth(root.right) + 1;
        }
        if (root.right == null){

            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
