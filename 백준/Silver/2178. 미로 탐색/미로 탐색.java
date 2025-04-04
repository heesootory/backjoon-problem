import java.io.*;
import java.util.*;

class Pair{
    int x, y;
    int cnt;
    public Pair(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class Main {
    static int N, M;
    static int[][] field;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M ;j++){
                field[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(BFS(new Pair(0, 0, 1)));
    }

    static int BFS(Pair p) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(p);
        visited[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (curr.x == N - 1 && curr.y == M - 1) return curr.cnt;

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (field[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                field[nx][ny] = field[curr.x][curr.y] + 1;
                queue.offer(new Pair(nx, ny, curr.cnt + 1));
            }
        }
        return 0;
    }
}

