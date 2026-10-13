class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i =0; i<nums.length; i++){
            if(nums[i]<0){
                nums[i] = nums[i] * -1;
            }
            else{
                nums[i] = nums[i];
            }
        }
         Arrays.sort(nums);
         long max =0;
         int m = nums.length /2;
         for(int i=0; i<nums.length; i++){
            if(i<m){
                max = max - nums[i]*nums[i];
            }
            else{
                max = max + nums[i]*nums[i];
            }
         }
         return max;
    }
}