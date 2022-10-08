import java.io.*;
import java.util.*;

public class Solution {
    static class Corpes{
        int x, y;
        int num, dir;   // 바이러스 수, 이동방향(1,2,3,4)
        Corpes(int x, int y, int num, int dir){
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }
    static int N, M, K;
    static int[][] visited;
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,-1,1}; // 1부터 상,하,좌,우로 설정.
    static Queue<Corpes> manager;

    static void merge(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] > 1){      //군집의 갯수가 1개 초과
                    // 새로운 군집으로 다시 생성.
                    int sum = 0;
                    int new_dir = 0;
                    int max = 0;

                    int s = manager.size();
                    for(int k = 0; k < s; k++){
                        Corpes c = manager.poll();
                        // manager에 있는 군집중 같은 지역의 군집들을 새로운 군집으로 생성.
                        if(c.x == i && c.y == j){       // 얘네는 속성만 저장하고 manager에 다시 넣지 않음.
                            if(c.num > max){
                                max = c.num;
                                new_dir = c.dir;
                            }
                            sum += c.num;
                        }
                        else manager.add(c);   // 나머지는 그대로 다시 넣어줌.
                    }
                    Corpes new_corpes = new Corpes(i, j, sum, new_dir);
                    manager.add(new_corpes);        // 새로운 군집도 넣어주기.
//                    System.out.println(manager.size());
                }

            }
        }
    }
    static void simulation(){
        while(true){        // 꺼내면서 이동과 합병 시작!
            int len = manager.size();
            visited = new int[N][N];

            for(int i = 0; i < len; i++){
                Corpes c = manager.poll();

                // 좌표 이동.
                c.x = c.x + dx[c.dir];
                c.y = c.y + dy[c.dir];

                // 셀에 갔을 떼 반감되고 방향 반대로 바뀜.
                if(c.x == 0 || c.y == 0 || c.x == N - 1 || c.y == N - 1){
                    c.num /= 2;     //바이러스 반감.
                    if(c.x == 0 && c.dir == 1) c.dir = 2;   // 상 -> 하
                    else if(c.x == N - 1 && c.dir == 2) c.dir = 1;  // 하 -> 상
                    else if(c.y == 0 && c.dir == 3) c.dir = 4;  // 좌 -> 우
                    else if(c.y == N - 1 && c.dir == 4) c.dir = 3;  // 우 -> 좌
                }

                // 배열의 위치마자 군집의 갯수 갱신.
                visited[c.x][c.y]++;
                manager.add(c);
            }
//            print(visited);
            // 군집 병합.
            merge();
            M--;    // 시간 지남.
            if(M == 0) return;      // 격리시간 종료.
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());   // 맵의 크기
            M = Integer.parseInt(st.nextToken());   // 격리 시간
            K = Integer.parseInt(st.nextToken());   // 군집의 수

            manager = new LinkedList<>();
            visited = new int[N][N];
            for(int i = 0 ; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int virus = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                manager.add(new Corpes(row, col, virus, direction));
            }
            simulation();
            int ans = 0;
            for(Corpes c : manager) ans += c.num;

            System.out.printf("#%d %d\n", t, ans);
        }
    }

    static void print(int[][] arr){
        for(int[] i :arr){
            for(int j : i) System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
    }
}