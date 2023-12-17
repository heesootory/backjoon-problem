import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ans = 1;
        dp[0] = 1;
        for(int i = 1; i< n; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
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