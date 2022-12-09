import java.io.*;
import java.util.*;

public class Main {

    static int N, S, M;
    static int[] arr;
    static int[][] dp;

    static void nextVolume(int idx, int vol){
        if(idx == N + 1) return;

        if(vol + arr[idx] <= M){
            if(dp[idx][vol + arr[idx]] == 0){
                dp[idx][vol + arr[idx]] = 1;
                nextVolume(idx + 1, vol + arr[idx]);
            }
        }

        if(vol - arr[idx] >= 0){
            if(dp[idx][vol - arr[idx]] == 0){
                dp[idx][vol - arr[idx]] = 1;
                nextVolume(idx + 1, vol - arr[idx]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new int[N+1][M+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[0][S] = 1;
        nextVolume(1, S);

        int ans = -1;
        for(int i = 0; i < M + 1; i++){
            if(dp[N][i] == 1) ans = Math.max(i, ans);
        }

        System.out.println(ans);

    }
}