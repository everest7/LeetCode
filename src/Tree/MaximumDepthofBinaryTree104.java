package Tree;
import Tree.BinaryTree.TreeNode;

public class MaximumDepthofBinaryTree104 {
    public static void inorder(TreeNode temp){
        if (temp == null){
            return;
        }
        inorder(temp.left);
        System.out.print(temp.val + " ");
        inorder(temp.right);
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(3);
        bt.root.left = new TreeNode(9);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(7);

        MaximumDepthofBinaryTree104 md = new MaximumDepthofBinaryTree104();
        System.out.println(md.maxDepth(bt.root));
        inorder(bt.root);
        bt.inorder(bt.root);

    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right){
            return left + 1;
        } else {
            return right + 1;
        }
    }
}
