package Intv;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vincent
 * @Date 9/21/19
 */
public class SortString {

  public static void main(String[] args) {
    System.out.println(sortString(Arrays.asList("vb", "afd", "a", "D", "z")));
  }

  public static List<String> sortString(List<String> sts) {
    Collections.sort(sts, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
          return o1.length() - o2.length();
        }
        return o1.toLowerCase().compareTo(o2.toLowerCase());
      }
    });
    return sts;
  }

}
