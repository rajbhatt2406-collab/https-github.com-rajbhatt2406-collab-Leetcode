class Solution {
    public int sortPermutation(int[] nums) {
             int ans =-1;
             if(sorted(nums)){
                return 0;
             }
             for(int i =0; i<nums.length; i++){
                if(i != nums[i]){
                    ans = ans& nums[i]; 
                }
             }
             return ans;
            
    }
    public boolean sorted(int []nums){
        boolean sorted = true;

for (int i = 1; i < nums.length; i++) {
    if (nums[i] < nums[i - 1]) {
        sorted = false;
        break;
    }
}
return sorted;
    }   
}