package Backtracking;

import java.util.*;

public class LetterCasePermutation784 {
    public static void main(String[] args) {
        String S = "a1b2";
        LetterCasePermutation784 lc = new LetterCasePermutation784();
        System.out.println(lc.letterCasePermutation(S));
    }

    // Depth First Search
    public List<String> letterCasePermutation(String S){
        if (S == null){
            return new LinkedList<>();
        }
        Set<String> res = new HashSet<>();
        helper(S.toCharArray(), res, 0);
        List<String> list = new ArrayList<>();
        list.addAll(res);
        return list;

    }
    public void helper(char[] chars, Set<String> res, int pos){
        if (pos == chars.length){
            res.add(new String(chars));
            return;
        }
        if (Character.isDigit(pos)){
            helper(chars, res, pos + 1);
            return;
        }
        chars[pos] = Character.toLowerCase(chars[pos]);
        helper(chars, res, pos + 1);

        chars[pos] = Character.toUpperCase(chars[pos]);
        helper(chars, res, pos + 1);

    }

    // Breadth First Search
    // Check first letter, and all permutations of first letter
    // Then check the second letter, and so on
//    public List<String> letterCasePermutation(String S){
//        if (S == null){
//            return new LinkedList<>();
//        }
//        Queue<String> queue = new LinkedList<>();
//        ((LinkedList<String>) queue).add(S);
//        for (int i = 0; i < S.length(); i++){
//            if (Character.isAlphabetic(S.charAt(i))){
//                int size = queue.size();
//                for (int j = 0; j < size; j++){
//                    String word = queue.poll();
//                    char[] chars = word.toCharArray();
//                    chars[i] = Character.isUpperCase(chars[i]) ? Character.toLowerCase(chars[i]) :
//                            Character.toUpperCase(chars[i]);
//                    ((LinkedList<String>) queue).add(new String(chars));
//                    chars[i] = Character.isLowerCase(chars[i]) ? Character.toUpperCase(chars[i]) :
//                            Character.toLowerCase(chars[i]);
//                    ((LinkedList<String>) queue).add(new String(chars));
//                }
//            }
//
//        }
//        return new ArrayList<>(queue);
//
//    }

//    public List<String> letterCasePermutation(String S) {
//        List<String> res = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        char[] word = S.toCharArray();
//        for (int i = 0; i < word.length; i++){
//            char letter = word[i];
//            if (Character.isAlphabetic(letter)){
//                word[i] = Character.isUpperCase(letter) ? Character.toLowerCase(letter) :
//                        Character.toUpperCase(letter);
//            }
//            set.add(new String(word));
//            word[i] = letter;
//        }
//        res.addAll(set);
//        return res;
//    }
}
