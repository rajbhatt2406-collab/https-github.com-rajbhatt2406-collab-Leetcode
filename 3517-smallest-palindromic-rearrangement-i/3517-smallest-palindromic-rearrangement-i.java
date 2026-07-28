import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        StringBuilder a = new StringBuilder();

        if (n == 1) {
            return s;
        }

        if (n % 2 == 0) {

            // Sort first half
            Arrays.sort(arr, 0, n / 2);

            // First half
            for (int i = 0; i < n / 2; i++) {
                a.append(arr[i]);
            }

            // Reverse of first half
            for (int j = n / 2 - 1; j >= 0; j--) {
                a.append(arr[j]);
            }

        } else {

            // Sort first half
            Arrays.sort(arr, 0, n / 2);

            // First half
            for (int i = 0; i < n / 2; i++) {
                a.append(arr[i]);
            }

            // Middle character
            a.append(s.charAt(n / 2));

            // Reverse of first half
            for (int j = n / 2 - 1; j >= 0; j--) {
                a.append(arr[j]);
            }
        }

        return a.toString();
    }
}