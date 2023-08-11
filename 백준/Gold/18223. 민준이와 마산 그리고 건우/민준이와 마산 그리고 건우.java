import java.io.*;
import java.util.*;



public class Main {
    static final int INF = 987654321;
    static int V, E, P;
    static class Edge implements Comparable<Edge>{
        int to, cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Edge>[] adjList;
    static void Dijkstra(int start){
        dist = new int[E + 1];
        Arrays.fill(dist, INF);
        visited = new boolean[E + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(curr.to == E) break;

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(Edge next : adjList[curr.to]){
                if(!visited[next.to] && dist[next.to] > dist[curr.to] + next.cost){
                    dist[next.to] = dist[curr.to] + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[E + 1];
        for(int i = 1; i < E + 1; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to, cost));
            adjList[to].add(new Edge(from, cost));
        }

        Dijkstra(1);
        int minLen = dist[E];
        int saveLen = dist[P];
        Dijkstra(P);
        saveLen += dist[E];

        System.out.println((saveLen <= minLen) ? "SAVE HIM" : "GOOD BYE");

    }
}
