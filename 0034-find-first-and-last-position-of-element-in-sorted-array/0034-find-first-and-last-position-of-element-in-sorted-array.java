class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccur(nums,target);

        if(first == -1){
            return new int[]{-1,-1};
        }

        int last = lastOccur(nums,target);

        return new int[]{first,last};
    }
    private int firstOccur(int[] nums, int target){
        int low = 0;
        int first = -1;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }
    private int lastOccur(int[] nums, int target){
        int low = 0;
        int last = -1;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }
}