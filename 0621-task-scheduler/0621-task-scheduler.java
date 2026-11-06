class Solution {
    public int leastInterval(char[] tasks, int n) {
         List<Integer> list = new ArrayList<>();
         HashMap<Character, Integer> map = new HashMap<>(); 
           for (char s : tasks) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int maxFreq = 0;
        int count = 0;

        // Find maximum frequency
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Count elements having maximum frequency
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                count++;
            }
        }
       int ans = Math.max((maxFreq -1)*(n+1) + count , tasks.length);
       return ans;


    }
}