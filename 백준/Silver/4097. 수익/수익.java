import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            int T = Integer.parseInt(br.readLine());
            if(T == 0) break;

            int max = Integer.MIN_VALUE;
            arr = new int[T];
            dp = new int[T];
            for(int i = 0; i < T; i++)  arr[i] = Integer.parseInt(br.readLine());
            dp[0] = arr[0];
            for(int i = 1; i < T; i++) {
                dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
                if(max < dp[i]) max = dp[i];
            }

            System.out.println(max);

        }
    }
}