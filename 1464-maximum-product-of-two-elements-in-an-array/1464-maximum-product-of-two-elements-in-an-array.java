class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int  multi =0;
        
        
        for(int i =0; i<n-1 ; i++){
            for(int j =i;j<n ; j++ ){
              if(multi < (nums[i]-1)*(nums[j]-1) && i != j) {
                multi = (nums[i]-1)*(nums[j]-1);
              }
            }
        }
        return multi; 
    }
}