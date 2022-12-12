import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] dp;
    static final int INF = 123456789;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++){
                if(i != j) dp[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(cost < dp[start][end]) dp[start][end] = cost;
        }

        // 플로이드-워셜
        for(int k = 1; k < n + 1; k++){     // 경
            for(int i = 1; i < n + 1; i++){     // 출
                for(int j = 1; j < n + 1; j++){     // 도
                    dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                }
            }
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(dp[i][j] == INF) dp[i][j] = 0;
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


    }
}