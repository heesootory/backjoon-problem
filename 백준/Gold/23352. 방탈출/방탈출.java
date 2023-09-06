import java.io.*;
import java.util.*;

class Pair{
    int x, y;
    ArrayList<Integer> list = new ArrayList<>();
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int maxLen, password;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void bfs(Pair start){
        Queue<Pair> queue = new LinkedList<>();
        visited = new boolean[N][M];
        queue.add(start);
        visited[start.x][start.y] = true;
        int len = 0;

        while(!queue.isEmpty()){
            len++;
            int s = queue.size();
            boolean last;
            for(int p = 0; p < s; p++){
                Pair pair = queue.poll();
                last = true;
                for(int d = 0; d < 4; d++){
                    int next_x = pair.x + dx[d];
                    int next_y = pair.y + dy[d];

                    if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) continue;
                    if(visited[next_x][next_y] || arr[next_x][next_y] == 0) continue;

                    last = false;
                    visited[next_x][next_y] = true;
                    queue.add(new Pair(next_x, next_y));
                }

                if(last){
                    int sum = arr[start.x][start.y] + arr[pair.x][pair.y];
                    if(maxLen < len){
                        maxLen = len;
                        password = sum;
                    }
                    else if(maxLen == len) password = Math.max(password, sum);
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] != 0) bfs(new Pair(i, j));
            }
        }

        System.out.println(password);
    }
}
