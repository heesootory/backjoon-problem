import java.io.*;
import java.util.*;


class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static PriorityQueue<Integer> pq;
    static int N;
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i] = str.toCharArray();
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == '1') BFS(new Pair(i, j));
            }
        }

        System.out.println(pq.size());
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
    static void BFS(Pair p){
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(p);
        visited[p.x][p.y] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] != '1') continue;

                queue.offer(new Pair(nx, ny));
                visited[nx][ny] = true;
                arr[nx][ny] = '2';
                cnt++;
            }
        }

        pq.add(cnt);

    }

}

