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
    static int N, M;
    static int R, C, L;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};   // 상, 하, 좌, 우
    static int cnt;

    static void bfs(Pair start){
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        int time = 1; cnt++;

        while(!queue.isEmpty()){
            int len = queue.size();
            if(time == L) return;

            for(int q = 0; q < len; q++){
                Pair now = queue.poll();
                int npipe = arr[now.x][now.y];

                for(int d = 0; d < 4; d++){
                    // 파이프 확인 - 나가는 쪽 확인하기
                    if(npipe == 2 && (d == 2 || d == 3)) continue;      // 좌, 우
                    else if(npipe == 3 && (d == 0 || d == 1)) continue; // 상, 하
                    else if(npipe == 4 && (d == 2 || d == 1)) continue; // 좌, 하
                    else if(npipe == 5 && (d == 0 || d == 2)) continue; // 좌, 상
                    else if(npipe == 6 && (d == 0 || d == 3)) continue; // 우, 상
                    else if(npipe == 7 && (d == 1 || d == 3)) continue; // 우, 하

                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(visited[nx][ny]) continue;

                    // 파이프 확인 - 들어가는 쪽 제외시키기.
                    int pipe = arr[nx][ny];
                    switch(pipe){
                        case 1:
                            visited[nx][ny] = true;
                            queue.add(new Pair(nx, ny)); cnt++;
                            break;
                        case 2:     // 상, 하
                            if(d == 0 || d == 1) {
                                visited[nx][ny] = true;
                                queue.add(new Pair(nx, ny)); cnt++;
                            } break;
                        case 3:     // 좌, 우
                            if(d == 2 || d == 3){
                                visited[nx][ny] = true;
                                queue.add(new Pair(nx, ny)); cnt++;
                            }break;
                        case 4:     // 하, 좌
                            if(d == 1 || d == 2){
                                visited[nx][ny] = true;
                                queue.add(new Pair(nx, ny)); cnt++;
                            }break;
                        case 5:     // 좌, 상
                            if(d == 0 || d == 2){
                                visited[nx][ny] = true;
                                queue.add(new Pair(nx, ny)); cnt++;
                            }break;
                        case 6:     // 우, 상
                            if(d == 0 || d == 3){
                                visited[nx][ny] = true;
                                queue.add(new Pair(nx, ny)); cnt++;
                            }break;
                        case 7:     // 우, 하
                            if(d == 1 || d == 3){
                                visited[nx][ny] = true;
                                queue.add(new Pair(nx, ny)); cnt++;
                            }break;
                    }

                }
            }
            time++;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            cnt = 0;
            arr = new int[N][M];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M ; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(new Pair(R, C));
            System.out.printf("#%d %d\n", t, cnt);
        }
    }
}