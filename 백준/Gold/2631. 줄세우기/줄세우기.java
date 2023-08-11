import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int maxLen = 0;
        dp[N - 1] = 1;
        for(int i = N - 2; i >= 0; i--){
            int max = 0;
            boolean flag = false;
            for(int j = i + 1; j < N; j++){
                if(arr[i] < arr[j] && dp[j] > max){
                    flag = true;
                    max = dp[j];
                }
            }
            dp[i] = flag ? max + 1 : 1;
            if(dp[i] > maxLen) maxLen = dp[i];
        }

        System.out.println(N - maxLen);

    }
}
