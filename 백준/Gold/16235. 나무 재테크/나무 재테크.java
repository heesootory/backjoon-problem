import java.io.*;
import java.util.*;


public class Main {
    static class Tree implements Comparable<Tree>{
        int x, y;
        int age;
        boolean alive;
        Tree(int x, int y, int age, boolean alive){
            this.x = x;
            this.y = y;
            this.age = age;
            this.alive = alive;
        }
        @Override
        public int compareTo(Tree o){
            return this.age - o.age;
        }
    }
    static int N, M, K;
    static int[][] map_food;
    static int[][] ground;
    static int[][] nourish;
    static int x, y, z;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static PriorityQueue<Tree> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map_food = new int[N][N];       // 매년 나오는 양식
        ground = new int[N][N];         // 실제 땅

        for(int i = 0; i < N; i++) Arrays.fill(ground[i], 5);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j < N; j++){
                map_food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pq = new PriorityQueue<>();
        Queue<Tree> q = new LinkedList<>();

        // 나무 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            z = Integer.parseInt(st.nextToken());
            pq.add(new Tree(x,y,z,true));
        }

        for(int y = 0; y < K; y++){

            nourish = new int[N][N];
            int len = pq.size();
            for(int i = 0; i < len; i++){
                Tree t = pq.poll();

                if(ground[t.x][t.y] >= t.age){
                    ground[t.x][t.y] -= t.age;
                    t.age++;
                }else{
                    t.alive = false;
                    nourish[t.x][t.y] += t.age/2;
                }
                if(t.alive) q.add(t);
            }

            int q_len = q.size();
            for(int i =0 ; i < q_len; i++){
                Tree t = q.poll();

                if(t.age % 5 == 0){
                    for(int d = 0; d < 8; d++){
                        int nx = t.x + dx[d];
                        int ny = t.y + dy[d];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
                        pq.add(new Tree(nx, ny, 1, true));
                    }
                }
                pq.add(t);
            }
//            print();

            for(int i = 0; i < N; i++){
                for(int j =0 ; j < N; j++){
                    ground[i][j] += map_food[i][j];
                    ground[i][j] += nourish[i][j];
                }
            }
        }
        System.out.println(pq.size());

    }
    static void print(){
        for(Tree t : pq) System.out.print(t.x + " " + t.y + " " + t.age + "/ ");
        System.out.println();
    }


}

















