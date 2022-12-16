import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, marbles;
    static int[][] dp;
    static final int len = 400001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        marbles = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) marbles[i] = Integer.parseInt(st.nextToken());

        dp = new int[N+1][len];

        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < len; j++){
                if(dp[i-1][j] == 1){
                    dp[i][j] = 1;       // 이전에 이미 측정 가능한 구슬의 무게.
                    // 이미 측정 가능한 무게에서 새로운 추를 추가해서 측정이 가능한 무게들을 표시.
                    dp[i][Math.abs(j - arr[i])] = 1;
                    if(j + arr[i] < len) dp[i][j + arr[i]] = 1;
                }
                if(j == arr[i]) dp[i][j] = 1;       // 새로운 추 하나만 가지고 측정 가능한 무게.
            }
        }

        for(int i = 0; i < M; i++){
            System.out.print((dp[N][marbles[i]] == 1) ? "Y " : "N ");
        }
    }
}