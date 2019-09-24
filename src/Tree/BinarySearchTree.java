package Tree;

public class BinarySearchTree {
    static class BSTNode{
        int val;
        BSTNode left, right;

        public BSTNode(int _val){
            val = _val;
        }
    }

    BSTNode root;
    public BinarySearchTree(){
        root = null;
    }

    public void insert(int key){
        root = insert(root, key);
    }
    public BSTNode insert(BSTNode root, int key){
        if (root == null){
            root = new BSTNode(key);
            return root;
        }
        if (key < root.val){
            root.left = insert(root.left, key);
        } else if(key > root.val){
            root.right = insert(root.right, key);
        }
        return root;
    }

    public BSTNode delete(BSTNode root, int key){
//        if (root == null) return root;
//        if (key < root.val){
//            root.left = delete(root.left, key);
//        } else if(key > root.val){
//            root.right = delete(root.right, key);
//        } else {
//            if (root.left == null){ // The node to be deleted has only right child
//                return root.right;
//            } else if (root.right == null){ // The node to be deleted has only left child
//                return root.left;
//            } else { // The node to be deleted has two children
//                root.val = minValue(root.right);
//                root.right = delete(root.right, root.val);
//
//            }
//        }
//        return root;
        if (root == null) return null;
        if (root.val > key) {
            root.left = delete(root.left, key);
        } else if (root.val < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.right == null && root.left != null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                root.val = minValue(root.right);
                root.right = delete(root.right, root.val);
            }
        }
        return root;
    }

    public int minValue(BSTNode root){
        int min = root.val;
        while (root.left != null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    public void inorder(BSTNode root){
        if (root != null){
            inorder(root.right);
            System.out.print(root.val + " ");
            inorder(root.left);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(50);
        bst.insert(bst.root,30);
        bst.insert(bst.root,20);
        bst.insert(bst.root,40);
        bst.insert(bst.root,70);
        bst.insert(bst.root,60);
        bst.insert(bst.root,80);
//        bst.delete(bst.root,30);
        bst.inorder(bst.root);
    }
}
