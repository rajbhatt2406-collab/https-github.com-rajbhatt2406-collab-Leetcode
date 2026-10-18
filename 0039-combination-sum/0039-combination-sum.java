class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    solve(candidates, temp, ans, target, 0);
    return ans;
}

void solve(int[] nums, List<Integer> temp,
           List<List<Integer>> ans, int target, int i) {

    if (target == 0) {
        ans.add(new ArrayList<>(temp));
        return;
    }

    if (i == nums.length || target < 0) {
        return;
    }


    temp.add(nums[i]);
    solve(nums, temp, ans, target - nums[i], i);

   
    temp.remove(temp.size() - 1);

   
    solve(nums, temp, ans, target, i + 1);
}
}