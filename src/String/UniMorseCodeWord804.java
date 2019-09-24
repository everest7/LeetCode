package String;

import java.util.HashSet;

public class UniMorseCodeWord804 {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        UniMorseCodeWord804 um = new UniMorseCodeWord804();
        System.out.println(um.uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] letter = {".-","-...","-.-.","-..",".","..-.","--.","....",
                "..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                "...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String word: words){
            String sb = "";
            for (char ch: word.toCharArray()){
                sb += letter[ch - 'a'];
            }
            set.add(sb);
        }
        return set.size();
    }
}
