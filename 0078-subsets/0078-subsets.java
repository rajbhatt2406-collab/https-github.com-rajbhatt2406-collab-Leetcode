class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
          subsets(nums,0,list,l);
          return list;
    }
    public void subsets(int[] nums, int i,
                    List<List<Integer>> list,
                    List<Integer> l) {

    if (i == nums.length) {
        list.add(new ArrayList<>(l));
        return;
    }

    
    subsets(nums, i + 1, list, l);

    
    l.add(nums[i]);
    subsets(nums, i + 1, list, l);
     l.remove(l.size() - 1);
    
    }

}