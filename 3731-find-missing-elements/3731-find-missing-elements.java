class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
         ArrayList<Integer> list1 = new ArrayList<>();
        Arrays.sort(nums);
        for (int x : nums) {
          list.add(x);
}

        for(int j= nums[0] +1;  j< nums[nums.length -1]; j++){
            if (!list.contains(j)){
                 list1.add(j);
            }
            
            
            
        }
        return list1;
    }

}