import java.io.*;
import java.util.*;


public class Solution {
    static class Pair{
        int x, y;
        int sum_charge;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int M, A;
    static int[] BC_charge;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy  ={0, 0, 1, 0, -1};
    static int[][] move;
    static int[][][] map;
    static Pair Ap;
    static Pair Bp;
    static void bfs(Pair sp, int c, int range){     // 맵에 충전 범위 그리기.
        Queue<Pair> queue = new LinkedList<>();
        map[c][sp.x][sp.y] = c;
        queue.add(sp);
        int ran = 0;

        while(!queue.isEmpty() && ran < range){
            int len = queue.size();
            ran++;
            for(int q = 0; q < len; q++) {
                Pair now = queue.poll();

                for(int d = 1; d < 5; d++){
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10) continue;
                    if(map[c][nx][ny] == c) continue;

                    map[c][nx][ny] = c;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());       // 이동 횟수
            A = Integer.parseInt(st.nextToken());       // 충전소의 갯수
            BC_charge = new int[A + 1];         // 맵마다 충전 능력.
            move = new int[2][M];               // 두 폰이 움직이는 좌표 저장.

            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    move[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            map = new int[A+1][10][10];

            for(int i = 1; i < A+1; i++){
                st = new StringTokenizer(br.readLine());
                int sy = Integer.parseInt(st.nextToken())-1;
                int sx = Integer.parseInt(st.nextToken())-1;
                int range = Integer.parseInt(st.nextToken());
                BC_charge[i] = Integer.parseInt(st.nextToken());

                bfs(new Pair(sx, sy), i, range);      // 각 맵에 충전 범위 표시.
            }

            // 폰 이동 + 충전
            Ap = new Pair(0,0);
            Bp = new Pair(9,9);
            int ans = 0;
            for(int i = 0 ; i <= M; i++){        // M만큼 이동할것,
                // 충전시키기.
                List<Integer> a_list = new ArrayList<>();       // 폰 마다 충전가능 한 맵을 저장.
                List<Integer> b_list = new ArrayList<>();
                for(int m = 1; m < A+1; m++){
                    if(map[m][Ap.x][Ap.y] > 0) a_list.add(m);
                    if(map[m][Bp.x][Bp.y] > 0) b_list.add(m);
                }
                int max = 0;
                if(a_list.size() == 0 && b_list.size() != 0){     // b만 충전가능시.
                    for(int m : b_list){
                        if(BC_charge[m] > max) max = BC_charge[m];
                    }
                    ans += max;
                }
                else if(b_list.size() == 0 && a_list.size() != 0){     // a만 충전가능시.
                    for(int m : a_list){
                        if(BC_charge[m] > max) max = BC_charge[m];
                    }
                    ans += max;
                }
                else if(a_list.size() != 0 && b_list.size() != 0){
                    int total = 0;
                    for(int ma : a_list){
                        for(int mb : b_list){
                            int sum = 0;
                            // 같은 충전기를 고를경우
                            if(ma == mb){
                                sum = BC_charge[ma];
                                if(sum > total) total = sum;
                            }else{      // 다른 충전기
                                sum += BC_charge[ma];
                                sum += BC_charge[mb];
                                if(sum > total) total = sum;
                            }
                        }
                    }
                    ans += total;
                }

                if(i == M) break;
                // 핸드폰 이동
                Ap.x += dx[move[0][i]];
                Ap.y += dy[move[0][i]];
                Bp.x += dx[move[1][i]];
                Bp.y += dy[move[1][i]];
            }
            System.out.printf("#%d %d\n", t, ans);
        }
    }
}
