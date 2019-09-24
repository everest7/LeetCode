package Tree;
import Tree.NaryTree.NaryNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryPostorderTraversal590 {
    public static void main(String[] args) {
        NaryPostorderTraversal590 np = new NaryPostorderTraversal590();
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
        System.out.println(np.postorder(root));

    }

    // Recursive way
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> postorder(NaryNode root){
//
//        if (root == null) {
//            return res;
//        }
//        if (root.children != null){
//            for (NaryNode node: root.children){
//                postorder(node);
//            }
//        }
//        res.add(root.val);
//        return res;
//
//    }

    // Iterative way
    public static List<Integer> postorder(NaryNode root) {
        Stack<NaryNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            NaryNode temp = stack.pop();
            res.add(temp.val);
            if (temp.children != null){
                for(NaryNode node: temp.children){
                    stack.push(node);
                }
            }

        }
        Collections.reverse(res);
        return res;
    }
}
