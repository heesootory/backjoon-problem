import java.io.*;
import java.util.*;

/**
 * 프림
 */
public class Main{
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
    static int N, M;
    static List<Edge>[] list;
    static boolean[] visited;
    static long prim(int start){
        long ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[start] = true;
        pq.addAll(list[start]);

        int p = 1;
        while(p < N){
            Edge e = pq.poll();
            if(visited[e.to]) continue;

            visited[e.to] = true;
            ans += e.weight;
            pq.addAll(list[e.to]);
            p++;
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        list = new ArrayList[N];
        for(int i = 0; i < N; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            // 무향그래프이므로, 간선 양쪽으로 모두 집어넣기.
            list[from].add(new Edge(from, to, weight));
            list[to].add(new Edge(to, from, weight));
        }

        System.out.println(prim(0));
    }
}