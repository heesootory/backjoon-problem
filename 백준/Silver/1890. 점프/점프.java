import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new long[N][N];
        arr = new int[N][N];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 상향식으로 작성.
        dp[0][0] = 1;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) continue;
                int jump = arr[i][j];
                if (i + jump < N) dp[i + jump][j] += dp[i][j];
                if (j + jump < N) dp[i][j + jump] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}