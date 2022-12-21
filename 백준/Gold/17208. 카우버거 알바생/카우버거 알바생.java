import java.io.*;
import java.util.*;


public class Main {
    static int N, M, K;
    static int[][] order;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        order = new int[N + 1][2];
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1][M + 1][K + 1];

        for(int k = 1; k < N + 1; k++){
            int new_burger = order[k][0];
            int new_potato = order[k][1];
            for(int i = 0; i < M + 1; i++){
                for(int j = 0; j < K + 1; j++){
                    if(i >= new_burger && j >= new_potato)
                        dp[k][i][j] = Math.max((dp[k-1][i-new_burger][j-new_potato] + 1), dp[k-1][i][j]);
                    else
                        dp[k][i][j] = dp[k-1][i][j];
                }
            }
        }

        System.out.println(dp[N][M][K]);
    }
}