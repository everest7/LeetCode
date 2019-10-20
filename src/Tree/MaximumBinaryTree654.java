package Tree;

import Tree.BinaryTree.TreeNode;

import java.util.Arrays;

public class MaximumBinaryTree654 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        MaximumBinaryTree654 mb = new MaximumBinaryTree654();
        BinaryTree bt = new BinaryTree();
        bt.preorder(mb.constructMaximumBinaryTree(nums));

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int max_i = max(nums);
        int[] left = Arrays.copyOfRange(nums, 0, max_i);
        int[] right = Arrays.copyOfRange(nums, max_i + 1, nums.length - 1);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;

    }

    public int max(int[] nums){
        int maxi = 0, max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
                maxi = i;
            }
        }
        return maxi;
    }
}
