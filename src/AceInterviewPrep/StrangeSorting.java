package AceInterviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrangeSorting {
    public static void main(String[] args) {
        StrangeSorting ss = new StrangeSorting();
        // map: {9,8,7,6,5,4,3,2,1,0}
        // ind: {0,1,2,3,4,5,6,7,8,9}
        //String[] nums = new String[]{"123", "124"};  // 876, 875
        //String[] nums = new String[]{"12345678999", "12345678998"}; //87654321000, 87654321001
        //String[] nums = new String[]{"91234", "123"}; //08765, 876
        String[] nums = new String[]{"91234", "1234"}; //08765, 8765

        System.out.println(Arrays.toString(nums));
        String[] res = ss.strangeSorting(new int[]{9,8,7,6,5,4,3,2,1,0}, nums);
        System.out.println(Arrays.toString(res));
    }

    public String[] strangeSorting(int[] mapping, String nums[]) {
        // todo : comparator seems not working
        if (mapping == null || mapping.length == 0 ||
                nums == null || nums.length == 0) return new String[0];

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < mapping.length; i++) {
            map.put(mapping[i], i);
        }
        List<Two> temp = new ArrayList();
        for (String num: nums) {
            StringBuilder sb = new StringBuilder();
            for (char c: num.toCharArray()) {
                if (map.get(Character.getNumericValue(c))==0 && sb.length()==0) continue;
                sb.append(map.get(Character.getNumericValue(c)));
            }
            Two t = new Two();
            t.oldOne = num;
            t.newOne = sb.toString();
            temp.add(t);
        }

        Collections.sort(temp, new Comparator<Two>() {
            @Override
            public int compare(Two o1, Two o2) {
                if (o1.newOne.length() != o1.newOne.length()) {
                    return o1.newOne.length() - o2.newOne.length();
                }
                return o2.newOne.compareTo(o1.newOne);
            }
        });

        String[] res = new String[nums.length];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i).oldOne;
        }
        return res;
    }
    public class Two{
        public String oldOne;
        public String newOne;
    }
}