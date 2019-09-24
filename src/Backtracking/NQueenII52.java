package Backtracking;

import java.util.Arrays;

public class NQueenII52 {
    int res = 0;
    public static void main(String[] args) {
        NQueenII52 nq = new NQueenII52();
        System.out.println(nq.totalNQueens(4));
    }
    public int totalNQueens(int n) {
        res = 0;
        int[] pos = new int[n]; // the position of queen in (i)th row
        backtracking(pos, 0, n);
        return res;
    }

    public void backtracking(int[] pos, int row, int size){
        if (row == size){
            res++;
        } else {
            for (int col = 0; col < size; col++){
                if (isSafe(pos, row, col)){
                    pos[row] = col;
                    backtracking(pos, row + 1, size);
                    pos[row] = 0;
                }
            }
        }
    }
    public boolean isSafe(int[] pos, int row, int col){
        for (int i = 0; i < row; i++){
            // check if the current spot is in the same column
            // check the upper left and upper right diagonal
            if (col == pos[i] || Math.abs(row - i) == Math.abs(col - pos[i])){
                return false;
            }
        }
        return true;
    }
}
