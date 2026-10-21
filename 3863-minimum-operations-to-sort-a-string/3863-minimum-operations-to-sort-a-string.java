class Solution {
    public int minOperations(String s) {
        char mn = s.charAt(0);
        char mx = s.charAt(0);

        if (isSorted(s)) {
            return 0;
        }

        if (s.length() == 2) {
            return -1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < mn) {
                mn = s.charAt(i);
            }
            if (s.charAt(i) > mx) {
                mx = s.charAt(i);
            }
        }

        if (s.charAt(0) == mn || s.charAt(s.length() - 1) == mx) {
            return 1;
        }

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                return 2;
            }
        }

        return 3;
    }

    public boolean isSorted(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}