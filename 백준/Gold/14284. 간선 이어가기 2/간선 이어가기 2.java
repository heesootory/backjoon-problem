import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int from, to;
    long weight;
    Edge(int from, int to, long weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o){
        return (int)(this.weight - o.weight);
    }
}

public class Main{
    static int n, m;
    static ArrayList<Edge>[] adjList;
    static boolean[] visited;
    static long[] dist;

    static void Dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(-1, start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(curr.to == end) break;

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(Edge next : adjList[curr.to]){
                if(!visited[next.to] && dist[next.to] > dist[curr.to] + next.weight){
                    dist[next.to] = dist[curr.to] + next.weight;
                    pq.add(new Edge(next.from, next.to, dist[next.to]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) adjList[i] = new ArrayList<>();
        visited = new boolean[n + 1];
        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Edge e1 = new Edge(from, to, weight);
            Edge e2 = new Edge(to, from, weight);
            adjList[from].add(e1);
            adjList[to].add(e2);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(start, end);
        System.out.println(dist[end]);
    }
}