import java.io.*;
import java.util.*;

public class Main {
    static int N, M, range = 15000;
    static int[] arr;
    static boolean[][] dp;
    static void dfs(int idx, int weight){
        // 이미 메모가 되어있다면 갈 필요x.
        if(dp[idx][weight]) return;
        dp[idx][weight] = true;

        // 기저조건 - 위와의 순서가 중요! 기저가 먼저 있으면, 코드 전면 수정
        if(idx == N) return;

        // 완탐.
        dfs(idx + 1, weight);
        dfs(idx + 1, weight + arr[idx + 1]);
        dfs(idx + 1, Math.abs(weight - arr[idx + 1]));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp = new boolean[N + 1][range + 1];
        dfs(0, 0);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < 5; i++) System.out.print(dp[N][i] + " ");
        for(int i = 0; i < M; i++) {
            int q = Integer.parseInt(st.nextToken());
            if(q <= range) sb.append(dp[N][q] ? "Y " : "N ");
            else sb.append("N ");
        }

        System.out.println(sb);

    }
}