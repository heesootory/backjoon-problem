import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dp[from][to] = (dp[from][to] == 0) ? cost : Math.min(dp[from][to], cost);
        }

        for(int k = 1; k < N + 1; k++){
            for(int s = 1; s < N + 1; s++){
                for(int e = 1; e < N + 1; e++){
                    if(s == e) continue;
                    if(dp[s][k] != 0 && dp[k][e] != 0){
                        int sum = dp[s][k] + dp[k][e];
                        dp[s][e] = (dp[s][e] == 0) ? sum : Math.min(dp[s][e], sum);
                    }
                }
            }
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}