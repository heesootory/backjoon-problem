import java.io.*;
import java.util.*;

public class Main{
    static int N, K;
    static int[][] dp;
    static int[] w;
    static int[] v;

    static int pack(int capacity, int item){
        if(item == N) return 0;
        if(dp[item][capacity] != -1) return dp[item][capacity];

        dp[item][capacity] = pack(capacity, item + 1);
        if(capacity >= w[item]){
            dp[item][capacity] = Math.max(dp[item][capacity], pack(capacity - w[item], item + 1) + v[item]);
        }

        return dp[item][capacity];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       // 물건의 갯수
        K = Integer.parseInt(st.nextToken());       // 가방의 용량
        w = new int[N+1];
        v = new int[N+1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());   // 물건의 무게
            v[i] = Integer.parseInt(st.nextToken());   // 물건의 가치
        }
        dp = new int[N+1][K+1];
        for(int i = 0 ; i < dp.length; i++) Arrays.fill(dp[i], -1);

        System.out.println(pack(K, 0));

    }
}