import java.io.*;
import java.util.*;


public class Main {
    static int T, N, M;
    static Long[][] dp;
    static long dfs(int idx, int num){
        if(num < 0) return 0;

       if(dp[idx][num] != null) return dp[idx][num];

       dp[idx][num] = 0L;
       dp[idx][num] = dfs(idx - 1, num / 2) + dfs(idx, num-1);
       return dp[idx][num];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        dp = new Long[11][2001];
        for(int i = 0; i < 2001; i++) dp[1][i] = (long)i;

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(dfs(N, M));

//            for(int i = 1; i < N + 1; i++){
//                for(int j = 1; j < M + 1; j++){
//                    if(dp[i][j] == null) dp[i][j] = 0L;
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }

        }
    }
}