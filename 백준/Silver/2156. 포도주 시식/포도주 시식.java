import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if(N >= 2){
            dp[2] = arr[1] + arr[2];
            for(int i = 3; i <= N; i++){
//              dp[i] = arr[i] + Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]);
                // 이 문제에서는 비연속적인 최댓값을 갱신하므로, 일반적인 dp배열이 무조건 최댓값을 보장하지 않음!!
                dp[i] = Math.max(dp[i-1], arr[i] + Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]));
                // 비연속적인 직전의 값과 비교를해봐야 함!!
            }
        }

        System.out.println(dp[N]);

    }
}