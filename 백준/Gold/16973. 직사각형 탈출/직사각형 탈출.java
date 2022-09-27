import java.io.*;
import java.util.*;


class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int H, W;
    static int sr, sc, fr, fc;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};

    static boolean check(int nx, int ny){
        int sum = 0;
        for(int i = nx; i < nx + H; i++){
            for(int j = ny; j < ny + W; j++){
                sum += arr[i][j];
            }
        }
        return (sum == 0);
    }

    static int bfs(Pair start){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        int cnt = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int q = 0; q < len; q++){
                Pair p = queue.poll();

                if(p.x == fr && p.y == fc) return cnt;

                for(int d = 0; d < 4; d++){
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if(nx < 1 || ny < 1 || nx + H - 1 > N || ny + W - 1 > M) continue;
                    if(visited[nx][ny]) continue;
                    if(!check(nx, ny)) continue;

                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
            cnt++;

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1 ; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < M+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        fr = Integer.parseInt(st.nextToken());
        fc = Integer.parseInt(st.nextToken());

        System.out.println(bfs(new Pair(sr, sc)));

    }
}
