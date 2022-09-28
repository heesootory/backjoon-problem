import java.io.*;
import java.util.*;


/**
 * 다익스트라 알고리즘
 * - 인접 리스트. / 유향 그래프시
 */

public class Main {
    static class Edge implements Comparable<Edge>{
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
    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static List<Edge>[] list;
    static int[] dist;
    static boolean[] visited;
    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(visited[now.to]) continue;

            visited[now.to] = true;
            for(Edge next : list[now.to]){
                if(!visited[next.to] && dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int start = 0;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken())-1;

            list = new ArrayList[V];
            for(int i = 0; i < V; i++) list[i] = new ArrayList<>();
            dist = new int[V];
            Arrays.fill(dist, INF);
            visited = new boolean[V];

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());

                int to = Integer.parseInt(st.nextToken())-1;
                int from = Integer.parseInt(st.nextToken())-1;
                int weight = Integer.parseInt(st.nextToken());

                list[from].add(new Edge(to, weight));
            }

            dijkstra(start);

            int cnt = 0;
            int ans = 0;
            for(int i : dist){
                if(i != INF){
                    cnt++;
                    ans = Math.max(ans, i);
                }
            }
            System.out.println(cnt + " " + ans);
        }

    }
}
