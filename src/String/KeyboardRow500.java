package String;

import java.lang.reflect.Array;
import java.util.*;

public class KeyboardRow500 {
    public static void main(String[] args) {
        KeyboardRow500 kb = new KeyboardRow500();
        String[] input = new String[] {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.asList(kb.findWords(input)));

    }
    // Using HashSet
    public String[] findWords(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        Character[] stringRow1 = new Character[] {'q','w','e','r','t','y','u','i','o','p'};
        Character[] stringRow2 = new Character[] {'a','s','d','f','g','h','j','k','l'};
        Character[] stringRow3 = new Character[] {'z','x','c','v','b','n','m'};
        Set<Character> row1 = new HashSet<>(Arrays.asList(stringRow1));
        Set<Character> row2 = new HashSet<>(Arrays.asList(stringRow2));
        Set<Character> row3 = new HashSet<>(Arrays.asList(stringRow3));
        for (String word : words){
            int one = 0, two = 0, three = 0;
            for (char ch : word.toLowerCase().toCharArray()){
                if (row1.contains(ch)){
                    one = 1;
                }
                if (row2.contains(ch)){
                    two = 1;
                }
                if (row3.contains(ch)){
                    three = 1;
                }
                if (one + two + three > 1) break;

            }
            if (one + two + three == 1){
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);

    }

}
