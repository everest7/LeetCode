package Tree;
import Tree.NaryTree.NaryNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaxDepthNaryTree559 {
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
        MaxDepthNaryTree559 md = new MaxDepthNaryTree559();
        System.out.println(md.maxDepth(root));
    }
    public int maxDepth(NaryNode root) {
        if (root == null){
            return 0;
        } else if(root.children == null){
            return 1;
        }
        int max = 0;
        for (NaryNode node : root.children){
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }
}
