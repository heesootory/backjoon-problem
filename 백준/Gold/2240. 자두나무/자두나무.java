import java.util.*;
import java.io.*;


public class Main{
    static int T, W;
    static int[] tree;
    static int[][][] dp;
    static int dfs(int time, int move, int idx){
        if(time == T) return 0;

        if(dp[time][move][idx] != -1) return dp[time][move][idx];

        // 움직일 수 없을 때
        if(move == 0) dp[time][move][idx] = dfs(time + 1, move, idx);

        // 움직일 수 있을 때
        else{
            int moving = dfs(time + 1, move - 1, (idx == 0) ? 1 : 0);
            int notMoving = dfs(time + 1, move, idx);
            dp[time][move][idx] = Math.max(moving, notMoving);
        }

        if(tree[time] == idx + 1) dp[time][move][idx]++;

        return dp[time][move][idx];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        tree = new int[T];
        dp = new int[T][W + 1][2];

        for(int i = 0; i < T; i++){
            for(int j = 0; j < W + 1; j++){
                for(int k = 0; k < 2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            tree[i] = t;
        }

        System.out.println(Math.max(dfs(0, W, 0), dfs(0, W - 1, 1)));

    }

}