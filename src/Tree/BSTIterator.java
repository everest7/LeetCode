package Tree;
import Tree.BinarySearchTree.BSTNode;

import java.util.Stack;

public class BSTIterator {
    public static void main(String[] args) {

    }
    Stack<BSTNode> stack = new Stack<>();
    public BSTIterator(BSTNode root) {
        while (root != null){
            stack.push(root);
            root = root.left;
        }

    }

    /** @return the next smallest number */
    public int next() {
        BSTNode node = stack.pop();
        int res = node.val;
        if (node.right != null){
            node = node.right;
            while (node != null){
                stack.push(node);
                node = node.left;
            }

        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
