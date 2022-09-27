import java.io.*;
import java.util.*;

class Pair{
    int x, y;
    int key;
    Pair(int x, int y, int key){
        this.x = x;
        this.y = y;
        this.key = key;
    }
}

public class Main {
    static int N, M;
    static char[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int min = Integer.MAX_VALUE;

    static boolean bfs(Pair p){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);
        visited[p.key][p.x][p.y] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int q = 0; q < len; q++){
                Pair now = queue.poll();

                if(arr[now.x][now.y] == '1') {
                    min = Math.min(min,cnt);
                    return true;    // 종료
                }

                for(int d = 0; d < 4; d++){
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(arr[nx][ny] == '#') continue;

                    if("ABCDEF".indexOf(arr[nx][ny]) != -1) {
                        // 키가 있는지 확인.
                        if(((1 << (arr[nx][ny]) - 'A') & now.key) > 0){
//                            now.key = (1 << (arr[nx][ny]) - 'A') & now.key;
                            if(!visited[now.key][nx][ny]){
                                visited[now.key][nx][ny] = true;
                                queue.add(new Pair(nx, ny, now.key));
                            }
                        }
                    }
                    else if("abcdef".indexOf(arr[nx][ny]) != -1) {
                        // 키 추가. -> 이동
                        if (!visited[now.key][nx][ny]) {
                            int next_key = ((1 << (arr[nx][ny] - 'a')) | now.key);
                            visited[next_key][nx][ny] = true;
                            queue.add(new Pair(nx, ny, next_key));
                        }
                    }
                    else {
                        // 그냥 이동.
                        if(!visited[now.key][nx][ny]) {
                            visited[now.key][nx][ny] = true;
                            queue.add(new Pair(nx, ny, now.key));
                        }
                    }
                }
            }
            cnt++;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Pair start = null;

        arr = new char[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == '0') start = new Pair(i, j, 0);
            }
        }

        visited = new boolean[1<<6][N][M];

        System.out.println(bfs(start) ? min : -1);
    }
}
