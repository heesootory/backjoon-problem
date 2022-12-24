import java.io.*;
import java.util.*;


public class Main {
    static int N, M;

    static long[] dp;
    static int[] memory, cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new long[10001];
        memory = new int[N + 1];
        cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) memory[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) cost[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N + 1; i++){
            for(int d = 10000; d >= cost[i]; d--){
                dp[d] = Math.max(dp[d - cost[i]] + memory[i], dp[d]);
            }
        }

        for(int i = 0; i < dp.length; i++) {
            if(dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}