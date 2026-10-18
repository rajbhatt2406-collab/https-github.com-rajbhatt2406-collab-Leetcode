class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
         solve(nums,temp,ans);
         return ans;
    }
    void solve(int[] nums, List<Integer> temp,
           List<List<Integer>> ans) {

    if (temp.size() == nums.length) {
        ans.add(new ArrayList<>(temp));
        return;
    }

    for (int num : nums) {
        if (temp.contains(num)) continue;

        temp.add(num);
        solve(nums, temp, ans);
        temp.remove(temp.size() - 1);
    }
}
}