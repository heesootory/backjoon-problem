import java.io.*;
import java.util.*;


public class Main {
    static int N, ans;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N+1; i++){
            int max = 0;
            for(int j = i; j >= 0; j--){
                if(arr[j] < arr[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);

    }
}