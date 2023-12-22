import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] arr;
    static int[][] dp;
    static int dfs(int s, int e){
        if(e <= s) return dp[s][e] = 1;

        if(dp[s][e] != 0) return dp[s][e];

        int cache = 0;
        if(dfs(s + 1, e - 1) == 1 && arr[s] == arr[e]) cache = 1;
        else cache = -1;

        return dp[s][e] = cache;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];        // 초기화 0 , 팰린드롬O ? 1 : -1

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dfs(s, e) == 1 ? 1 : 0);
            sb.append("\n");
        }

        System.out.println(sb);

//        for(int i = 0; i < N + 1; i++){
//            for(int j = 0; j < N + 1; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}