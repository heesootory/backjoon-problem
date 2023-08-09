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
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());
            dp[big][small] = 1;
            dp[small][big] = -1;
        }

        for(int k = 1; k < N + 1; k++){
            for(int s = 1; s < N + 1;s++){
                for(int e = 1; e < N + 1; e++){
                    if(s == e) continue;
                    if(dp[s][k] == 1 && dp[k][e] == 1) {
                        dp[s][e] = 1; dp[e][s] = -1;
                    }
                }
            }
        }

        for(int i = 1; i < N + 1; i++){
            int cnt = 0;
            for(int j = 1; j < N + 1; j++){
                if(i != j && dp[i][j] == 0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}