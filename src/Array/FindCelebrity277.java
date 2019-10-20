package Array;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-05-12
 */
public class FindCelebrity277 {
    public static void main(String[] args) {

    }

    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        boolean[] people = new boolean[n];
        Arrays.fill(people, true);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (knows(i, j) || !knows(j, i)) {
                    people[i] = false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (people[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean knows(int i, int j) {
        return true;
    }
}
