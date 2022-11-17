import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < M+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                dp[i][j] = Math.max(dp[i][j-1] + arr[i][j], dp[i-1][j] + arr[i][j]);
            }
        }

//        for(int i = 1; i < N+1; i++){
//            for(int j = 1; j < M+1; j++){
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(dp[N][M]);


    }
}