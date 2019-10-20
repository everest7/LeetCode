package Array;

public class SingleNumberII137 {
    public static void main(String[] args) {
        SingleNumberII137 sn = new SingleNumberII137();
        int nums[] = {1,1,2,1};
        System.out.println(sn.singleNumber(nums));
    }
    /**
     * Storing integer in 32 bits
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
//    public int singleNumber(int[] nums) {
//        int ones = 0, twos = 0;
//        for (int i = 0; i < nums.length; i++) {
//            ones = (ones ^ nums[i]) & ~twos;
//            twos = (twos ^ nums[i]) & ~ones;
//        }
//        return ones;
//    }

}
