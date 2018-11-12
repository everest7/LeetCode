package Tree;
import Tree.BinarySearchTree.BSTNode;
public class InsertIntoBST701 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(4);
        bst.insert(bst.root,2);
        bst.insert(bst.root,7);
        bst.insert(bst.root,1);
        bst.insert(bst.root,3);

        InsertIntoBST701 ii = new InsertIntoBST701();
        ii.insertIntoBST(bst.root, 6);
        bst.inorder(bst.root);


    }
    public BSTNode insertIntoBST(BSTNode root, int val) {
        if (root == null){
            root = new BSTNode(val);
            return root;
        }
        if (val < root.val){
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
