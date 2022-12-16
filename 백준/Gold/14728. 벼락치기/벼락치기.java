import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[][] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][2];
        dp = new int[N + 1][T + 1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < T + 1; j++){
                if(j - arr[i][0] >= 0) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][T]);

    }
}