import java.io.*;
import java.util.*;

/**
 * DP 상향식
 */

public class Main {
    static int N, K;
    static int[][] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K + 1][2];

        for(int k = 1; k < K + 1; k++){
            st = new StringTokenizer(br.readLine());
            arr[k][1] = Integer.parseInt(st.nextToken());
            arr[k][0] = Integer.parseInt(st.nextToken());
        }

        dp = new int[K + 1][N + 1];
        for(int i = 1; i < K + 1; i++){
            for(int j = 0; j < N + 1; j++){
                int nt = arr[i][0];
                if(j < nt) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j - nt] + arr[i][1], dp[i-1][j]);
            }
        }
        System.out.println(dp[K][N]);

    }
}