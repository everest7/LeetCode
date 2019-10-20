package Backtracking;

import java.util.HashSet;

/**
 * @author Vincent
 * @Date 2019-06-08
 */
public class LetterTilePossiblity1087 {
    public static void main(String[] args) {
        LetterTilePossiblity1087 lt = new LetterTilePossiblity1087();
        System.out.println(lt.numTilePossibilities("AAABBC"));
    }

    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[tiles.length()];
        backtrack(set, tiles, sb,  visited);
        return set.size();
    }

    public void backtrack(HashSet<String> set, String tiles, StringBuilder s,  boolean[] visited) {
        if (s.length() > tiles.length()) return;
        if (s.length() > 0) {
            set.add(s.toString());
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                s.append(tiles.charAt(i));
                visited[i] = true;
                backtrack(set, tiles, s, visited);
                s.deleteCharAt(s.length() - 1);
                visited[i] = false;
            }
        }
    }
}
