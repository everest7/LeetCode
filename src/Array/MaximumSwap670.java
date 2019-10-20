package Array;

/**
 * @author Vincent
 * @Date 9/7/19
 */
public class MaximumSwap670 {
    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }

    public static int maximumSwap(int num) {
        char[] numbers = Integer.toString(num).toCharArray();
        int[] lastPos = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            lastPos[numbers[i] - '0'] = i;
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 9; j > numbers[i] - '0'; j--) {
                if (lastPos[j] <= i) continue;
                char tmp = numbers[i];
                numbers[i] = numbers[lastPos[j]];
                numbers[lastPos[j]] = tmp;
                return Integer.parseInt(String.valueOf(numbers));
            }
        }
        return num;
    }

//    public static int maximumSwap(int num) {
//        String number = Integer.toString(num);
//        char[] chs = number.toCharArray();
//        int[] bucket = new int[10];
//        for (int i = 0; i < chs.length; i++) {
//            bucket[chs[i] - '0'] = i;
//        }
//        for (int i = 0; i < chs.length; i++) {
//            for (int j = 9; j > chs[i] - '0'; j--) {
//                if (bucket[j] <= i) continue;
//                char temp = chs[bucket[j]];
//                chs[bucket[j]] = chs[i];
//                chs[i] = temp;
//                return Integer.parseInt(String.valueOf(chs));
//            }
//        }
//        return num;
//    }
}
