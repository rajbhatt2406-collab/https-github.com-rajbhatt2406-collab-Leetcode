class Solution {
   
         public int minSubArrayLen(int target, int[] nums) {

    int left = 0;
    int sum = 0;
    int minLength = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {

        // Add current element to window
        sum += nums[right];

        // If sum >= target, try to shrink the window
        while (sum >= target) {

            minLength = Math.min(minLength, right - left + 1);

            sum -= nums[left];
            left++;
        }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }
}