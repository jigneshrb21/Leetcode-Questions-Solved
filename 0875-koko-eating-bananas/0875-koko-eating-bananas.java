class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int n = piles.length;
       int maxi = 0;
       for(int i = 0; i < n; i++){
            if(piles[i] > maxi){
                maxi = piles[i];
            }
       } 
       int low = 1;
       int high = maxi;
       while(low <= high){
            int mid = low + (high - low) / 2;
            int reqtime = calculatehrs(piles , mid);
            if(reqtime <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
            
       }
       return low;
    }
    private int calculatehrs(int[] nums, int h){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += Math.ceil((double) nums[i] / (double) h);
        }
        return (int) sum;
    }
}