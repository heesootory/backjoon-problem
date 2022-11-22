import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        dp = new int[4][10001];
        dp[1][1] = 1;
        dp[1][2] = dp[2][2] = 1;
        dp[1][3] = dp[2][3] = dp[3][3] = 1;

        for(int t = 0 ; t < T; t++){
            N = Integer.parseInt(br.readLine());

            for(int i = 4; i <= N; i++){
                dp[1][i] = dp[1][i-1];
                dp[2][i] = dp[1][i-2] + dp[2][i-2];
                dp[3][i] = dp[1][i-3] + dp[2][i-3] + dp[3][i-3];
            }

            System.out.println(dp[1][N] + dp[2][N] + dp[3][N]);
        }

    }
}