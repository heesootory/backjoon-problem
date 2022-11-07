import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[2][N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        // 왼쪽 ->  오른쪽으로 : 자신보다 작은 수중에 dp가 가장 큰수 + 1로 저장
        for(int i = 1; i < N; i++){
            int m1 = -1;
            for(int j = i; j >= 0; j--){
                if(arr[j] < arr[i] && dp[0][j] > m1) m1 = dp[0][j];
            }
            dp[0][i] = m1 + 1;
        }
        // 오른쪽 -> 왼쪽
        for(int i = N-2; i >= 0; i--){
            int m2 = -1;
            for(int j = i; j < N; j++){
                if(arr[j] < arr[i] && dp[1][j] > m2) m2 = dp[1][j];
            }
            dp[1][i] = m2 + 1;
        }

        int ans = 0;
        for(int i = 0; i < N; i++){
            if((dp[0][i] + dp[1][i]) > ans) ans = dp[0][i] + dp[1][i];
        }
        System.out.println(ans + 1);
    }
}