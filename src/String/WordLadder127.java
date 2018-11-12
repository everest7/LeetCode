package String;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        WordLadder127 wl = new WordLadder127();
        System.out.println(wl.ladderLength(beginWord, endWord, wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Stack> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        List<String> created_word = new ArrayList<>();
        created_word.add(beginWord);
        stack.push(beginWord);
        ((LinkedList<Stack>) queue).push(stack);
        int res = 0;
        while (!queue.isEmpty()){
            Stack top_stack = queue.poll();
            String word = top_stack.peek().toString();

            for (int j = 0; j < word.length(); j++){
                for (char i = 'a'; i < 'z'; i++){
                    if (i != word.charAt(j)){
                        String new_word = word.replace(word.charAt(j), i);
                        if (wordList.contains(new_word) && !created_word.contains(new_word)){
                            created_word.add(new_word);
                            Stack<String> new_stack = (Stack<String>)top_stack.clone();
                            new_stack.push(new_word);
                            if (word == endWord){
                                return top_stack.size();
                            }
                            ((LinkedList<Stack>) queue).push(new_stack);
//                            if (queue.isEmpty()){
//                                return 0;
//                            }
                        }

                    }
                }
            }
            res++;
        }
        return res;
    }

}
