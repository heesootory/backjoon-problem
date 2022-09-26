import java.io.*;
import java.util.*;

class Shark{
    int x, y;
    int cnt;        // 먹은 물고기 수
    int size;       // 크기
    Shark(int x, int y, int cnt, int size){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.size = size;
        grow();
    }
    void grow(){
        if(cnt == size){
            cnt = 0;
            size++;
        }
    }
}
class Fish implements Comparable<Fish>{
    int x, y;
    int size;
    Fish(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
    @Override
    public int compareTo(Fish o){ // 위쪽행부터 정렬, 행이 같다면 가장 왼쪽 열부터
        if(this.x == o.x){
            return this.y - o.y;
        }
        else return this.x - o.x;
    }
}
public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int total_move;
    static void bfs(Shark shark){               // 매번 상어의 위치를 시작으로 먹이 탐색
        visited = new boolean[N][N];
        Queue<Shark> queue = new LinkedList<>();
        queue.add(shark);
        visited[shark.x][shark.y] = true;
        int move = 0;

        while(!queue.isEmpty()){
            List<Fish> prey_arr = new ArrayList<>();        // 물고기 장바구니
            int len = queue.size();
            Shark now = null;
            move++;

            for(int q = 0; q < len; q++){    // 같은 거리에 있는 영역 탐색.
                 now = queue.poll();

                for(int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(visited[nx][ny]) continue;
                    if(map[nx][ny] > now.size) continue;

                    if(map[nx][ny] == now.size || map[nx][ny] == 0) {       // 먹지는 못하지만, 지나갈때. || 물고기 없는 길일대
                        visited[nx][ny] = true;
                        queue.add(new Shark(nx, ny, now.cnt, now.size));
                    }
                    else{       // 먹을 수 있는 물고기 만났을때, 아직 먹지마! - 같은 거리의 물고기 일단 전부 장바구니 넣기.
                        visited[nx][ny] = true;
                        prey_arr.add(new Fish(nx, ny, map[nx][ny]));
                    }
                }
            }

            if(prey_arr.size() != 0) {      
                Collections.sort(prey_arr);     
                Fish f = prey_arr.get(0);       
                map[f.x][f.y] = 9;          
                map[shark.x][shark.y] = 0;
                Shark ns = new Shark(f.x, f.y, now.cnt + 1, now.size);  // 물고기 먹고 성장.
                total_move += move;         // 먹을 먹이가 있었을때만 이동거리 추가.
                bfs(ns);        // 그 위치에서 새로운 탐색.
                return;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Shark shark = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) shark = new Shark(i,j,0,2);
            }
        }
        bfs(shark);
        System.out.println(total_move);
    }
}
