import java.io.*;
import java.util.*;


public class Main {
    static int T, N;
    static int[] arr, sum_arr;
    static int[][] dp;

    static void print(){
        for(int[] i : dp){
            for(int j : i) System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());

            arr = new int[N + 1];
            sum_arr = new int[N + 1];
            dp = new int[N][N];

            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i = 1; i < N+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
                sum_arr[i] = sum;
            }

            // 초기화
            for(int i = 0; i < N - 1; i++) dp[i][i+1] = arr[i+1] + arr[i+2];
            for(int d = 2; d < N; d++){
                for(int i = 0; i < N - d; i++){
                    int j = i + d;
                    dp[i][j] = 987654321;
                    for(int a = i, b = i + 1; a < j; a++, b++){
                        int n = dp[i][a] + dp[b][j] - sum_arr[i] + sum_arr[j + 1];
                        if(n < dp[i][j]) dp[i][j] = n;
                    }
                }
            }

            System.out.println(dp[0][N-1]);
        }
    }
}