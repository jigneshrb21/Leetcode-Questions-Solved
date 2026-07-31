class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int rmax = height[n - 1];
        int lmax= height[0];
        int left = 1;
        int right = n - 2;
        int water = 0;
        while(left <= right){
            if(lmax < rmax){
                water += Math.max(0, lmax - height[left]);
                lmax = Math.max(lmax, height[left]);
                left++;
            }
            else{
                water += Math.max(0, rmax - height[right]);
                rmax = Math.max(rmax,height[right]);
                right--;
            }
        }
        return water;
    }
}