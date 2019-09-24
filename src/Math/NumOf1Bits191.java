package Math;

public class NumOf1Bits191 {
    public static void main(String[] args) {
        NumOf1Bits191 nb = new NumOf1Bits191();
        System.out.println(nb.hammingWeight(10));
//        System.out.println(nb.hammingWeight(147483648));
    }
    public int hammingWeight(int n){
        int count = 0;
        while (n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
//    public int hammingWeight(int n) {
//        long count = 0;
//        while (n != 0) {
//            count += n & 1;
//            n = n >> 1;
//        }
//        return (int)count;
//    }
}
