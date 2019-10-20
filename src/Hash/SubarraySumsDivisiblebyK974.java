package Hash;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-15
 */
public class SubarraySumsDivisiblebyK974 {
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[] {4,5,0,-2,-3}, 5));
    }

    /**
     * 我们要看对sum(i,j)是否可以被K整除， 其实只要看sum(0,i)%K == sum(0,j)%K 就可以了， 那么我们只要遍历一次，
     * 计算每个index的余数就好， 这样，可以优化到O(N)
     * 进一步， 只要知道有几个index的余数是一样的， 那么在这个余数上可以有多少个子数组符合要求，也可以直接计算所有的可能了
     * 当然，上面的逻辑有一个问题，就是余数如果是负数，这里就会有问题了， 幸好， 输入的整数是有范围的，我们可以把数组处理一下，
     * 让余数变成非负的
     * @param A
     * @param K
     * @return
     */
//    public static int subarraysDivByK(int[] A, int K) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
//        int sum = 0, count = 0;
//        for (int num : A) {
//            sum = (sum + num) % K;
//            if (sum < 0) sum += K;
//            count += map.getOrDefault(sum, 0);
//            map.put(sum, map.getOrDefault(sum, 0) + 1);
//        }
//        return count;
//    }


    public static int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int sum = 0, count = 0;
        for (int num : A) {
            sum = (sum + num) % K;
            if (sum < 0) sum += K;
            count += map[sum];
            map[sum]++;
        }
        return count;
    }
}
