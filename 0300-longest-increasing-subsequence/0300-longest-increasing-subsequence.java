class Solution {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int ans = 1;

        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, subseq(nums, i, dp));
        }

        return ans;
    }

    public int subseq(int[] nums, int index, int[] dp){

        if(dp[index] != -1)
            return dp[index];

        int ans = 1;

        for(int j = index + 1; j < nums.length; j++){

            if(nums[j] > nums[index]){
                ans = Math.max(ans, 1 + subseq(nums, j, dp));
            }
        }

        dp[index] = ans;

        return ans;
    }
}