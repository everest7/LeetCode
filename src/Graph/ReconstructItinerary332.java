package Graph;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-06
 */
public class ReconstructItinerary332 {
    public static void main(String[] args) {
        ReconstructItinerary332 ri = new ReconstructItinerary332();
        List<List<String>> tickets = new ArrayList<>();
        List<String> one = Arrays.asList("JFK", "ATL");
        List<String> two = Arrays.asList("JFK", "SFO");
        List<String> three = Arrays.asList("SFO", "ATL");
        List<String> four = Arrays.asList("ATL", "JFK");
        List<String> five = Arrays.asList("ATL", "SFO");
        tickets.add(one);
        tickets.add(two);
        tickets.add(three);
        tickets.add(four);
        tickets.add(five);
        System.out.println(ri.findItinerary(tickets));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (List<String> sub : tickets) {
            if (!map.containsKey(sub.get(0))) {
                map.put(sub.get(0), sub.get(1));
            } else {
                if (sub.get(1).compareTo(map.get(sub.get(0))) < 0) {
                    map.put(sub.get(0), sub.get(1));
                }
            }
        }
        String start = "JFK";
        res.add(start);
        while (!map.isEmpty()) {
            String dest = map.get(start);
            res.add(dest);
            map.remove(start);
            start = dest;
        }
        return res;
    }
}
