package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-03-17
 */
public class AllPossibleFullBinaryTrees894 {
    public static void main(String[] args) {
        AllPossibleFullBinaryTrees894 af = new AllPossibleFullBinaryTrees894();
        List<TreeNode> res = af.allPossibleFBT(7);
        for (TreeNode node :res) {
            System.out.println(node.val);
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N < 1 || N % 2 == 0) return res;
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 1; i < N; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode ln : left) {
                for (TreeNode rn : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = ln;
                    cur.right = rn;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
