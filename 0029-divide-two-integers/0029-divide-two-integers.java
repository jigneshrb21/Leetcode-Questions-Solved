class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;

        boolean isPositive = true;
        
        if(dividend >= 0 && divisor < 0) 
            isPositive = false;
        else if(dividend <= 0 && divisor > 0)
            isPositive = false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;
        while ( n >= d){
            int cnt = 0;
            while( n >= (d << (cnt + 1))){
                cnt++;
            }
            ans += (1 << cnt);
            n -= (d << cnt);
        }
        if (ans == (1<<31) && isPositive) return Integer.MAX_VALUE;
        if (ans == (1<<31) && !isPositive) return Integer.MIN_VALUE;

        return isPositive ? ans : -ans;
    }
    
}