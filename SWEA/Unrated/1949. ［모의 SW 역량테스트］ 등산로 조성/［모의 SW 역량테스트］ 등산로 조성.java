import java.io.*;
import java.util.*;


public class Solution{
    static int N, K;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max;
    static boolean[][] visited;

    static void dfs(int x, int y, int len, boolean drill){
        if(len > max) max = len;
        visited[x][y]  = true;
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

            if(arr[nx][ny] < arr[x][y]) dfs(nx, ny, len + 1, drill);
            else{
                if(drill) {
                    int cut = arr[nx][ny] - (arr[x][y] - 1);    // 가능한 최소로 커팅한 수치
                    if(cut <= K){
                        arr[nx][ny] -= cut;
                        dfs(nx, ny, len + 1, false);
                        arr[nx][ny] += cut;
                    }
                }
            }
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            max = 0;

            arr = new int[N][N];
            visited = new boolean[N][N];

            int peek = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] > peek) peek = arr[i][j];
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == peek) dfs(i, j, 1, true);
                }
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}