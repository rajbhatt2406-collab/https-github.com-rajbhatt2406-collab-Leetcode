class Solution {
    public String longestPalindrome(String s) {
    int n = s.length();
    int max = 0;
    String answer = "";

    for (int left = 0; left < n; left++) {

        for (int right = left; right < n; right++) {

            if (palin(s, left, right)) {

                if (right - left + 1 > max) {
                    max = right - left + 1;
                    answer = s.substring(left, right + 1);
                }
            }
        }
    }

    return answer;
}

public boolean palin(String s, int left, int right) {

    while (left < right) {

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}
}