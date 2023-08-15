import java.io.*;
import java.util.*;

class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int INF = Integer.MIN_VALUE;
    static int N, M;
    static int[][] arr;
    static int[][] updp;
    static int[][] downdp;
    static int[][] upDir = {{1, 0}, {0, -1}};
    static int[][] downDir = {{-1, 0}, {0, -1}};
    static boolean[][] visited;

    static int upDfs(Node node){
        // 출발점일때
        if(node.x == N - 1 && node.y == 0){
            return arr[N-1][0];
        }

        if(updp[node.x][node.y] > INF) return updp[node.x][node.y];

        int max = INF;
        for(int i = 0; i < 2; i++){
            int next_x = node.x + upDir[i][0];
            int next_y = node.y + upDir[i][1];

            if(next_x >= N || next_y < 0) continue;

            int next_num = upDfs(new Node(next_x, next_y));
            if(max < next_num) max = next_num;
        }
        updp[node.x][node.y] = arr[node.x][node.y] + max;
        return updp[node.x][node.y];
    }

    static int downDfs(Node node){
        if(visited[node.x][node.y]) return downdp[node.x][node.y];

        int max = downdp[node.x][node.y];
        for(int i = 0; i < 2; i++){
            int next_x = node.x + downDir[i][0];
            int next_y = node.y + downDir[i][1];

            if(next_x < 0 || next_y < 0) continue;

            int next_num = downDfs(new Node(next_x, next_y));
            if(next_num > max) max = next_num;
        }

        visited[node.x][node.y] = true;
        downdp[node.x][node.y] = arr[node.x][node.y] + max;
        return downdp[node.x][node.y];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        updp = new int[N][M];
        downdp = new int[N][M];
        for(int i = 0; i < N; i++) Arrays.fill(updp[i], INF);
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 상승 탐색
        updp[N-1][0] = arr[N-1][0];
        for(int i = 0; i < M; i++) upDfs(new Node(0, i));

        // 하강 탐색
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                downdp[i][j] = updp[i][j];
            }
        }

        downDfs(new Node(N - 1, M - 1));

        System.out.println(downdp[N - 1][M-1]);


        // 출력
//        for(int i = 0; i < N ; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(updp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println();
//
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(downdp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
