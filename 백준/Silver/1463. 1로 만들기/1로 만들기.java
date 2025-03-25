import java.io.*;
import java.util.*;


public class Main {
    static int MAX = 1000000;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[MAX + 1];
        Arrays.fill(dp, MAX);
        dp[0] = dp[1] = 0;

        System.out.println(dfs(n));

    }
    private static int dfs(int num){

        if(dp[num] != MAX) return dp[num];

        if(num % 3 == 0) dp[num] = Math.min(dp[num], dfs(num / 3) + 1);
        if(num % 2 == 0) dp[num] = Math.min(dp[num], dfs(num / 2) + 1);
        dp[num] = Math.min(dp[num], dfs(num - 1) + 1);

        return dp[num];
    }
}
