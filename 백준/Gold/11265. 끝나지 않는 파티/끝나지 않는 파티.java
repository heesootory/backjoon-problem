import java.io.*;
import java.util.*;



public class Main{
    static int N, M;
    static int[][] timetable;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                dp[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k < N + 1; k++){
            for(int s = 1; s < N + 1; s++){
                for(int e = 1; e < N + 1; e++){
                    dp[s][e] = Math.min(dp[s][k] + dp[k][e], dp[s][e]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if(dp[from][to] <= time){
                sb.append("Enjoy other party\n");
            }else sb.append("Stay here\n");
        }

        System.out.println(sb);

    }
}