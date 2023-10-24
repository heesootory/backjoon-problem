class Solution {
    static long[] dp;
    static long jump(int idx, int n){
        if(idx == n) return 1;
        else if(idx > n) return 0;
        
        if(dp[idx] != 0) return dp[idx];
        
        return dp[idx] = (jump(idx + 1, n) + jump(idx + 2, n)) % 1234567;
    }
    public long solution(int n) {
        dp = new long[n + 1];
        return jump(0, n);
    }
}