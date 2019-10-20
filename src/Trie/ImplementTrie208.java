package Trie;

/**
 * @author Vincent
 * @Date 2019-06-14
 */
public class ImplementTrie208 {
    public static void main(String[] args) {

    }

}

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.containsKey(word.charAt(i))) {
                cur = cur.get(word.charAt(i));
            } else {
                cur.put(word.charAt(i), new TrieNode());
            }
        }
        cur.setEnd();
    }

    public TrieNode prefix(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (cur.containsKey(curChar)) {
                cur = cur.get(curChar);
            } else {
                return null;
            }
        }
        return cur;
    }

    public boolean search(String word) {
        TrieNode node = prefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String word) {
        TrieNode node = prefix(word);
        return node != null;
    }
}
