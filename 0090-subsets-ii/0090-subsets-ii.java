class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(0, nums, ans, ds);
        return ans;
    }
    public void helper(int start, int[] nums, List<List<Integer>> list, List<Integer> ds){
        list.add(new ArrayList<>(ds));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            helper(i+1, nums,list,ds);
            ds.remove(ds.size() - 1);
        }
    }
}