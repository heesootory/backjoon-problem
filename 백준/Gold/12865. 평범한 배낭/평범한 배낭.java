import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, K;
    static int[][] dp;
    static int[] w, v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        w = new int[N+1];
        v = new int[N+1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][K+1];

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < K + 1; j++){
                dp[i][j] = dp[i-1][j];
                if(j - w[i] >= 0) dp[i][j] = Math.max(dp[i-1][j-w[i]] + v[i] , dp[i][j]);
            }
        }

        System.out.println(dp[N][K]);

    }

}
