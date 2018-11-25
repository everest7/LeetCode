package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII119 {
    public static void main(String[] args) {
        PascalTriangleII119 pt = new PascalTriangleII119();
        System.out.println(pt.getRow(4));
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex <= 0){
            return res;
        }
        res.add(1);
        for (int i = 0; i < rowIndex; i++){
            List<Integer> sub = new ArrayList<>();
            sub.add(1);
            for (int j = 0; j < res.size() - 1; j++){
                sub.add(res.get(j) + res.get(j + 1));
            }
            sub.add(1);
            res = sub;
        }
        return res;
    }

}
