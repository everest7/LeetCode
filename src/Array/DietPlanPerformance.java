package Array;

/**
 * @author Vincent
 * @Date 2019-08-31
 */
public class DietPlanPerformance {
    public static void main(String[] args) {
        System.out.println(dietPlanPerformance(new int[] {1,2,3,4,5}, 1, 3,3));
        System.out.println(dietPlanPerformance(new int[] {6,5,0,0}, 2, 1,5));
        System.out.println(dietPlanPerformance(new int[] {6,13,8,7,10,1,12,11}, 6, 5,37));
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int total = 0, left = 0, right = 0, temp = 0;
        while (right < calories.length) {
            temp += calories[right];
            while (right - left + 1 >= k) {
                if (temp < lower) total -= 1;
                else if (temp > upper) total += 1;
                temp -= calories[left++];
            }
            right++;
        }
        return total;
    }
}
