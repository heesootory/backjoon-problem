import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] arr, dp, sum_arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[300000];
        dp = new int[N+1];
        sum_arr = new int[N+1];

        int idx = 0;
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i-1] + i;
            sum_arr[i] = sum_arr[i-1] + arr[i];
            if(sum_arr[i] >= N) {
                idx = i;
                break;
            }
        }

        for(int i = 0; i < N + 1; i++) dp[i] = i;

        // knapSack
        for(int i = 0 ; i <= idx; i++){
            int norm = sum_arr[i];
            for(int j = norm; j < N + 1; j++){
                dp[j] = Math.min(dp[j], dp[j - norm] + 1);
            }
        }

//        for(int i : dp) System.out.print(i + " ");
//        System.out.println();
        System.out.println(dp[N]);

    }
}