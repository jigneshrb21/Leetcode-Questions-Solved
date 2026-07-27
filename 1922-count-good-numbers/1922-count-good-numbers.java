class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long ans = (power(5,even) * power(4,odd)) % MOD;
        return (int) ans;
        
    }
    private long power(long x, long n) {
    if (n == 0) return 1;

    if (n % 2 == 0) {
        return power((x * x) % MOD, n / 2);
    }

    return (x * power((x * x) % MOD, n / 2)) % MOD;
}
}