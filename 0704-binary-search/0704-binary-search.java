class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return func(nums,0,n - 1, target);
        // int low = 0;
        // int high = n - 1;
        // while(low <= high){
        //     int mid = low + (high - low) / 2;
        //     if(nums[mid] == target){
        //         return mid;
        //     }
        //     else if(nums[mid] < target){
        //         low = mid + 1;
        //     }
        //     else{
        //         high = mid - 1;
        //     }
        // }
        // return -1;
        
    }
    private int func(int[] nums, int low, int high, int target){
        if(low > high) return -1;
        int ind;
        int mid = low + (high - low) / 2;
        if(nums[mid] == target) ind = mid;
        else if(nums[mid] < target) ind = func(nums,mid + 1,high,target);
        else ind = func(nums,low,mid - 1,target);
        return ind;
    }
}