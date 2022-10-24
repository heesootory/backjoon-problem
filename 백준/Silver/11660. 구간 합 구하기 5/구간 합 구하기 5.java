import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int x1,y1,x2,y2;
    static int[][] arr;
    static int[][] dp;
    static void prefix_sum(){
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j< N + 1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        prefix_sum();

        for(int i = 0 ; i < M; i++){
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            ans = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            sb.append(ans + "\n");
        }
        System.out.println(sb);

    }
}