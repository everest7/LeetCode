package Greedy;

import java.util.Arrays;

public class AssignCookies455 {
    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        AssignCookies455 ac = new AssignCookies455();
        System.out.println(ac.findContentChildren(g, s));
    }
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int pointerG = 0;
        int pointerS = 0;
        while (pointerG < g.length && pointerS < s.length){
            if (g[pointerG] <= s[pointerS]){
                pointerG++;
                pointerS++;
            } else {
                pointerS++;
            }
        }
        return pointerG;
    }

//    public int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int j = 0;
//        for (int i = 0; j < g.length && i < s.length; i++){
//            if (g[j] <= s[i]){
//                j++;
//            }
//        }
//        return j;
//
//    }
}
