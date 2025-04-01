import java.io.*;
import java.util.*;


public class Main {
    static int N, M, K;
    static char[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N + 1][M + 1];
        dp = new int[N + 1][M + 1];     // 누적합 2차원 배열.

        for(int i = 1; i < N + 1; i++){
            String str = br.readLine();
            for(int j = 1; j < M + 1; j++){
                arr[i][j] = str.charAt(j-1);
            }
        }

        // 첫 번째 문자를 B로 가정하고 카운트. (결국 KxK 구간에서 최대는 KxK - 최소 이므로)
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < M + 1; j++){
                if((i + j) % 2 == 0){
                    dp[i][j] = (arr[i][j] == 'B') ? 0 : 1;
                }else{
                    dp[i][j] = (arr[i][j] == 'W') ? 0 : 1;
                }
            }
        }

        // 행, 열 순서로 누적합 만들기
        for(int i = 0; i < N + 1; i++){
            for(int j = 1; j < M + 1; j++){
                dp[i][j] += dp[i][j - 1];
            }
        }

        for(int j = 0; j < M + 1; j++){
            for(int i = 1; i < N + 1; i++){
                dp[i][j] += dp[i - 1][j];
            }
        }

        int ans = Integer.MAX_VALUE;
        // KxK 배열의 구간합 중 최소 구하기.
        for(int i = K; i < N + 1; i++){
            for(int j = K; j < M + 1; j++){
                int sum = dp[i][j] - dp[i-K][j] - dp[i][j-K] + dp[i-K][j-K];
                if(sum < ans) ans = sum;            // 그대로 시작문자가 'B'인 경우
                if(K*K-sum < ans) ans = K*K-sum;    // 시작문자가 반대일 경우.
            }
        }

        System.out.println(ans);

    }
    
}

