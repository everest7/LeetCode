package Tree;
import Tree.BinarySearchTree.BSTNode;

public class DeleteNodeBST450 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(5);
        bst.insert(bst.root, 3);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 2);
        bst.insert(bst.root, 7);

        DeleteNodeBST450 dn = new DeleteNodeBST450();
        dn.deleteNode(bst.root, 3);
        bst.inorder(bst.root);
    }
    public BSTNode deleteNode(BSTNode root, int key) {
        if (root == null) return root;
        if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            // the node to be deleted is leaf
            if (root.left == null && root.right == null){
                root = null;
            } else if (root.left == null || root.right == null){ // node to be deleted has only one child
                root = root.left == null ? root.right : root.left;
            } else { // node to be deleted has two children
                int min = minvalue(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            }
        }
        return root;
    }
    public int minvalue(BSTNode root){
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }
}
