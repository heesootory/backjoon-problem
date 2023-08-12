import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int to, weight;
    Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o){
        return this.weight - o.weight;
    }
}

public class Main {
    static int N, M, X, Y;
    static final int INF = 987654321;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Edge>[] adjList;
    static int[] route;
    static void Dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(Edge next : adjList[curr.to]){
                if(!visited[next.to] && dist[next.to] > dist[curr.to] + next.weight){
                    dist[next.to] = dist[curr.to] + next.weight;
                    route[next.to] = curr.to;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        dist = new int[N];
        Arrays.fill(dist, INF);
        visited = new boolean[N];
        adjList = new ArrayList[N];
        for(int i = 0; i < N; i++) adjList[i] = new ArrayList<>();
        route = new int[N];
        Arrays.fill(route, -1);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to, weight));
            adjList[to].add(new Edge(from, weight));
        }

        Dijkstra(Y);

        Arrays.sort(dist);
        int day = 1;
        int sum = 0;
        boolean flag = true;
        for(int i : dist) {
            if(i * 2 > X){
                System.out.println(-1);
                return;
            }
        }
        for(int i = 0; i < N; i++){

            if(sum + dist[i] * 2 <= X) sum += (dist[i] * 2);
            else{
                sum = dist[i] * 2;
                day++;
            }

        }

        System.out.println(day);

    }
}
