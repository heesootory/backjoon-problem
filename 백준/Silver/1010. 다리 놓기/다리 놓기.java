import java.io.*;
import java.util.*;

public class Main{
    static int T, N, M;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new int[N + 1][M + 1];
            for(int i = 1; i < M + 1; i++) dp[1][i] = i;

            for(int i = 2; i < N + 1; i++){
                for(int j = 1; j < M + 1; j++){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
            }
            System.out.println(dp[N][M]);
        }

    }
}