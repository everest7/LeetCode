package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindReplacePattern890 {
    public static void main(String[] args) {
        FindReplacePattern890 fp = new FindReplacePattern890();
        String[] s = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(fp.findAndReplacePattern(s,pattern));
    }
    // Using two map
    // 1. Mapping the char in the word to its corresponding position in the pattern
    // 2. Mapping the char in the pattern to its corresponding position in the word
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words){
            if (match(word,pattern)){
                res.add(word);
            }
        }
        return res;

    }
    private boolean match(String word, String pattern){
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            char pt = pattern.charAt(i);
            if (!map1.containsKey(ch)){
                map1.put(ch,pt);
            }
            if (!map2.containsKey(pt)){
                map2.put(pt,ch);
            }
            if (map1.get(ch) != pt || map2.get(pt) != ch){
                return false;
            }

        }
        return true;

    }
}
