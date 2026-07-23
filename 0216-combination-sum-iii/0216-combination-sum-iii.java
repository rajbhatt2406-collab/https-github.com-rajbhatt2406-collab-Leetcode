class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
         backtrack(arr, n,k, 0, new ArrayList<>());

        return ans;
        
    }
     void backtrack(int[] nums, int target,int k, int start, ArrayList<Integer> current){

        if(target == 0 && k==0){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < nums.length; i++){

            // Skip duplicates
            if(i > start && nums[i] == nums[i-1])
                continue;

            // Since the array is sorted, no need to continue
            if(nums[i] > target)
                break;

            current.add(nums[i]);

            backtrack(nums, target - nums[i],k-1, i + 1, current);

            current.remove(current.size() - 1);
            
        }
    }
}