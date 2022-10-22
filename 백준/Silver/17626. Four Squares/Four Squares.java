import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[50001];

        dp[1] = 1;
        // dp: bottom - up 방식
        for(int i = 2; i <= N; i++){
            int min = Integer.MAX_VALUE;

            // i에서 i보다 작은 제곱수에서 뺀 dp[i-j*j]+1 중에 더 작은값을 저장.
            for(int j = 1; j * j <= i; j++){
                min = Math.min(min, dp[i - j*j] + 1);
            }
            dp[i] = min;
        }
        System.out.println(dp[N]);

    }
}

