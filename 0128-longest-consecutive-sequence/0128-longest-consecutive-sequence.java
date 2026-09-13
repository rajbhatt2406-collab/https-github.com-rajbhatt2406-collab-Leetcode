class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        if(n==0){
            return 0;
        }
        for(int i =0; i<n; i++){
            pq.add(nums[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
              list.add (pq.poll());
        }
        int count = 1;
int max = 1;

for (int i = 1; i < list.size(); i++) {

    int k = list.get(i) - list.get(i - 1);

    if (k == 1) {
        count++;
        max = Math.max(max, count);
    } else if (k != 0) {
        count = 1;
    }
}

return max;
    }
}