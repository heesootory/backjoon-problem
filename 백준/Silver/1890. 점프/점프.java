import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] arr;
    static long[][] dp;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static long backtrek(int x, int y){
        if(x == N - 1 && y == N - 1){
            return 1;
        }
        // 이미 저장이 되어있다면 그걸 꺼내.
        if(dp[x][y] != -1) return dp[x][y];

        // 아직 저장이 안된 dp라면.
        dp[x][y] = 0;
        for(int d = 0; d < 2; d++){
            int nx = x + dx[d] * arr[x][y];
            int ny = y + dy[d] * arr[x][y];
            if(nx >= N || ny >= N) continue;

            dp[x][y] += backtrek(nx, ny);
        }
        // 저장해서 꺼내죠.
        return dp[x][y];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new long[N][N];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);     // dp배열은 모두 -1로 채우기.
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrek(0,0);
        
        System.out.println(dp[0][0]);

    }
}