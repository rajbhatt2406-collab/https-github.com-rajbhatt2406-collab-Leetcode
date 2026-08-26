class Solution {
    public int missingMultiple(int[] nums, int k) {
         int n = nums.length;
          
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i <n; i++){
            list.add(nums[i]);
        } 
        for(int j =1; j <=101; j++){
            if(!list.contains(k *j)){
                 return k*j ;
            }
        }
    return 0;
    }
}