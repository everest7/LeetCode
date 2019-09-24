package Tree;
import Tree.BinaryTree.TreeNode;
public class ConvertSortedArraytoBST108 {
    public static void main(String[] args) {
        int[] arg = {-10,-3,0,5,9};
        ConvertSortedArraytoBST108 cs = new ConvertSortedArraytoBST108();
        BinaryTree bt = new BinaryTree(1);
        bt.preorder(cs.sortedArrayToBST(arg));
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        return util(nums, low, high);

    }
    public TreeNode util(int[] nums, int low, int high){
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = util(nums, low, mid - 1);
        node.right = util(nums, mid + 1, high);
        return node;
    }
}
