package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-03-15
 */
public class FindDuplicateSubtrees652 {
    public static void main(String[] args) {
        FindDuplicateSubtrees652 fd = new FindDuplicateSubtrees652();
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.right.left = new TreeNode(2);
        bt.root.right.left.left = new TreeNode(4);
        bt.root.right.right = new TreeNode(4);
        List<TreeNode> res = fd.findDuplicateSubtrees(bt.root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).val);
        }

    }

    HashMap<String, Integer> map;
    HashMap<Integer, Integer> count;
    List<TreeNode> res;
    int t;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        count = new HashMap<>();
        res = new ArrayList<>();
        t = 1;
        if (root == null) return res;
        lookup(root);
        return res;
    }

    public int lookup(TreeNode root) {
        if (root == null) return 0;
        String key = root.val + "," + lookup(root.left) + "," + lookup(root.right);
        int uniqueID = map.computeIfAbsent(key, x-> t++);
        count.put(uniqueID, count.getOrDefault(uniqueID, 0) + 1);
        if (count.get(uniqueID) == 2) {
            res.add(root);
        }
        return uniqueID;
    }
}
