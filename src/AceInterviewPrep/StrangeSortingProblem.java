package AceInterviewPrep;

import java.util.*;

/**
 *
 */
public class StrangeSortingProblem {
    public static void main(String[] args) {
        StrangeSortingProblem ss = new StrangeSortingProblem();
        String[] nums = new String[]{"98765", "8765"};
        int[] mapping = new int[] {9,8,7,6,5,4,3,2,1,0};
//        String[] nums = new String[]{"12", "02", "4","023","65","83","224","50"};
//        int[] mapping = new int[] {2,1,4,8,6,3,0,9,7,5};
        System.out.println(ss.strangeSort(nums, mapping));
    }

    public class PairString {
        public String original;
        public String transformed;
        public PairString(String s, String t) {
            this.original = s;
            this.transformed = t;
        }
    }

    public List<String> strangeSort(String[] nums, int[] mapping) {
        List<String> res = new ArrayList<>();
        Map<Integer, Integer> mapNum = new HashMap<>();
        List<PairString> pairs = new ArrayList<>();
        for(int i = 0; i < mapping.length; i++) {
            mapNum.put(mapping[i], i);
        }
        List<PairString> temp = new ArrayList<>();
        for (String num: nums) {
            StringBuilder sb = new StringBuilder();
            for (char ch : num.toCharArray()) {
                int m = mapNum.get(Character.getNumericValue(ch));
                if (m == 0 && sb.length() == 0) continue;
                sb.append(ch);
            }
            temp.add(new PairString(num, sb.toString()));
//            pairs.add(new PairString(sb.toString(), num));
        }
        Collections.sort(temp, new Comparator<PairString>() {
            @Override
            public int compare(PairString o1, PairString o2) {
                if (o1.transformed.length() != o2.transformed.length()) {
                    return o1.transformed.length() - o2.transformed.length();
                }
                if (o1.transformed.compareTo(o2.transformed) != 0) return o1.transformed.compareTo(o2.transformed);
                return 0;
            }
        });
        for (PairString s : temp) {
            res.add(s.original);
        }
        return res;
    }


}
