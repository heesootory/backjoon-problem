import java.io.*;
import java.util.*;

class Pair{
    int x, y, cnt, move;
    Pair(int x, int y, int cnt, int move){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.move = move;
    }
}
public class Main {
    static int H, W;
    static int[][] arr;
    // 방문처리 0 : 원숭이/ 1: 말
    static boolean[][][] visited;
    // 말의 이동
    static int[] hx = {-2,-2,-1,-1,1,1,2,2};
    static int[] hy = {-1,1,-2,2,-2,2,-1,1};
    // 원숭이 이동
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static boolean map_out(int nx, int ny){
        return (nx < 0 || ny < 0 || nx >= H || ny >= W);
    }
    static boolean obstacle(int nx, int ny){
        return (arr[nx][ny] == 1);
    }
    static boolean check(int nx, int ny, int cnt){
        return (visited[nx][ny][cnt]);
    }
    static int bfs(Pair start) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][start.cnt] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
//            System.out.println(p.x + " "+ p.y + ":" + p.cnt);

            // 도착시
            if(p.x == H-1 && p.y == W-1) return p.move;

            if(p.cnt > 0){      // 말의 이동
                for(int h = 0; h < 8; h++){
                    int nx = p.x + hx[h];
                    int ny = p.y + hy[h];
                    /**🐋🐋
                     * 객체의 능력 변화에 따라 다른 탐색을 할 경우.
                     * 능력의 변화를 먼저 적용해주는게 헷갈리지 않을듯하다.
                     * 🐋🐋
                     */
                    int n_cnt = p.cnt - 1;

                    if(map_out(nx, ny)) continue;   // 맵 밖으로
                    if(obstacle(nx, ny)) continue;      // 장애물
                    if(check(nx, ny, n_cnt)) continue;  // 방문 여부 -> 메모리 초과가 난부분.

                    visited[nx][ny][n_cnt] = true;
                    queue.add(new Pair(nx, ny, n_cnt, p.move + 1));
                }
            }
            // 원숭이의 이동
            for(int m = 0; m < 4; m++){
                int nx = p.x + mx[m];
                int ny = p.y + my[m];

                if(map_out(nx, ny)) continue;   // 맵 밖으로
                if(obstacle(nx, ny)) continue;      // 장애물
                if(check(nx, ny, p.cnt)) continue;  // 방문 여부

                visited[nx][ny][p.cnt] = true;
                queue.add(new Pair(nx, ny, p.cnt,  p.move + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(new Pair(0,0, K, 0)));

    }
}