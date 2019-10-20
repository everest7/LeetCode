package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Vincent
 * @Date 2019-07-05
 */
public class OpenTheLock752 {
    public static void main(String[] args) {
        OpenTheLock752 op = new OpenTheLock752();
        System.out.println(op.openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
//        System.out.println(op.openLock(new String[] {"8888"}, "0009"));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>();
        for (String s: deadends) {
            deadend.add(s);
        }
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String temp = q.poll();
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        String next = temp;
                        char[] st = next.toCharArray();
                        st[j] = (char) (((st[j] - '0') + k + 10) % 10 + '0' );
                        String dest = String.valueOf(st);
                        if (dest.equals(target)) return level;
                        if (deadend.contains(dest) || visited.contains(dest)) continue;
                        visited.add(dest);
                        q.offer(dest);
                    }
                }
            }
        }
        return -1;
    }
}
