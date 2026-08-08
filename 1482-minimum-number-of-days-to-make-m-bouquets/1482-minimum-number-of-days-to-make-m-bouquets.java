class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length; 
        if((m*k) > bloomDay.length){
            return -1;
        }
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int ans = -1;
        for(int i = 0; i < n; i++){
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int low = mini;
        int high = maxi;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(calculate(bloomDay,m,k,mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean calculate(int[] nums, int m, int k, int day){
        int n = nums.length;
        int cnt = 0;
        int bouque = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] <= day){
                cnt++;
            }
            else{
                bouque += (cnt / k);
                cnt = 0;
            }
        }
        bouque += (cnt / k);
        return bouque >= m;
    }
    
}