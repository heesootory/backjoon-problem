import java.io.*;
import java.util.*;

public class Main{
    static final int mod = 1000000000;
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new long[101][10];  // 0 ~ 9까지

        dp[1][0] = 0;
        for(int i = 1; i < 10; i++) dp[1][i] = 1;

        for(int i = 2; i <= N; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for(int j = 1; j < 9; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; i++) sum += dp[N][i];
        System.out.println(sum % mod);

    }
}