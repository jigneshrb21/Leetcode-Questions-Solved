class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccur(nums,target);

        if(first == nums.length || nums[first] != target){
            return new int[]{-1,-1};
        }

        int last = lastOccur(nums,target) - 1;

        return new int[]{first,last};
    }
    private int firstOccur(int[] nums, int target){
        int low = 0;
        int first = nums.length;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] >= target){
                first = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return first;
    }
    private int lastOccur(int[] nums, int target){
        int low = 0;
        int last = nums.length;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > target){
                last = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return last;
    }
}