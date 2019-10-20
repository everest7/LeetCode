package Tree;
import Tree.BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-05
 */
public class AllNodesDistKinBinaryTree863 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(3);
        bt.root.left = new TreeNode(5);
        bt.root.right = new TreeNode(1);
        bt.root.right.left = new TreeNode(0);
        bt.root.right.right = new TreeNode(8);
        bt.root.left.left = new TreeNode(6);
        bt.root.left.right = new TreeNode(2);
        bt.root.left.right.left = new TreeNode(7);
        bt.root.left.right.right = new TreeNode(4);
        AllNodesDistKinBinaryTree863 ad = new AllNodesDistKinBinaryTree863();
//        System.out.println(ad.distanceK(bt.root, bt.root.left, 2));
//        System.out.println(ad.distanceLessThanK(bt.root, bt.root.left, 2));
        System.out.println(ad.distanceGreaterK(bt.root, bt.root.left, 2));
    }

//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//        inorder(root, null, parent);
//        Queue<TreeNode> q = new LinkedList<>();
//        Set<TreeNode> set = new HashSet<>();
//        q.offer(target);
//        int count = 0;
//        while (!q.isEmpty() && count < K) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = q.poll();
//                set.add(cur);
//                if (cur.left != null && !set.contains(cur.left)) {
//                    q.offer(cur.left);
//                }
//                if (cur.right != null && !set.contains(cur.right)) {
//                    q.offer(cur.right);
//                }
//                if (parent.get(cur) != null && !set.contains(parent.get(cur))) {
//                    q.offer(parent.get(cur));
//                }
//            }
//            count++;
//        }
//        List<Integer> res = new ArrayList<>();
//        while (!q.isEmpty()) {
//            res.add(q.poll().val);
//        }
//        return res;
//    }

    public void inorder(TreeNode root, TreeNode father, Map<TreeNode, TreeNode> parent) {
        if (root == null) return;
        inorder(root.left, root, parent);
        parent.put(root, father);
        inorder(root.right, root, parent);
    }

    /**
     * Follow up 1: Collect all nodes whose distance is less than K.
     */
//    public List<Integer> distanceLessThanK(TreeNode root, TreeNode target, int K) {
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//        inorder(root, null, parent);
//        Queue<TreeNode> q = new LinkedList<>();
//        Set<TreeNode> set = new HashSet<>();
//        q.offer(target);
//        int count = 0;
//        List<Integer> list = new ArrayList<>();
//        while (!q.isEmpty() && count <= K) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = q.poll();
//                list.add(cur.val);
//                set.add(cur);
//                if (cur.left != null && !set.contains(cur.left)) {
//                    q.offer(cur.left);
//                }
//                if (cur.right != null && !set.contains(cur.right)) {
//                    q.offer(cur.right);
//                }
//                if (parent.get(cur) != null && !set.contains(parent.get(cur))) {
//                    q.offer(parent.get(cur));
//                }
//            }
//            count++;
//        }
//        return list;
//    }

    /**
     * Follow up 2: Collect all nodes with distance greater than K
     */
    public List<Integer> distanceGreaterK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        inorder(root, null, parent);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        q.offer(target);
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (count > K) list.add(cur.val);
                set.add(cur);
                if (cur.left != null && !set.contains(cur.left)) {
                    q.offer(cur.left);
                }
                if (cur.right != null && !set.contains(cur.right)) {
                    q.offer(cur.right);
                }
                if (parent.get(cur) != null && !set.contains(parent.get(cur))) {
                    q.offer(parent.get(cur));
                }
            }
            count++;
        }
        return list;
    }

//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) return res;
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//        Set<TreeNode> set = new HashSet<>();
//        findParent(root, parent);
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(target);
//        int level = 1;
//        while(!q.isEmpty()) {
//            int size = q.size();
//            if (level == K + 1) {
//                while (!q.isEmpty()) {
//                    res.add(q.poll().val);
//                }
//                break;
//            }
//            for (int i = 0; i < size; i++) {
//                TreeNode temp = q.poll();
//                set.add(temp);
//                if (parent.containsKey(temp) && !set.contains(parent.get(temp))) {
//                    q.offer(parent.get(temp));
//                }
//                if (temp.left != null && !set.contains(temp.left)) {
//                    q.offer(temp.left);
//                }
//                if (temp.right != null && !set.contains(temp.right)) {
//                    q.offer(temp.right);
//                }
//            }
//            level++;
//        }
//        return res;
//    }
//
//    public void findParent(TreeNode node, Map<TreeNode, TreeNode> parent) {
//        if (node == null) return;
//        if (node.left != null) parent.put(node.left, node);
//        if (node.right != null) parent.put(node.right, node);
//        findParent(node.left, parent);
//        findParent(node.right, parent);
//    }
}
