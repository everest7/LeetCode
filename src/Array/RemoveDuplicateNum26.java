package Array;

public class RemoveDuplicateNum26 {
    public static void main(String[] args) {
        RemoveDuplicateNum26 rp = new RemoveDuplicateNum26();
        int[] arr = {1,1,2};
        System.out.println(rp.removeDuplicates(arr));

    }
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
