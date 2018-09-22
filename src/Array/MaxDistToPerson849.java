package Array;

public class MaxDistToPerson849 {
    public static void main(String[] args) {
        MaxDistToPerson849 mp = new MaxDistToPerson849();
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(mp.maxDistToClosest(seats));
    }
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int i, j;
        for (i = j = 0; j < seats.length; ++j){
            if (seats[j] == 1){
                if (i == 0) res = Math.max(res,j - i);
                else res = Math.max(res,(j - i + 1) / 2);
                i = j + 1;
            }

        }
        res = Math.max(res, seats.length - i);
        return res;

    }
}
