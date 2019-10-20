package Tree;

import java.util.*;

import Tree.BinaryTree.TreeNode;

public class BinaryTreeVerticalOrderTraversal314 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(3);
//        bt.root.left = new TreeNode(9);
//        bt.root.right = new TreeNode(8);
//        bt.root.left.left = new TreeNode(4);
//        bt.root.left.right = new TreeNode(0);
//        bt.root.right.left = new TreeNode(1);
//        bt.root.right.right = new TreeNode(7);

        BinaryTreeVerticalOrderTraversal314 btt = new BinaryTreeVerticalOrderTraversal314();
        System.out.println(btt.verticalOrder(bt.root));

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.offer(root);
        cols.offer(0);
        while (!q.isEmpty() && !cols.isEmpty()) {
            TreeNode cur = q.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
                cols.offer(col - 1);
            }
            if (cur.right != null) {
                q.offer(cur.right);
                cols.offer(col + 1);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;

    }
//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
//        queue.offer(new Pair(0, root));
//        while (!queue.isEmpty()) {
//            Pair tmp = queue.poll();
//            TreeNode node = tmp.getValue();
//            map.get(tmp.getKey()).add(node.val);
//            if (node.left != null) {
//                queue.add(new Pair(tmp.getKey() - 1, node.left));
//            }
//            if (node.right != null)  {
//                queue.add(new Pair(tmp.getKey() + 1, node.right));
//            }
//        }
//        for (List<Integer> sub : map.values()) {
//            res.add(sub);
//        }
//        return res;
//    }

    /**
     * Review 6/29/2019
     * Start from the root(denoting as column 0), push the node into a queue. Poll the node as current node,
     * when current node has left child, add col - 1 to the column queue. when current node has right child,
     * add col + 1 to the column queue.
     * Using Hash map to store the <col, List<>> pair.
     * @param root
     * @return
     */
//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        Queue<Integer> cols = new LinkedList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        ((LinkedList<TreeNode>) queue).add(root);
//        ((LinkedList<Integer>) cols).add(0);
//        int min = 0;
//        int max = 0;
//        while (!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            int col = cols.poll();
//            if (!map.containsKey(col)){
//                map.put(col, new ArrayList<>());
//            }
//            map.get(col).add(node.val);
//            if (node.left != null){
//                ((LinkedList<TreeNode>) queue).add(node.left);
//                ((LinkedList<Integer>) cols).add(col - 1);
//                min = Math.min(min, col - 1);
//
//            }
//            if (node.right != null){
//                ((LinkedList<TreeNode>) queue).add(node.right);
//                ((LinkedList<Integer>) cols).add(col + 1);
//                max = Math.max(max, col + 1);
//            }
//        }
//        for (int i = min; i <= max; i++){
//            res.add(map.get(i));
//        }
//        return res;
//
//
//    }

//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        Queue<Pair> queue = new LinkedList<>();
//        int max = 0, min = 0;
//        queue.offer(new Pair(0, root));
//        while (!queue.isEmpty()) {
//            Pair pair = queue.poll();
//            int col = pair.col;
//            TreeNode node = pair.node;
//            if (!map.containsKey(col)) {
//                map.put(col, new ArrayList<>());
//            }
//            map.get(col).add(node.val);
//            if (node.left != null) {
//                queue.offer(new Pair(col - 1, node.left));
//                min = Math.min(min, col - 1);
//            }
//            if (node.right != null) {
//                queue.offer(new Pair(col + 1, node.right));
//                max = Math.max(max, col + 1);
//            }
//        }
//        for (int i = min; i <= max; i++) {
//            res.add(map.get(i));
//        }
//        return res;
//    }

    public class Pair {
        int col;
        TreeNode node;
        public Pair (int i, TreeNode node) {
            col = i;
            node = node;
        }
    }
}
