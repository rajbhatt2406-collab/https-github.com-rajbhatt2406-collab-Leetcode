class Solution {
    public boolean predictTheWinner(int[] nums) {
        
        int scoreFirst = predictTheWinnerFrom(nums, 0, nums.length - 1);
        int scoreTotal = getTotalScores(nums);
        
        // Compare final scores of two players.
        return scoreFirst >= scoreTotal - scoreFirst;
    }
    
    public int predictTheWinnerFrom(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return nums[i];
        }
        
        int curScore = Math.max(
            nums[i] + Math.min(
                predictTheWinnerFrom(nums, i + 2, j), 
                predictTheWinnerFrom(nums, i + 1, j - 1)
            ),
            nums[j] + Math.min(
                predictTheWinnerFrom(nums, i, j - 2), 
                predictTheWinnerFrom(nums, i + 1, j - 1)
            )
        );   
        return curScore;
    }
    
    private int getTotalScores (int[] nums) {
        int scoreTotal = 0;
        for (int num : nums) {
            scoreTotal += num;
        }
        
        return scoreTotal;
    }
}