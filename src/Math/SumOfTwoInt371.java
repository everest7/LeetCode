package Math;

public class SumOfTwoInt371 {
    public static void main(String[] args) {
        SumOfTwoInt371 st = new SumOfTwoInt371();
        System.out.println(st.getSum(3, 7));
    }
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
