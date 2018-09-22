package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainCount811 {
    public static void main(String[] args) {
        SubdomainCount811 sc = new SubdomainCount811();
        String[] strings = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(sc.subdomainVisits(strings));

    }
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for (String cpd : cpdomains){
            int i = cpd.indexOf(" ");
            int n = Integer.valueOf(cpd.substring(0,i));
            String sb = cpd.substring(i+1);
            for (int j = 0; j < sb.length(); j++){
                if (sb.charAt(j) == '.'){
                    String st = sb.substring(j+1);
                    map.put(st,map.getOrDefault(st,0) + n);
                }
            }
            map.put(sb,map.getOrDefault(sb,0) + n);
        }
        List<String> res = new ArrayList<>();
        for (String s : map.keySet()){
            res.add(map.get(s) + " " + s);
        }
        return res;
    }
}
