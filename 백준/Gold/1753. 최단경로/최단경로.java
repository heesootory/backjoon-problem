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

    static int V, E, K;
    static int INF = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Edge>[] adjList;
    static void Djkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(Edge next: adjList[curr.to]){
                if(!visited[next.to] && dist[next.to] > dist[curr.to] + next.weight){
                    dist[next.to] = dist[curr.to] + next.weight;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        adjList = new ArrayList[V + 1];
        for(int i = 0; i < V + 1; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[s].add(new Edge(e, w));
        }

        Djkstra(K);

        for(int i = 1; i < V + 1; i++){
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }


    }
}
