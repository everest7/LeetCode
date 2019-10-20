package Array;

/**
 * @author Vincent
 * @Date 9/7/19
 */
public class FriendsOfAppropriateAges825 {
    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[] {16, 17, 18}));
    }

    /**
     * Friends with appropriate ages are (a/2+7, a]
     * @param ages
     * @return
     */
    public static int numFriendRequests(int[] ages) {
        int[] ageSum = new int[121], sumPeople = new int[121];
        for (int age: ages) {
            ageSum[age]++;
        }
        for (int i = 1; i < 121; i++) {
            sumPeople[i] = sumPeople[i - 1] + ageSum[i];
        }
        int res = 0;
        for (int i = 15; i < 121; i++) {
            if (ageSum[i] == 0) continue;
            int count = sumPeople[i] - sumPeople[i / 2 + 7];
            res += count * ageSum[i] - ageSum[i];
        }
        return res;
    }
}
