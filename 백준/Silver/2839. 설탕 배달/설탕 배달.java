import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[5001];
        Arrays.fill(dp, 987654321);
        dp[3] = 1;
        dp[5] = 1;

        for(int i = 6; i <= N; i++){
            dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
        }

        System.out.println(dp[N] >= 987654321 ? -1 : dp[N]);
    }
}