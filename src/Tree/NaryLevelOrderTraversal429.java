package Tree;
import Tree.NaryTree.NaryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryLevelOrderTraversal429 {
    public static void main(String[] args) {
        NaryNode root = new NaryNode(1);
        NaryNode A = new NaryNode(3);
        NaryNode B = new NaryNode(2);
        NaryNode C = new NaryNode(4);
        NaryNode Aa = new NaryNode(5);
        NaryNode Ab = new NaryNode(6);
        root.addChild(A);
        root.addChild(B);
        root.addChild(C);
        A.addChild(Aa);
        A.addChild(Ab);
        NaryLevelOrderTraversal429 nl = new NaryLevelOrderTraversal429();
        System.out.println(nl.levelOrder(root));

    }
    public List<List<Integer>> levelOrder(NaryNode root) {
        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<NaryNode> queue = new LinkedList<>();
        NaryNode curr = root;
        ((LinkedList<NaryNode>) queue).push(curr);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++){
                NaryNode node = queue.poll();
                sub.add(node.val);
                if (node.children != null){
                    for (NaryNode child : node.children){
                        ((LinkedList<NaryNode>) queue).add(child);
                    }
                }
            }
            res.add(sub);
        }
        return res;
    }
}
