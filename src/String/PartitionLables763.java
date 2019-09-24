package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Record the last appearing index of a character.
 * Keep updating the last index of character in current group.
 */
public class PartitionLables763 {
    public static void main(String[] args) {
        PartitionLables763 pl = new PartitionLables763();
        String s = "ababcbacadefegdehijhklij";
        System.out.println(pl.partitionLabels(s));
    }
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }
        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']); // updating the last index of character in current group
            if (last == i){ // found the last char, partition into one group
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;

    }
}
