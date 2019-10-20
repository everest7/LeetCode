package Trie;

/**
 * @author Vincent
 * @Date 2019-08-01
 */
public class AddandSearchWord211 {
    static TrieNode root;
    public static void main(String[] args) {
        AddandSearchWord211 as = new AddandSearchWord211();
        root = new TrieNode();
        as.addWord("bad");
        as.addWord("mad");
        System.out.println(as.search(".ad"));
    }

    static class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }


    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;

        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.word = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, 0, word);
    }

    public boolean match(TrieNode root, int k, String word) {
        if (k == word.length()) return root.word != null;
        char ch = word.charAt(k);
        if (ch != '.') {
            return root.children[ch - 'a'] != null && match(root.children[ch - 'a'], k + 1, word);
        } else {
            for (int i = 0; i < root.children.length; i++) {

                if (root.children[i] != null && match(root.children[i], k + 1, word) ){
                    return true;
                }
            }
        }
        return false;
    }
}
