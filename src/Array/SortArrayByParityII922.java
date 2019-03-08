package Array;

import java.util.Arrays;

public class SortArrayByParityII922 {
    public static void main(String[] args) {
        int[] input = {2, 3};
        SortArrayByParityII922 sa = new SortArrayByParityII922();
        System.out.println(Arrays.toString(sa.sortArrayByParityII(input)));
    }
//    public int[] sortArrayByParityII(int[] A){
//        int len = A.length;
//        int[] res = new int[len];
//        int m = 0, n = 1;
//        for (int x: A){
//            if (x % 2 == 0){
//                res[m] = x;
//                m += 2;
//            }
//            if (x % 2 == 1){
//                res[n] = x;
//                n += 2;
//            }
//        }
//        return res;
//    }
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; j < A.length && i < A.length; i += 2){
            if (A[i] % 2 == 1){
                while (A[j] % 2 == 1){
                    j += 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

            }
        }
        return A;
    }
}
