import java.io.*;
import java.sql.Array;
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
public class Main{
    static int N, E;
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Edge>[] adjList;

    static int Dijkstra(int start, int end){
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(curr.to == end) break;

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(Edge next : adjList[curr.to]){
                if(!visited[next.to] && dist[next.to] > dist[curr.to] + next.weight){
                    dist[next.to] = dist[curr.to] + next.weight;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Edge e1 = new Edge(to, weight);
            Edge e2 = new Edge(from, weight);
            adjList[from].add(e1);
            adjList[to].add(e2);
        }

        st = new StringTokenizer(br.readLine());
        int ess1 = Integer.parseInt(st.nextToken());
        int ess2 = Integer.parseInt(st.nextToken());

        boolean flag = true;

        int ans1 = Dijkstra(1, ess1);
        int ans2 = Dijkstra(ess1, ess2);
        int ans3 = Dijkstra(ess2, N);

        if(ans1 == INF || ans2 == INF || ans3 == INF) flag = false;

        int ans4 = Dijkstra(1, ess2);
        int ans5 = Dijkstra(ess2, ess1);
        int ans6 = Dijkstra(ess1, N);

        if(ans4 == INF || ans5 == INF || ans6 == INF) flag = false;

        System.out.println(flag ? Math.min(ans1 + ans2 + ans3, ans4 + ans5 + ans6) : -1);

    }
}