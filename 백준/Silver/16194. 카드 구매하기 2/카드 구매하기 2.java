import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int[] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) dp[i] = Integer.parseInt(st.nextToken());

        for(int i = 2; i < N + 1; i++){
            for(int j = 1; j <= i /2; j++){
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
//        for(int i : dp) System.out.print(i + " ");
        System.out.println(dp[N]);
    }
}