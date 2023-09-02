import java.io.*;
import java.util.*;


public class Main {
    static int INF = Integer.MIN_VALUE;
    static int N, M;
    static int[] arr;
    static int[][] dp;
    static int dfs(int idx, int health){
        if(idx > N || health > M || idx == N && health != 0) return INF;
        if(idx == N) return 0;

        if(dp[idx][health] != -1) return dp[idx][health];

        // 어디서든지 뛸 수 있기 때문에 기본값을 점프했을 경우로 지정.
        int max = dfs(idx + 1, health + 1) + arr[idx];

        // 쉬는 경우
        // 1. 지침계수가 0일 때 쉬는 경우.
        if(health == 0) max = Math.max(max, dfs(idx + 1, health));
        // 2. 지침계수가 0이 아닌데 쉬기 시작한 경우 -> 곧바로 0으로 이동시켜버림.
        if(health != 0) max = Math.max(max, dfs(idx + health, 0));

        return dp[idx][health] = max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][M + 1];
        for(int i = 0; i < N + 1; i++) Arrays.fill(dp[i], -1);

        System.out.println(dfs(0 ,0));

//        for(int i = 0; i < N + 1; i++){
//            for(int j =0 ; j < M + 1; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}
