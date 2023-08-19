import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){

                if(arr[i][j] != 0) continue;
                if(i - 1 < 0 || j - 1 < 0) {
                    dp[i][j] = 1;
                    ans = Math.max(ans, dp[i][j]);
                    continue;
                }
                if(arr[i - 1][j] != 0 || arr[i - 1][j - 1] != 0 || arr[i][j - 1] != 0) dp[i][j] = 1;

                int min = 987654321;
                min = Math.min(min, dp[i - 1][j]);
                min = Math.min(min, dp[i - 1][j - 1]);
                min = Math.min(min, dp[i][j - 1]);

                dp[i][j] = min + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(ans);
    }
}
