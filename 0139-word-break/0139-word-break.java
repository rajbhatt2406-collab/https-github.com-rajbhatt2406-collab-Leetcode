
import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        Boolean[] dp = new Boolean[s.length()];

        return solve(s, 0, set, dp);
    }

    boolean solve(String s, int index, Set<String> set, Boolean[] dp) {

        // Base case
        if (index == s.length()) {
            return true;
        }

        // Already calculated?
        if (dp[index] != null) {
            return dp[index];
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);

            if (set.contains(word)) {
                if (solve(s, i, set, dp)) {
                    return dp[index] = true;
                }
            }
        }

        return dp[index] = false;
    }
}
