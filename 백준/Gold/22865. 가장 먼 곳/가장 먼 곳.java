import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int to;
    int weight;

    Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o){
        return this.weight - o.weight;
    }
}

public class Main{
    static final int INF = 987654321;
    static int N, M;
    static int[] ABC;
    static boolean[] visited;
    static int[][] dist;
    static ArrayList<Edge>[] adjList;
    static void Dijkstra(int idx, int start){
        visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[idx][start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(Edge next : adjList[curr.to]){
                if(!visited[next.to] && dist[idx][next.to] > dist[idx][curr.to] + next.weight){
                    dist[idx][next.to] = dist[idx][curr.to] + next.weight;
                    pq.add(new Edge(next.to, dist[idx][next.to]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ABC = new int[3];
        dist = new int[3][N + 1];
        for(int i = 0; i < 3; i++) Arrays.fill(dist[i], INF);
        adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            int abc = Integer.parseInt(st.nextToken());
            ABC[i] = abc;
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new Edge(to, weight));
            adjList[to].add(new Edge(from, weight));
        }

        for(int i = 0; i < 3; i++){
            Dijkstra(i, ABC[i]);
        }

//        for(int i = 0; i < 3; i++){
//            for(int j = 0; j < N + 1; j++){
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = -1;
        int ans = -1;
        for(int i = 1; i < N + 1; i++){
            int len = Math.min(dist[0][i], Math.min(dist[1][i], dist[2][i]));
            if(len > max) {
                max = len;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}