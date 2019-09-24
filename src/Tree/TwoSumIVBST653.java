package Tree;
import Tree.BinarySearchTree.BSTNode;

import java.util.*;

public class TwoSumIVBST653 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new BSTNode(1);
        bst.insert(bst.root,3);
        bst.insert(bst.root,6);
        bst.insert(bst.root,2);
        bst.insert(bst.root,4);
        bst.insert(bst.root,7);
        TwoSumIVBST653 ts = new TwoSumIVBST653();
        System.out.println(ts.findTarget(bst.root,9));
        System.out.println(ts.findTarget(bst.root,28));
    }


    // Using HashSet and Queue
    public boolean findTarget(BSTNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<BSTNode> queue = new LinkedList<>();
        ((LinkedList<BSTNode>) queue).push(root);
        while (!queue.isEmpty()){
            BSTNode curr = queue.poll();
            if (set.contains(k - curr.val)){
                return true;
            }
            set.add(curr.val);
            if (curr.left != null){
                ((LinkedList<BSTNode>) queue).push(curr.left);
            }
            if (curr.right != null){
                ((LinkedList<BSTNode>) queue).push(curr.right);
            }
        }
        return false;
    }

//    public boolean findTarget(BSTNode root, int k){
//        Set<Integer> set = new HashSet<>();
//        return find(root, set, k);
//
//    }
//    public boolean find(BSTNode root, Set<Integer> set, int k){
//        if (root == null) return false;
//        if (set.contains(k - root.val)) return true;
//        set.add(root.val);
//        return find(root.left, set, k) || find(root.right, set, k);
//    }

    // Using inorder method convert the tree to an array
    // then using two pointer to find the target.
//    public boolean findTarget(BSTNode root, int k){
//        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
//        for (int i = 0, j = list.size() - 1; i < j;){
//            if (list.get(i) + list.get(j) == k) return true;
//            else if (list.get(i) + list.get(j) > k) j--;
//            else i++;
//        }
//        return false;
//    }
//
//    public void inorder(BSTNode root, List<Integer> list){
//        if (root == null) return;
//        else {
//            inorder(root.left, list);
//            list.add(root.val);
//            inorder(root.right, list);
//        }
//
//    }

}
