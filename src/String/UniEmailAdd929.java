package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniEmailAdd929 {
    public static void main(String[] args) {
        String[] input = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "st.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        UniEmailAdd929 ue = new UniEmailAdd929();
        System.out.println(ue.numUniqueEmails(input));
    }
//    public int numUniqueEmails(String[] emails){
//        HashSet<String> set = new HashSet<>();
//        for (String email: emails){
//            int index = email.indexOf("@");
//            String domain = email.substring(index);
//            set.add(domain);
//        }
//        return set.size();
//    }
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String s: emails){
            String[] split = s.split("@");
            String local = split[0].replaceAll(".", "");
            int flag = local.indexOf("+");
            if (flag != -1){
                local = local.substring(0, flag);
            }
            set.add(local + "@" + split[1]);
        }
        return set.size();
    }
}
