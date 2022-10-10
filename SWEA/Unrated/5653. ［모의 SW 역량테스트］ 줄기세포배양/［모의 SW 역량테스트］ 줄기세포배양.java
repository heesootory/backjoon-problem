import java.io.*;
import java.util.*;


public class Solution{
    static class Cell implements Comparable<Cell>{
        int x, y;
        int life, time;
        boolean active;
        Cell(int x, int y, int life, int time, boolean act){
            this.x = x;
            this.y = y;
            this.life = life;
            this.time = time;
            this.active = act;
        }

        @Override
        public int compareTo(Cell o){
            return o.life - this.life;      // life가 큰것부터 내림차순으로 pq에서 나오게
        }
    }
    static int N, M, K;
    static final int norm = 200;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static PriorityQueue<Cell> pq;
    static Queue<Cell> queue;

    static void bfs(){
        int time = 0;

        while(!pq.isEmpty()){
            // pq의 1 시간동안 확인할 cell들 모두 확인.
            int len = pq.size();
            for(int q = 0; q < len; q++){
                Cell c = pq.poll();
                c.time--;

                if(!c.active){      // 비활성 상태.
                    if(c.time == 0){
                        c.active = true;
                        c.time = c.life;
                        queue.add(c);
                    }
                    else queue.add(c);
                }
                else{       // 활성 상태.
                    if(c.life - c.time == 1){   //활성상태 직후 1시간일때
                        for(int d = 0; d < 4; d++){
                            int nx = c.x + dx[d];
                            int ny = c.y + dy[d];

                            if(arr[nx][ny] != 0) continue;
                            arr[nx][ny] = c.life;
                            queue.add(new Cell(nx, ny, c.life, c.life, false));
                        }
                    }
                    if(c.time != 0) queue.add(c);
                }

            }
            // 1 시간동안 확인할 cell들 모두 확인 완료.

            while(!queue.isEmpty()){
                pq.add(queue.poll());
            }
//            print(arr);
//            System.out.println();
//            System.out.println();
//            System.out.println();
            time++;
            // 제한 시간까지의 모든 활동이 마치면 종료.
            if(time == K) return;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[500][500];
            pq = new PriorityQueue<>();
            queue = new LinkedList<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    int life = Integer.parseInt(st.nextToken());
                    if(life > 0){
                        arr[norm + i][norm + j] = life;
                        pq.add(new Cell(norm + i, norm + j, life, life, false));
                    }
                }
            }

            bfs();
            System.out.printf("#%d %d\n", t, pq.size());

        }
    }

    static void print(int[][] arr){
        for(int i = norm-10; i < norm+20; i++){
            for(int j = norm-10; j < norm+20; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}