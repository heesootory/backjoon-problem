import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[2][N + 2];
        dp = new int[N+2];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N + 2; i++){
            dp[i] = Math.max(dp[i-1], dp[i]);
            if(i + arr[0][i] < N + 2){
                dp[i + arr[0][i]] = Math.max(dp[i + arr[0][i]], dp[i] + arr[1][i]);
            }
        }

//        for(int i : dp) System.out.print(i + " ");
        System.out.println(dp[N + 1]);
    }
}