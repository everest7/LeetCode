package String;

/**
 * @author Vincent
 * @Date 2019-05-18
 */
public class ValidateIPAddress468 {
    public static void main(String[] args) {

    }
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public boolean isIPv4(String ip) {
        String[] adds = ip.split("\\.");
        if (adds.length != 4) return false;
        for (String add : adds) {
            // check if it starts with '0'
            int val = Integer.parseInt(add);
            if (!(val + "").equals(add)) {
                return false;
            }
            if (val < 0 || val > 255) return false;
            if (add.charAt(0) == '0' && add.length() != 1) return false;
        }
        return true;
    }

    public boolean isIPv6(String ip) {
        // check number of ':'
        int count = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == ':') count++;
        }
        if (count != 7) return false;
        String[] adds = ip.split(":");
        for (String add: adds) {
            if (add.length() > 4) return false;
            // Check if it starts with '0'
            if (add.length() > 1 && add.charAt(0) == '0' && add.charAt(1) == '0') return false;
            for (int i = 0; i < add.length(); i++) {
                char ch = add.charAt(i);
//                if(!((ch >= '0' && ch <= '9') || (ch>='a' && ch<='f') || (ch>='A' &&ch<='F'))) return false;
                if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' || ch <= 'F'))) {
                    return false;
                }

            }
        }
        return true;
    }
}
