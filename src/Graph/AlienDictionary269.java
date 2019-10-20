package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-07-30
 */
public class AlienDictionary269 {
    public static void main(String[] args) {
        AlienDictionary269 ad = new AlienDictionary269();
        System.out.println(ad.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }

    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(words, graph, indegree);
        return bfs(graph, indegree);
    }

    public String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char ch : graph.keySet()) {
            if (indegree[ch - 'a'] == 0) {
                q.offer(ch);
            }
        }
        while (!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);
            for (char neighbor: graph.get(ch)) {
                indegree[neighbor - 'a']--;
                if (indegree[neighbor - 'a'] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }

    public void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] indegree) {
        for (String word: words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                char out = first.charAt(j);
                char in = second.charAt(j);
                if (out != in) {
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        indegree[in - 'a']++;
                    }
                    break;
                }
            }
        }
    }
}
