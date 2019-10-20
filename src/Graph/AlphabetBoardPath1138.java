package Graph;
import java.util.*;
import java.awt.desktop.AppForegroundListener;

/**
 * @author Vincent
 * @Date 2019-07-27
 */
public class AlphabetBoardPath1138 {
    public static void main(String[] args) {
        AlphabetBoardPath1138 ap = new AlphabetBoardPath1138();
        System.out.println(ap.alphabetBoardPath("zbz"));
    }

    int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public String alphabetBoardPath(String target) {
        char[] s = target.toCharArray();
        StringBuilder res = new StringBuilder();
        char[][] board = new char[][] {
                {'a','b','c','d','e'},
                {'f','g','h','i','j'},
                {'k','l','m','n','o'},
                {'p','q','r','s','t'},
                {'u','v','w','x','y'},
                {'z','~','~','~','~'}};
        Map<Character, int[]> map = new HashMap<>();
        for (int k = 0; k < s.length; k++) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5 ; j++) {
                    if (board[i][j] == s[k]) {
                        map.put(s[k], new int[]{i, j});
                    }
                }
            }
        }
        int preX = 0, preY = 0;
        for (int k = 0; k < s.length; k++) {
            int nextX = map.get(s[k])[0];
            int nextY = map.get(s[k])[1];
            if (k > 0 && s[k] == 'z') {
                if (nextY > preY) {
                    for (int i = preY; i < nextY; i++) {
                        res.append('R');
                    }
                } else {
                    for (int i = nextY; i < preY; i++) {
                        res.append('L');
                    }
                }

                if (nextX > preX) {
                    for (int i = preX; i < nextX; i++) {
                        res.append('D');
                    }
                } else {
                    for (int i = nextX; i < preX; i++) {
                        res.append('U');
                    }
                }
            } else {
                if (nextX > preX) {
                    for (int i = preX; i < nextX; i++) {
                        res.append('D');
                    }
                } else {
                    for (int i = nextX; i < preX; i++) {
                        res.append('U');
                    }
                }
                if (nextY > preY) {
                    for (int i = preY; i < nextY; i++) {
                        res.append('R');
                    }
                } else {
                    for (int i = nextY; i < preY; i++) {
                        res.append('L');
                    }
                }
            }
            preX = nextX;
            preY = nextY;
            res.append('!');
        }
        return res.toString();
    }
}
