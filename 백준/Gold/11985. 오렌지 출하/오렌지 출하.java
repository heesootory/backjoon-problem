import java.io.*;
import java.util.*;


public class Main {
    static int N, M, K;
    static int[] arr;
    static long[][] dp;
    static long cal(int n, int m){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = n; i > n - m; i--){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        return K + (long)m * (max - min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new long[N + 1][M + 1];
        for(int i = 1; i < N + 1; i++) Arrays.fill(dp[i], Long.MAX_VALUE);

        for(int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < M + 1; j++){
                if(i < j) break;

                long min = Long.MAX_VALUE;
                for(int k = 1; k < M + 1; k++) min = Math.min(min, dp[i - j][k]);
                long parcel = cal(i, j);

                dp[i][j] = min + parcel;
            }
        }

        long ans = Long.MAX_VALUE;
        for(int i = 1; i < M + 1; i++) ans = Math.min(ans, dp[N][i]);
        System.out.println(ans);

    }

}
