class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(count == 0) {
                count = 1;
                element = nums[i];
            }
            else if(element == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        int cnt = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] == element){
                cnt++;
            }
        }
        if(cnt > (n/2))
        {
            return element;
        }
        return -1;
    }
}