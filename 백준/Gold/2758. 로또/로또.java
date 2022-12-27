import java.io.*;
import java.util.*;


public class Main {
    static int T, N, M;
    static Long[][] dp;
    static long dfs(int idx, int num){
        if(num < 0) return 0;
        if(idx <= 1) return num;

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
        // dp배열의 초기화가 필요.
//        for(int i = 0; i < 2001; i++) dp[1][i] = (long)i;

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(dfs(N, M));

        }
    }
}