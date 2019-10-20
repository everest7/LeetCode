package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-07-30
 */
public class AccountsMerge721 {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> l2 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> l3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> l4 = Arrays.asList("Mary", "mary@mail.com");
        List<List<String>> accounts = Arrays.asList(l1, l2, l3, l4);
        AccountsMerge721 am = new AccountsMerge721();
        System.out.println(am.accountsMerge(accounts));
    }
    /**
     * Union Find
     * View each email as a node. parent[] is initially set to itself.
     * For each cluster, pick a representative(first email) as the parent of all other nodes.
     * Using Map<representative, Set<Cluster>> to denote each component.
     * Traverse all the email, first find the parent of each email, if it does not exist in the map, meaning it's newly
     * discovered, create a new TreeSet<> for it to store its siblings. Otherwise, just add it to the set.
     * Using TreeSet<> can not only avoid duplicate but also sort the email as requested.
     *
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, Set<String>> union = new HashMap<>();
        Map<String, String> mailToName = new HashMap<>();
        for (List<String> account: accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                parent.put(account.get(i), account.get(i));
                mailToName.put(account.get(i), name);
            }
        }
        for (List<String> account: accounts) {
            String par = find(account.get(1), parent);
            for (int i = 2; i < account.size(); i++) {
                parent.put(find(account.get(i), parent), par);
            }
        }
        for (List<String> account: accounts) {
            String par = find(account.get(1), parent);
            if (!union.containsKey(par)) union.put(par, new TreeSet<>());
            for (int i = 1; i < account.size(); i++) {
                union.get(par).add(account.get(i));
            }
        }
        for (String s: union.keySet()) {
            List<String> tmp = new ArrayList<>(union.get(s));
            tmp.add(0, mailToName.get(s));
            res.add(tmp);
        }
        return res;

    }

    public String find(String s, Map<String, String> parent) {
        if (s.equals(parent.get(s))) {
            return s;
        }
        return find(parent.get(s), parent);
    }


    /**
     * DFS
     * View each email as a vertex in graph. Using DFS to find those vertices that are in the same component and
     * merge them into the result.
     * @param accounts
     * @return
     */
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        List<List<String>> res = new ArrayList<>();
//        Map<String, String> mailToName = new HashMap<>();
//        Map<String, Set<String>> graph = new HashMap<>();
//        for (List<String> list: accounts) {
//            for (int i = 1; i < list.size(); i++) {
//                if (!graph.containsKey(list.get(i))) {
//                    graph.put(list.get(i), new HashSet<>());
//                }
//                mailToName.put(list.get(i), list.get(0));
//                if (i == 1) continue;
//                graph.get(list.get(i)).add(list.get(i - 1));
//                graph.get(list.get(i - 1)).add(list.get(i));
//            }
//        }
//        Set<String> visited = new HashSet<>();
//        for (String mail: graph.keySet()) {
//            if (visited.add(mail)) {
//                List<String> sub = new ArrayList<>();
//                dfs(graph, sub, visited, mail);
//                Collections.sort(sub);
//                sub.add(0, mailToName.get(mail));
//                res.add(sub);
//            }
//        }
//        return res;
//    }
//
//    public void dfs(Map<String, Set<String>> graph, List<String> sub, Set<String> visited, String mail) {
//        sub.add(mail);
//        for (String next : graph.get(mail)) {
//            if (visited.add(next)) {
//                dfs(graph, sub, visited, next);
//            }
//        }
//
//    }
}
