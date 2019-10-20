package Graph;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-03-18
 */
public class WordLadder127 {
    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordlist = new ArrayList<>();
        wordlist = Arrays.asList(words);
        WordLadder127 wl = new WordLadder127();
        System.out.println(wl.ladderLength("hit", "cog", wordlist));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        q.offer(beginWord);
        map.put(beginWord, 1);
        while (!q.isEmpty()) {
            String word = q.poll();
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = String.valueOf(chars);
                    if (dict.contains(newWord) && newWord.equals(endWord)) {
                        return map.get(word) + 1;
                    }
                    if (dict.contains(newWord) && !map.containsKey(newWord)) {
                        q.add(newWord);
                        map.put(newWord, map.get(word) + 1);
                    }
                }
            }
        }
        return 0;
    }


//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(beginWord.equals(endWord)) return 1;
//        Set<String> set = new HashSet<>(wordList);
//        Queue<String> q = new LinkedList<>();
//        int len = 2;
//        q.offer(beginWord);
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i = 0; i < size; i++){
//                String cur = q.poll();
//                for(int j = 0; j < cur.length(); j++){
//                    StringBuilder sb = new StringBuilder(cur);
//                    for(char c = 'a'; c <= 'z'; c++){
//                        sb.setCharAt(j, c);
//                        String tmp = sb.toString();
//                        if(set.contains(tmp)){
//                            if(tmp.equals(endWord)) return len;
//                            q.offer(tmp);
//                            set.remove(tmp);
//                        }
//                    }
//                }
//            }
//            len++;
//        }
//        return 0;
//    }


//    public int ladderLength (String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<>(wordList);
//        if (set.contains(beginWord)) {
//            set.remove(beginWord);
//        }
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        int res = 0;
//        while (!queue.isEmpty()) {
//            for (int k = 0; k < queue.size(); k++) {
//                String word = queue.poll();
//                if (word.equals(endWord)) {
//                    return res + 1;
//                }
//                for (int i = 0; i < word.length(); i++) {
//                    char[] wordChar = word.toCharArray();
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        wordChar[i] = ch;
//                        String newword = new String(wordChar);
//
//                        if (set.contains(newword)) {
//
//                            set.remove(newword);
//                            queue.offer(newword);
//                        }
//                    }
//                }
//            }
//            res++;
//        }
//        return 0;
//    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<>(wordList);
//        int res = 0;
//        HashSet<String> visited = new HashSet<>();
//        visited.add(beginWord);
//        while (!visited.contains(endWord)) {
//            HashSet<String> toAdd = new HashSet<>();
//            for (String visit: visited) {
//                for (int i = 0; i < visit.length(); i++) {
//                    char[] chars = visit.toCharArray();
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        chars[i] = ch;
//                        String word = new String(chars);
//                        if (set.contains(word)) {
//                            toAdd.add(word);
//                            set.remove(word);
//                        }
//                    }
//                }
//            }
//            res++;
//            if (toAdd.size() == 0) return 0;
//            visited = toAdd;
//        }
//        return res;
//
//    }
}
