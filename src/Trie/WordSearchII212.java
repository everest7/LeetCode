package Trie;

import java.util.*;
/**
 * @author Vincent
 * @Date 2019-07-23
 */
public class WordSearchII212 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        WordSearchII212 ws = new WordSearchII212();
        String[] words = new String[] {"eat", "oath", "pea", "rain"};
        System.out.println(ws.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> dict = new HashSet<>();
        for (String s : words) {
            dict.add(s);
        }
        int rows = board.length, cols = board[0].length;
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        TrieNode root = buildTrie(words);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, board, res, visited, dict, root);
            }
        }
        return res;
    }

    public void dfs(int i, int j, char[][] board, List<String> res, boolean[][] visited, Set<String> set, TrieNode p) {
        char ch = board[i][j];
        if (p.next[ch - 'a'] == null || visited[i][j]) return;
        p = p.next[ch - 'a'];
        if (p.word != null && set.contains(p.word)) {
            res.add(p.word);
        }
        visited[i][j] = true;
        if (i > 0) dfs(i - 1, j, board, res, visited, set, p);
        if (j > 0) dfs(i, j - 1, board, res, visited, set, p);
        if (i < board.length - 1) dfs(i + 1, j, board, res, visited, set, p);
        if (j < board[0].length - 1) dfs(i, j + 1, board, res, visited, set, p);
        visited[i][j] = false;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String s: words) {
            TrieNode p = root;
            for (char ch : s.toCharArray()) {
                if (p.next[ch - 'a'] == null) p.next[ch - 'a'] = new TrieNode();
                p = p.next[ch - 'a'];
            }
            p.word = s;
        }
        return root;
    }
}
