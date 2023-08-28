import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][][] visited;
    static long[][] dp;
    static long dfs(int x, int y){
        if(dp[x][y] != -1) return dp[x][y];

        long sum = 0;
        if(x - 1 >= 0 && !visited[x][y][0]) sum += dfs(x - 1, y);
        if(y - 1 >= 0 && !visited[x][y][1]) sum += dfs(x ,y - 1);

        return dp[x][y] = sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1][2];
        dp = new long[N + 1][M + 1];
        for(int i = 0; i < N + 1; i++) Arrays.fill(dp[i], -1);
        dp[0][0] = 1;

        int block = Integer.parseInt(br.readLine());
        for(int i = 0; i < block; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(a < c) visited[c][d][0] = true;
            else if(a > c) visited[a][b][0] = true;

            if(b < d) visited[c][d][1] = true;
            else if(b > d) visited[a][b][1] = true;
        }

        System.out.println(dfs(N ,M));

//        for(int i =0 ; i < N + 1; i++){
//            for(int j = 0; j < M + 1; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
