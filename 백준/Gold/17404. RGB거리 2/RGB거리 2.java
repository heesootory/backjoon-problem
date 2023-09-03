import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static final int INF = 987654321;
    static int[][] price_arr;
    static int[][][] dp;
    static int dfs(int idx, int color, int start){
        if(idx == N) {
            return (color == start) ? 0 : INF;
        }

        if(dp[idx][color][start] != -1) return dp[idx][color][start];

        int min = INF;
        for(int i = 1; i < 4; i++){
            if(i != color) min = Math.min(min, dfs(idx + 1, i, start) + price_arr[idx][color]);
        }

        return dp[idx][color][start] = min;
    }

    static void intialize(int[][][] dp){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 4; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        price_arr = new int[N][4];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 4; j++) {
                price_arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < 4; i++) {
            dp = new int[N][4][4];
            intialize(dp);
            ans = Math.min(ans, dfs(0, i, i));
        }
        System.out.println(ans);

    }
}
