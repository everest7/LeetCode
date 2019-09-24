package Tree;

import java.util.*;

public class NaryTree {
    static class NaryNode {
        public int val;
        public List<NaryNode> children;

        public NaryNode() {}

        public NaryNode(int _val, List<NaryNode> _children) {
            val = _val;
            children = _children;
        }
        public NaryNode(int _val){
            val = _val;
        }

        public void addChild(NaryNode node){
//            node.setParentNode(this);
            if (this.children == null){
                this.children = new ArrayList<>();
            }
            this.children.add(node);
        }

        public void removeChild(NaryNode node){
            if (this.children != null){
                this.children.remove(node);
            }
        }

        public List<NaryNode> getChildren(){
            return children;
        }

        public void setChildren(List<NaryNode> children){
            this.children = children;
        }


    }
    NaryNode root;
    public NaryTree(int key){

    }

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
//        printNode(root);
//        if (root.children != null){
//            for (Node node: root.children){
//                System.out.println(node.val);
//            }
//        }
        System.out.println(preorder(root));
    }

    public static void printNode(NaryNode node){
        System.out.println(node.val);
    }
    public static List<Integer> preorder(NaryNode root) {
        Stack<NaryNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            NaryNode temp = stack.pop();
            res.add(temp.val);
            if (temp.children != null){

                Collections.reverse(temp.children);
                for (NaryNode node: temp.children){
                    stack.push(node);
                }
            }

        }
        return res;
    }
}
