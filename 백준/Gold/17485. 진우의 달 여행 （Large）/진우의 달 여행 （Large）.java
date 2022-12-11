import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int dir = 3;
    static int[][] arr;
    static int[][][] dp;        // dir, i, j

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[dir][N][M];
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                // dp 테이블 0행은 모든 방향에서 온 연료처럼 처리해서 저장.
                if(i == 0){
                    for(int d = 0; d < dir; d++) dp[d][i][j] = arr[i][j];
                }
            }
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                // 양쪽 끝 정류소는 예외처리
                if(j == 0) {
                    dp[0][i][j] = Integer.MAX_VALUE;        // 올수 없는값
                    dp[1][i][j] = dp[2][i - 1][j] + arr[i][j];
                    dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[1][i - 1][j + 1]) + arr[i][j];
                }else if(j == M - 1){
                    dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1]) + arr[i][j];
                    dp[1][i][j] = dp[0][i - 1][j] + arr[i][j];
                    dp[2][i][j] = Integer.MAX_VALUE;        // 올수 없는값
                }else{      // 일반항
                    dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1]) + arr[i][j];
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + arr[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1]) + arr[i][j];
                }
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(Math.min(dp[0][i][j], Math.min(dp[1][i][j] , dp[2][i][j])) + " ");
//            }
//            System.out.println();
//        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < M; j++) {
            int min_value = Math.min(dp[0][N -1][j], Math.min(dp[1][N - 1][j] , dp[2][N - 1][j]));
            if(min_value < ans) ans = min_value;
        }

        System.out.println(ans);

    }
}