package Tree;
import Tree.BinarySearchTree.BSTNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinBST230 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(3);
        bst.insert(bst.root,1);
        bst.insert(bst.root,4);
        bst.insert(bst.root,2);
        KthSmallestElementinBST230 ks = new KthSmallestElementinBST230();
        System.out.println(ks.kthSmallest(bst.root, 3));
    }
    public int kthSmallest(BSTNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        return list.get(k - 1);
    }
    public void inorder(List<Integer> list, BSTNode root) {
        if (root != null) {
            inorder(list,root.left);
            list.add(root.val);
            inorder(list, root.right);
        }
    }
}
