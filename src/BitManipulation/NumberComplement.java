package BitManipulation;

public class NumberComplement {
    public static void main(String[] args) {
        NumberComplement nc = new NumberComplement();
        System.out.println(Integer.highestOneBit(~5));
//        System.out.println(nc.findComplement(1));
//        System.out.println(nc.findComplement(5));
    }
    /**
     * Using Integer function
     */
    public int findComplement(int num) {
        return ~num + (Integer.highestOneBit(num) << 1);
    }

    /**
     * Using mask
     */
//    public int findComplement(int num) {
//        int mask = 1, ori = num;
//        while (ori > 0) {
//            mask = mask << 1;
//            ori = ori >> 1;
//        }
//        return num ^ (mask - 1);
//    }
}
