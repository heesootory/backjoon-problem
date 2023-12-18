import java.io.*;
import java.util.*;

/**
 *  최대 길이를 구하기 위한 최선의 방법.
 *  ansList가 무조건 가장 긴 증가하는 부분수열로 저장되는 것은 아님.
 */

public class Main{
    static int N, K;
    static int[][] dp;
    static final int INF = 1_000_000_003;
    static int dfs(int n, int k){
        if(n < k) return dp[n][k] = 0;
        if(k <= 0) return dp[n][k] = 1;
        if(k == 1) return dp[n][k] = n;

        int cache = dp[n][k];
        if(cache != -1) return cache;

        // 가장 마지막의 숫자를 선택하는 경우 + 안하는 경우
        int res = dfs(n - 2, k - 1) + dfs(n - 1, k);

        return dp[n][k] = res % INF;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        dp = new int[1001][1001];

        for(int i = 1; i < 1001; i++){
            for(int j = 1; j < 1001; j++){
                dp[i][j] = -1;
            }
        }

        int ans = (dfs(N - 3, K - 1) + dfs(N - 1, K)) % INF;
        System.out.println(ans);

    }
}