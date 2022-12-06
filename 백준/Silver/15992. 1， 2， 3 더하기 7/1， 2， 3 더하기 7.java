import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int mod = 1000000009;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        dp = new int[1001][1001];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[2][2] = 1;
        dp[2][3] = 2;
        dp[3][3] = 1;

        for(int i = 1; i < 1001; i++){
            for(int j = 4; j < 1001; j++){
                dp[i][j] = ((dp[i-1][j-1] + dp[i-1][j-2]) % mod + dp[i-1][j-3]) % mod;
            }
        }

        for(int t = 0; t < test; t++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(dp[m][n]).append("\n");
        }
        System.out.println(sb);

    }
}