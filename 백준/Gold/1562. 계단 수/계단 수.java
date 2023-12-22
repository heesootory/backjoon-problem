import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static final int success = (1 << 10) - 1;
    static final int MOD = 1_000_000_000;
    static int[][][] dp;
    static int dfs(int idx, int last, int bitmask){
        if(last == 10 || last == -1) return 0;
        if(idx == N) return (bitmask == success) ? 1 : 0;

        if(dp[idx][last][bitmask] != -1) return dp[idx][last][bitmask];

        int cache = 0;
        cache += dfs(idx + 1, last + 1, bitmask | (1 << (last + 1)));
        cache += dfs(idx + 1, last - 1, bitmask | (1 << (last - 1)));

        return dp[idx][last][bitmask] = cache % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][10][1 << 10];
        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < 10; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = 0;
        for(int i = 1; i < 10; i++){
            ans += dfs(1, i, 1 << i);
            ans %= MOD;
        }

        System.out.println(ans);

    }
}