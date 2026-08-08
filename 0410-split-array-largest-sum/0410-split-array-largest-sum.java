class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int high = 0;
        int low = Integer.MIN_VALUE;
        for(int i : nums){
            low = Math.max(low,i);

            high += i;
        }
        
        while(low <= high){
            int mid = (low + high) / 2;
            int cntk = countk(nums,k,mid);
            if(cntk <= k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private int countk(int[] nums, int k ,int largsum){
        int n = nums.length;
        int subarr = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(sum + nums[i] <= largsum){
                sum += nums[i];
            }
            else{
                subarr++;
                sum = nums[i];
            }
        }
        return subarr;
    }
}