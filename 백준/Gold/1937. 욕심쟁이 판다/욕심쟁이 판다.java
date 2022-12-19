import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static Integer[][] dp, memo;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int dfs(int row, int col){
        // 기저
        if(row == N || col == N || row < 0 || col < 0) return 0;
        // 메모이
        if(dp[row][col] != null) return dp[row][col];

        // 탐색
        dp[row][col] = 1;
        for(int d = 0; d < 4; d++){
            int nx = row + dx[d];
            int ny = col + dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(arr[nx][ny] > arr[row][col])
                dp[row][col] = Math.max(dp[row][col], dfs(nx, ny) + 1);
        }
        return dp[row][col];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        dp = new Integer[N][N];
        for(int i = 0 ; i< N; i++){
            for(int j = 0 ;j < N; j++){
                max = Math.max(dfs(i,j), max);
            }
        }
        System.out.println(max);
    }
}