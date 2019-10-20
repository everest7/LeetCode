package Array;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicateII219 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
//        int[] nums = {1, 2, 3, 1};
        ContainDuplicateII219 cd = new ContainDuplicateII219();
        System.out.println(cd.containsNearbyDuplicate(nums, 2));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]); // remove the oldest element
            }
        }
        return false;
    }
}
