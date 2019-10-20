package Tree;
import Tree.BinarySearchTree.BSTNode;
/**
 * @author Vincent
 * @Date 2019-07-11
 */
public class MinDiffinBST783 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(4);
        bst.root.left = new BSTNode(0);
        bst.root.right = new BSTNode(48);
        bst.root.right.left = new BSTNode(12);
        bst.root.right.right = new BSTNode(49);
        MinDiffinBST783 md = new MinDiffinBST783();
        System.out.println(md.minDiffInBST(bst.root));
    }

    static Integer prev = null;
    static Integer res = Integer.MAX_VALUE;

    public int minDiffInBST(BSTNode root) {
        if(root.left != null) minDiffInBST(root.left);
        if(prev != null) res = Math.min(res,root.val - prev);
        prev = root.val;
        if(root.right != null) minDiffInBST(root.right);
        return res;

    }

}
