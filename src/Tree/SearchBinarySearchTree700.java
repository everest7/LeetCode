package Tree;
import Tree.BinarySearchTree.BSTNode;

public class SearchBinarySearchTree700 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(4);
        bst.insert(bst.root,2);
        bst.insert(bst.root,7);
        bst.insert(bst.root,1);
        bst.insert(bst.root,3);
        SearchBinarySearchTree700 st = new SearchBinarySearchTree700();
        bst.inorder(st.searchBST(bst.root, 5));
    }
    public BSTNode searchBST(BSTNode root, int val){
        if (root == null) return root;
        // Here you can't swap the conditional
        // Check if the root is null first, then retrieve its val
        while (root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    // Recursive way
//    public BSTNode searchBST(BSTNode root, int val) {
//        if (root == null) return root;
//        if (root.val == val) {
//            return root;
//        } else {
//            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
//        }
//
//    }
}
