package Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies575 {
    public static void main(String[] args) {
        DistributeCandies575 dc = new DistributeCandies575();
        int[] candy = {1,1,2,2,3,3};
        int[] candy2 = {1,1,2,3};
        int[] candy3 = {1000,1000,2,1,2,5,3,1};
        int[] candy4 = {0,0,14,0,10,0,0,0};
        System.out.println(dc.distributeCandies(candy3));
        System.out.println(dc.distributeCandies(candy4));

    }
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() > candies.length / 2 ? candies.length / 2 : kinds.size();

    }
}
