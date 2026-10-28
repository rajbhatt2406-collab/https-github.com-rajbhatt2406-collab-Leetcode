import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        ip(s, ans, list2, "", 0, 0, "");
        return ans;
    }

    public void ip(String s, List<String> ans, List<String> list2,
                   String b, int index, int count, String address) {

        if (count == 4) {
            if (index == s.length()) {
                ans.add(address);
            }
            return;
        }

        if (index == s.length()) {
            return;
        }

        b = "";

        for (int i = index; i < s.length() && i < index + 3; i++) {
            b = b + s.charAt(i);

            // Leading zero check
            if (b.length() > 1 && b.charAt(0) == '0') {
                break;
            }

            // Value must not exceed 255
            if (Integer.parseInt(b) > 255) {
                break;
            }

            list2.add(b);

            String newAddress;
            if (count == 0) {
                newAddress = b;
            } else {
                newAddress = address + "." + b;
            }

            ip(s, ans, list2, "", i + 1, count + 1, newAddress);

            list2.remove(list2.size() - 1);
        }
    }
}