class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums,target,0,0);
    }
    public int find(int[] nums, int target, int sum, int index){
         if (index == nums.length) {
        return sum == target ? 1 : 0;
    }

    int add = find(nums, target, sum + nums[index], index + 1);
    int subtract = find(nums, target, sum - nums[index], index + 1);

    return add + subtract;
    }
}