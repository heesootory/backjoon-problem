import java.util.*;
import java.io.*;


public class Main{
    static int M;
    static int[] doorArr;
    static int[][][] dp;
    static int dfs(int idx, int open1, int open2){
        if(idx >= M) return 0;

        int cache = dp[idx][open1][open2];
        if(cache != -1) return cache;

        int sum1 = Math.abs(open1 - doorArr[idx]) + dfs(idx + 1, doorArr[idx], open2);
        int sum2 = Math.abs(open2 - doorArr[idx]) + dfs(idx + 1, open1, doorArr[idx]);

        return dp[idx][open1][open2] = Math.min(sum1, sum2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int open1 = Integer.parseInt(st.nextToken());
        int open2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        doorArr = new int[M];
        for(int i = 0; i < M; i++){
            doorArr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[21][21][21];
        for(int i = 0; i < 21; i++){
            for(int j = 1; j < 21; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }


        System.out.println(dfs(0, open1, open2));


    }
}