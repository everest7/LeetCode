package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vincent
 * @Date 2019-06-30
 */
public class SerializeandDeserializeBinaryTree297 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new BinaryTree.TreeNode(1);
        bt.root.right = new BinaryTree.TreeNode(2);
//        bt.root.right = new BinaryTree.TreeNode(3);
//        bt.root.right.left = new BinaryTree.TreeNode(4);
//        bt.root.right.right = new BinaryTree.TreeNode(5);
        SerializeandDeserializeBinaryTree297 sl = new SerializeandDeserializeBinaryTree297();
        String data = sl.serialize(bt.root);
        System.out.println(sl.serialize(bt.root));
        bt.levelorder(sl.deserialize(data));
    }

    /**
     * DFS
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",null");
            return;
        }
        sb.append(sb.length() == 0 ? root.val : "," + root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfsDeser(q);
    }

    public TreeNode dfsDeser(Queue<String> q) {
        if (q.isEmpty()) return null;
        String cur = q.poll();
        if (cur.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = dfsDeser(q);
        root.right = dfsDeser(q);
        return root;
    }

    /**
     * BFS
     */
//    public String serialize(TreeNode root) {
//        if (root == null) return "";
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        StringBuilder sb = new StringBuilder();
//        while (!q.isEmpty()) {
//            TreeNode temp = q.poll();
//            if (temp == null) {
//                sb.append(",null");
//                continue;
//            }
//            sb.append(temp == root ? temp.val : "," + temp.val);
//            q.offer(temp.left);
//            q.offer(temp.right);
//        }
//        return sb.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data.length() == 0) return null;
//        String[] nodes = data.split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        for (int i = 1; i < nodes.length; i++) {
//            TreeNode temp = q.poll();
//            if (!nodes[i].equals("null")) {
//                TreeNode left = new TreeNode(Integer.parseInt(nodes[i++]));
//                temp.left = left;
//                q.offer(left);
//            }
//            if (!nodes[i].equals("null")) {
//                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
//                temp.right = right;
//                q.offer(right);
//            }
//        }
//        return root;
//    }

//    public String serialize(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        q.offer(root);
//        while (!q.isEmpty()) {
//            TreeNode temp = q.poll();
//            if (temp == null) {
//                sb.append(",null");
//                continue;
//            }
//            sb.append(temp == root ? temp.val : "," + temp.val);
//            q.offer(temp.left);
//            q.offer(temp.right);
//
//
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//
//
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        String tree = data.substring(1, data.length() - 1);
//        String[] nodes = tree.split(",");
//        Queue<TreeNode> queue= new LinkedList<>();
//        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
//        queue.offer(root);
//        for (int i = 1; i < nodes.length; i++) {
//            TreeNode temp = queue.poll();
//            if (temp == null) continue;
//            if (!nodes[i].equals("null")) {
//                TreeNode left = new TreeNode(Integer.valueOf(nodes[i]));
//                temp.left = left;
//                queue.offer(left);
//            }
//            i++;
//            if (!nodes[i].equals("null")) {
//                TreeNode right = new TreeNode(Integer.valueOf(nodes[i]));
//                temp.right = right;
//                queue.offer(right);
//            }
//        }
//
//        return root;
//    }
}
