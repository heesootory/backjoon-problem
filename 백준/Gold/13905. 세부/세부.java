import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int to;
    long weight;
    Edge(int to, long weight){
        this.to = to;
        this.weight = weight;
    }

    // 오름 차순으로 정렬.
    @Override
    public int compareTo(Edge o){
        return (this.weight - o.weight < 0) ? 1 : -1;
    }
}

public class Main{
    static int N, M;
    static int s, e;
    static boolean[] visited;
    static long[] dist;
    static ArrayList<Edge>[] adjList;

    static void Dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(Edge next : adjList[curr.to]){
                if(!visited[next.to] && dist[next.to] < Math.max(dist[next.to], Math.min(dist[curr.to], next.weight))){
                    dist[next.to] = Math.max(dist[next.to], Math.min(dist[curr.to], next.weight));
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
        visited = new boolean[N + 1];
        dist = new long[N + 1];
        adjList = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) adjList[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            adjList[h1].add(new Edge(h2, k));
            adjList[h2].add(new Edge(h1, k));
        }

        Dijkstra(s);
        System.out.println(dist[e]);

    }
}