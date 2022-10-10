import java.io.*;
import java.util.*;


public class Solution{
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, K;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max;
    static boolean[][] visited;

    static void dfs(Pair p, int len, boolean drill){
        if(len > max) max = len;
        visited[p.x][p.y]  = true;
        for(int d = 0; d < 4; d++){
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

            if(arr[nx][ny] < arr[p.x][p.y]) dfs(new Pair(nx, ny), len + 1, drill);
            else{
                if(drill) {
                    int cut = arr[nx][ny] - (arr[p.x][p.y] - 1);    // 가능한 최소로 커팅한 수치
                    if(cut <= K){
                        arr[nx][ny] -= cut;
                        dfs(new Pair(nx, ny), len + 1, false);
                        arr[nx][ny] += cut;
                    }
                }
            }
        }
        visited[p.x][p.y] = false;
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
                    if(arr[i][j] == peek) dfs(new Pair(i, j), 1, true);
                }
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}