import java.io.*;
import java.util.*;

public class Solution {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){       //우선순위 큐는 나오는 방향을 기준으로 정렬.
            return this.weight - o.weight;
        }
    }
    static int V, E;
    static List<Edge>[] adjlist;
    static boolean[] visited;

    static long prim(int start){
        long ans = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 시작정점 뽑기
        visited[start] = true;

        // 정점에 해당하는 인접 정점을 우선순위 큐에 전부 집어넣기
        pq.addAll(adjlist[start]);

        int pick = 1;   // 확보한 정점의 갯수

        while(pick < V){
            Edge edge = pq.poll();

            if(visited[edge.to]) continue;      // 방문한 정점 제외

            ans += edge.weight;
            pq.addAll(adjlist[edge.to]);
            visited[edge.to] = true;
            pick++;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjlist = new ArrayList[V];
            for(int i = 0; i < V; i++) adjlist[i] = new ArrayList<>();
            visited = new boolean[V];

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                int weight = Integer.parseInt(st.nextToken());

                adjlist[from].add(new Edge(from, to, weight));
                adjlist[to].add(new Edge(to, from , weight));
            }

            System.out.printf("#%d %d\n", t, prim(1));
        }


    }
}
