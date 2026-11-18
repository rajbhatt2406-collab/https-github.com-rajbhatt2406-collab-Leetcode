
import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] last = new int[26];

        // Step 1: Store last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();

        int start = 0;
        int end = 0;

        // Step 2: Traverse the string
        for (int i = 0; i < s.length(); i++) {

            end = Math.max(end, last[s.charAt(i) - 'a']);

            // Step 3: Partition is complete
            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }
}
