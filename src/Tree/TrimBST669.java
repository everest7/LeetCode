package Tree;
import Tree.BinarySearchTree.BSTNode;

public class TrimBST669 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(3);
        bst.insert(0);
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        TrimBST669 tm = new TrimBST669();
        bst.inorder(tm.trimBST(bst.root, 1, 3));
    }
    public BSTNode trimBST(BSTNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R){
            return trimBST(root.left, L, R);
        }
        if (root.val < L){
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;

    }
}
