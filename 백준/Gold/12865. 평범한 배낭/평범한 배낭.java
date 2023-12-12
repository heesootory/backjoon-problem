import java.util.*;
import java.io.*;


public class Main{
    static int N, K;
    static int[] weights;
    static int[] values;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weights = new int[N + 1];
        values = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            weights[i] = weight;
            values[i] = value;
        }

        dp = new int[N + 1][K + 1];
        for(int i = 1; i < N + 1; i++) Arrays.fill(dp[i], -1);

        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < K + 1; j++){
                // 물건을 넣을 수 없을 때
                if(weights[i] > j) dp[i][j] = dp[i - 1][j];
                // 물건을 넣을 수 있을 떄
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[N][K]);


    }

}