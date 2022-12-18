import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] cards;
    static int[][] dp;

    static int game(int left, int right){
        // 기저
        if(left == N || right == N) return 0;

        // 메모
        if(dp[left][right] != -1) return dp[left][right];

        // 탐색
        // 왼쪽을 버리기
        int result1 = game(left+1, right);
        // 둘 다 버리기
        int result2 = game(left + 1, right + 1);
        // 오른쪽 버리기
        int result3 = 0;
        if(cards[0][left] > cards[1][right])
            result3 = game(left, right + 1) + cards[1][right];

        return dp[left][right] = Math.max(result1, Math.max(result2, result3));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cards = new int[2][N];

        for(int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열 초기화
        dp = new int[N][N];
        for(int i = 0; i < N; i++) Arrays.fill(dp[i], -1);

        System.out.println(game(0, 0));


    }
}