import java.io.*;
import java.util.*;

public class Main{
    static class Edge implements Comparable<Edge>{
        int to,w;
        Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o){
            return this.w - o.w;
        }

    }
    static int N, M;
    static List<Edge>[] list;
    static int[] dist;

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(visited[now.to]) continue;

            visited[now.to] = true;
            for(Edge next : list[now.to]){
                if(!visited[next.to] && dist[next.to] > dist[now.to] + next.w){
                    dist[next.to] = dist[now.to] + next.w;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for(int i = 0; i < N; i++) list[i] = new ArrayList<>();
        dist = new int[N];
        Arrays.fill(dist, 987654321);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, weight));
            list[end].add(new Edge(start, weight));
        }

        dijkstra(0);
        System.out.println(dist[N-1]);

    }
}