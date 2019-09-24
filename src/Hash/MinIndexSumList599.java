package Hash;

import java.util.*;

public class MinIndexSumList599 {
    public static void main(String[] args) {
        String[] st1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] st2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] st3 = {"KFC", "Shogun", "Burger King"};
        MinIndexSumList599 mi = new MinIndexSumList599();
        System.out.println(Arrays.toString(mi.findRestaurant(st1,st3)));
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> st = new ArrayList<>();
        Map<String,Integer> map1 = new LinkedHashMap<>();
        for (int i = 0; i < list1.length; i++){
            map1.put(list1[i],map1.getOrDefault(list1[i],0) + i);
        }
        int leastSum = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++){
            if (map1.containsKey(list2[j])){
                int sum = map1.get(list2[j]) + j;
                if (leastSum > sum){
                    leastSum = sum;
                    st.clear();
                    st.add(list2[j]);
                } else if (leastSum == sum){
                    st.add(list2[j]);
                }
            }
        }
        return st.toArray(new String[st.size()]);
    }
}
