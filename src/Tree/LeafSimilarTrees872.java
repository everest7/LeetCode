package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees872 {
    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree(3);
        bt1.root.left = new TreeNode(5);
        bt1.root.right = new TreeNode(4);
        bt1.root.left.right = new TreeNode(2);
        bt1.root.left.left = new TreeNode(1);

        BinaryTree bt2 = new BinaryTree(8);
        bt2.root.left = new TreeNode(9);
        bt2.root.right = new TreeNode(4);
        bt2.root.left.left = new TreeNode(1);
        bt2.root.left.right = new TreeNode(2);

        LeafSimilarTrees872 ls = new LeafSimilarTrees872();
        System.out.println(ls.leafSimilar(bt1.root, bt2.root));
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getLeaf(root1, list1);
        getLeaf(root2, list2);
        return list1.equals(list2);
    }

    public void getLeaf(TreeNode root, List<Integer> list){
        if (root == null) return;
        if (root.left == null && root.right == null){
            list.add(root.val);
        }
        getLeaf(root.left,list);
        getLeaf(root.right,list);
    }
}
