import java.io.*;
import java.util.*;

public class Main {
    static int mod = 10007;
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        for(int j = 0; j < 10; j++) dp[1][j] = 1;
        for(int i = 0; i <= N; i++) dp[i][0] = 1;

        for(int i = 2; i <= N; i++){
            for(int j = 1; j < 10; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }

        long ans = 0;
        for(long i : dp[N]) {
            ans += i;
            ans %= mod;
        }
        System.out.println(ans % mod);

    }
}