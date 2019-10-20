package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths257 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.right = new TreeNode(5);
        BinaryTreePaths257 btp = new BinaryTreePaths257();
        System.out.println(btp.binaryTreePaths(bt.root));
    }

    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> paths = new Stack<>();
        stack.push(root);
        paths.add(Integer.toString(root.val));
        String path;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            path = paths.pop();
            if (node.left == null && node.right == null){
                res.add(path);
            }
            if (node.left != null){
                paths.add(path + "->" + Integer.toString(node.left.val));
                stack.push(node.left);
            }
            if (node.right != null){
                paths.add(path + "->" + Integer.toString(node.right.val));
                stack.push(node.right);
            }
        }
        return res;
    }

    /*
    Recursive way
     */
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new LinkedList<>();
//        findPath(root, "", res);
//        return res;
//    }
//    public void findPath(TreeNode root, String sub, List<String> res){
//        if (root != null) {
//            sub += Integer.toString(root.val);
//            if (root.left == null && root.right == null) {
//                res.add(sub);
//            } else {
//                sub += "->";
//                findPath(root.left, sub, res);
//                findPath(root.right, sub, res);
//            }
//
//        }
//    }
}
