package Tree;
import Tree.BinaryTree.TreeNode;
import Tree.BinarySearchTree.BSTNode;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderTree897 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTree bt = new BinaryTree();
        bst.root = new BSTNode(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(8);
        bst.insert(9);
        bst.inorder(bst.root);

        IncreasingOrderTree897 io = new IncreasingOrderTree897();
//        TreeNode res = io.increasingBST(bst.root);
    }
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> lis = new ArrayList<>();
        inorder(root, lis);
        TreeNode curr = new TreeNode(0);
        for (TreeNode node: lis){
            curr.right = node;
            curr = curr.right;
        }
        return curr.right;

    }
    public void inorder(TreeNode root, List<TreeNode> list){
        if (root != null){
            inorder(root.left, list);
            list.add(root);
            inorder(root.right, list);
        }
    }
}
