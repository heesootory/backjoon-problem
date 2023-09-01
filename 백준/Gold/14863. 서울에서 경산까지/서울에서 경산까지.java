import java.io.*;
import java.util.*;


public class Main {
    static int INF = Integer.MIN_VALUE;
    static int N, K;
    static int[][] arr;
    static int[][] dp;
    static int dfs(int n, int k){
        if(k < 0) return INF;
        if(n == 0) return 0;
        if(dp[n][k] != -1) return dp[n][k];

        dp[n][k] = Math.max(dfs(n - 1, k - arr[n][2]) + arr[n][3], dfs(n - 1, k - arr[n][0]) + arr[n][1]);
        
        return dp[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][4];
        dp = new int[101][100001];
        for(int i = 0; i < N + 1; i++) Arrays.fill(dp[i], -1);

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(N, K));

//        for(int i = 0; i < N + 1; i++){
//            for(int j = 0; j < K + 1; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}
