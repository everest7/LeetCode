package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens51 {
    public static void main(String[] args) {
        NQueens51 nq = new NQueens51();
        System.out.println(nq.solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] pos = new int[n];
        backtracking(res, new String[n], pos,0, n);
        return res;

    }
    public void backtracking(List<List<String>> res, String[] templist, int[] pos, int row, int size){
        if (row == size){
//            String[][] output = new String[size][size];
            for (int i = 0; i < size; i++){
                if (i == pos[i]){
                    templist[i] = "Q";
                } else {
                    templist[i] = ".";
                }
            }
            System.out.println(Arrays.toString(templist));
//            for (int i = 0; i < size; i++){
//                output[i][pos[i]] = "Q";
//                templist.add(Arrays.toString(output[i]));
//            }

//            templist.add(Arrays.toString(output));
            res.add(Arrays.asList(templist));
        } else {
            for (int col = 0; col < size; col++){
                if (isSafe(pos, row, col)){
                    pos[row] = col;
                    backtracking(res, templist, pos, row + 1, size);
                    pos[row] = 0;
                }
            }
        }
    }
    public boolean isSafe(int[] pos, int row, int col){
        for (int i = 0; i < row; i++){
            if (col == pos[i] || Math.abs(row - i) == Math.abs(col - pos[i])){
                return false;
            }
        }
        return true;
    }
}
