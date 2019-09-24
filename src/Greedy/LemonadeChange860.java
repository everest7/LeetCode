package Greedy;

public class LemonadeChange860 {
    public static void main(String[] args) {
        int[] bills = {10,5,5,5,10,20};
        LemonadeChange860 lc = new LemonadeChange860();
        System.out.println(lc.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int i = 0; i < bills.length; i++){
            if (bills[i] == 5) five++;
            else if (bills[i] == 10){
                ten++;
                five--;
            } else {
                twenty++;
                if (ten > 0){
                    ten--;
                    five--;

                } else {
                    five = five - 3;
                }
            }
            if (five < 0 || ten < 0){
                return false;
            }
        }
        return true;
    }
}
