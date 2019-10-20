package Tree;
import Tree.BinarySearchTree.BSTNode;

public class LowestCommonAncestorofBST235 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(6);
        bst.root.left = new BSTNode(6);
        bst.root.left.left = new BSTNode(0);
        bst.root.left.right = new BSTNode(4);
        bst.root.left.right.left = new BSTNode(3);
        bst.root.left.right.right = new BSTNode(5);
        bst.root.right = new BSTNode(6);
        bst.root.right.left = new BSTNode(7);
        bst.root.right.right = new BSTNode(9);
        LowestCommonAncestorofBST235 lc = new LowestCommonAncestorofBST235();
        BSTNode p = new BSTNode(2);
        BSTNode q = new BSTNode(8);
        System.out.println(lc.lowestCommonAncestor(bst.root, p, q).val);
    }
    /**
     * Iterative approach
     */
    public BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q) {
        while (root != null){
            if (root.val < p.val && root.val < q.val){
                root = root.right;
            } else if (root.val > p.val && root.val > q.val){
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    /**
     * Recursive approach
     * @param root
     * @param p
     * @param q
     * @return
     */
//    public BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q) {
//        if (root.val < p.val && root.val < q.val){
//            return lowestCommonAncestor(root.right, p, q);
//        } else if (root.val > p.val && root.val > q.val){
//            return lowestCommonAncestor(root.left, p, q);
//        } else {
//            return root;
//        }
//    }
}
