package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    public static void main(String[] args) {
        PascalTriangle118 pts = new PascalTriangle118();
        System.out.println(pts.generate(0));
        System.out.println(pts.generate(1));
        System.out.println(pts.generate(2));

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        res.add(prev);
        for (int i = 2; i < numRows + 1; i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 0; j < prev.size() - 1; j++){
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            res.add(curr);
            prev = curr;
        }
        return res;
    }
}
