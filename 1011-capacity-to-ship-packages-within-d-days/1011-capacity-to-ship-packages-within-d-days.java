class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int x : weights){
            sum += x;
            maxi = Math.max(maxi, x);
        }
        int low = maxi;
        int high = sum;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            int cnt = countdays(weights,days,mid);
            if(cnt <= days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        } 
        return ans;
    }
    public int countdays(int[] nums, int days, int capa){
        int n = nums.length;
        int cntdays = 1;
        int capacity = 0;
        for(int i = 0; i < n; i++){
            if(capacity + nums[i] <= capa){
                capacity += nums[i];
            }
            else{
                cntdays++;
                capacity = nums[i];
            }
        }
        return cntdays;

    }
}