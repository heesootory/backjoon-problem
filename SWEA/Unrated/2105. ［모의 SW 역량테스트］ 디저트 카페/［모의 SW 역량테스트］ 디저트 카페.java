import java.io.*;
import java.util.*;

public class Solution {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] arr;
    static int[] dx = {1,1,-1,-1};
    static int[] dy = {1,-1,-1,1};
    static int max = Integer.MIN_VALUE;

    static void dfs(Pair sp, Pair np, int idx, int dir, boolean[][] visited, boolean[] visited2, int cnt){
        // 방향을 4번이상 바꾸면 안댐!
        if(idx == 4) return;
        // 방문 처리
        visited[np.x][np.y] = true;
        visited2[arr[np.x][np.y]] = true;
        // 새로운 배열 사용해서 기록.
        boolean[][] new_visited = new boolean[N][N];
        for(int i = 0; i < N; i++) new_visited[i] = visited[i].clone();
        boolean[] new_visited2 = visited2.clone();

        int nx = np.x + dx[dir];
        int ny = np.y + dy[dir];

        if(nx < 0 || ny < 0 || nx >= N || ny >= N) return;
        if(new_visited[nx][ny] || new_visited2[arr[nx][ny]]){
            // 이미 방문한 곳인데! -> 출발지라면! -> max값 갱신!! (정답 위치)
            if(sp.x == nx && sp.y == ny){
                if(cnt > max) max = cnt;
            }
            return;
        }

        // 방향 안바꾸는 놈
        dfs(sp, new Pair(nx, ny), idx, dir, new_visited, new_visited2, cnt + 1);
        // 방향을 바꾸는 놈 - 방향은 결국 순서가 정해져 있음.
        dfs(sp, new Pair(nx, ny), idx + 1, (dir + 1) % 4, new_visited, new_visited2, cnt + 1);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    boolean[][] visited = new boolean[N][N];        // 실제로 탐색하는 배열
                    boolean[] visited2 = new boolean[101];          // 방문한 카페를 기록하는 배열.
                    dfs(new Pair(i, j), new Pair(i, j), 0, 0, visited, visited2, 1);
                }
            }
            System.out.printf("#%d %d\n", t, (max == Integer.MIN_VALUE) ? -1 : max);

        }

    }
}