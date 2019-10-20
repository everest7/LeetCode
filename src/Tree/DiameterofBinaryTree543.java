package Tree;

import Tree.BinaryTree.TreeNode;

public class DiameterofBinaryTree543 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        DiameterofBinaryTree543 db = new DiameterofBinaryTree543();
        System.out.println(db.diameterOfBinaryTree(bt.root));
    }

    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }
    public int depth(TreeNode node){
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;

    }
}
