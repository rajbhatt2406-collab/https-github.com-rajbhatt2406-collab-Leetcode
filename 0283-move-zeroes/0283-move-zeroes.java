class Solution {
    public void moveZeroes(int[] nums) {
       int right = nums.length;
       for(int i =0; i< right; i++){
        if(nums[i] == 0){
            shiftLeft(nums, i);
            right --;
            i--;
        }
       } 
       

    }
     public void shiftLeft(int[] nums, int index){
        for(int i=index; i<nums.length-1;i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length -1] = 0;
     }
}