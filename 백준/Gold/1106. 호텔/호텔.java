import java.io.*;
import java.util.*;

public class Main{
    static int C, N;
    static int[] dp;
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[C + 101];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cus = Integer.parseInt(st.nextToken());

            for(int j = cus; j < C + 101; j++){
                dp[j] = Math.min(dp[j], dp[j - cus] + cost);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = C; i < C + 101; i++){
            if(dp[i] < ans) ans = dp[i];
        }
        System.out.println(ans);
    }
}