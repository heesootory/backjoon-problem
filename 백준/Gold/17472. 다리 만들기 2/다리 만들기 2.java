import java.io.*;
import java.util.*;


public class Main {
    static class Edge implements Comparable<Edge>{
        int from, to, dist;
        Edge(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge o){
            return this.dist - o.dist;
        }
    }
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Edge> edgelist;
    static int[] parents;
    static void bfs(Pair start, int idx){
        visited = new boolean[N][M];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        map[start.x][start.y] = idx;
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();

            for(int d = 0; d < 4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == -1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = idx;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }

    static void make_edge(Pair p){

        for(int d = 0; d < 4; d++){
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];

            while(true){
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;

                if(map[nx][ny] != 0){
                    if(map[nx][ny] != map[p.x][p.y]){
                        if(Math.abs((nx - p.x) + (ny - p.y)) > 2){
                            edgelist.add(new Edge(map[p.x][p.y], map[nx][ny], Math.abs((nx - p.x) + (ny - p.y))-1));
                            break;
                        }
                        else break;
                    }
                    else break;
                }
                nx += dx[d];
                ny += dy[d];
            }

        }
        
    }
    static void make(){
        for(int i = 1; i < count + 1; i++){
            parents[i] = i;
        }
    }
    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    static boolean union(int a, int b){
        if(find(a) == find(b)) return false;
        parents[find(b)] = find(a);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        edgelist = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++){
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = (input == 1) ? -1 : 0;
            }
        }
        // 섬 표시해주기
        int idx = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M ; j++){
                if(map[i][j] == -1){
                    idx++;
                    bfs(new Pair(i, j), idx);
                    count++;
                }
            }
        }

//        print();

        // 간선 연결하기.
        for(int i =0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0){
                    make_edge(new Pair(i, j));
                }
            }
        }


        parents = new int[count+1];
        make();
        Collections.sort(edgelist);

//        for(Edge e : edgelist) System.out.println(e.from + " " + e.to + " " + e.dist);

        int sum = 0;
        int cnt = 0;
        for(Edge edge : edgelist){
            if(union(edge.from, edge.to)){
                sum += (edge.dist);
                if(++cnt == count - 1) break;
            }
        }

        System.out.println((cnt < count - 1) ? -1 : sum);
    }

//    static void print(){
//        for(int[] i : map){
//            for(int j : i) System.out.print(j + " ");
//            System.out.println();
//        }
//    }
}


