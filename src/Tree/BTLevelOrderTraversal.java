package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(3);
        bt.root.left = new TreeNode(9);
        bt.root.left.left = new TreeNode(10);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(7);


        BTLevelOrderTraversal bl = new BTLevelOrderTraversal();
//        System.out.println(bl.levelOrder(bt.root));
        levelOrderPrint(bt.root);
    }

    /**
     * Follow up: print the level order in 2D char array.
     * @param root
     * @return
     */
    public static void levelOrderPrint(TreeNode root) {
        if (root == null) return;
//        List<List<int[]>> res = new LinkedList<List<int[]>>();
        List<int[]> res = new LinkedList<>();
        Queue<Wrap> queue = new LinkedList<>();
        queue.add(new Wrap(root,0, 0));
        int level = 0;
        int left = 0, right = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Wrap cur = queue.poll();
                res.add(new int[] {cur.node.val, level, cur.col});
                if (cur.node.left != null) {
                    left = Math.min(left, cur.col - 1);
                    queue.add(new Wrap(cur.node.left, level, cur.col - 1));
                }
                if (cur.node.right != null) {
                    right = Math.max(right, cur.col + 1);
                    queue.add(new Wrap(cur.node.right, level, cur.col + 1));
                }
            }
            level++;
        }
        int[][] map = new int[level][right - left + 1];
        for (int[] node: res) {
            int val = node[0];
            int row = node[1];
            int col = node[2] + (right - left ) / 2;
            map[row][col] = val;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) System.out.print(map[i][j]);
                else System.out.print("--");
            }
            System.out.println();
        }

    }
    static class Wrap {
        TreeNode node;
        int row;
        int col;
        public Wrap(TreeNode nod, int r, int c) {
            this.node = nod;
            this.row = r;
            this.col = c;
        }
    }


//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return null;
//        List<List<Integer>> res = new LinkedList<List<Integer>>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode cur = root;
//        ((LinkedList<TreeNode>) queue).add(cur);
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            List<Integer> sub = new ArrayList<>();
//            for (int i = 0; i < size; i++){
//                cur = queue.poll();
//                sub.add(cur.val);
//                if (cur.left != null) queue.add(cur.left);
//                if (cur.right != null) queue.add(cur.right);
//            }
//            res.add(sub);
//        }
//        return res;
//
//    }

}
