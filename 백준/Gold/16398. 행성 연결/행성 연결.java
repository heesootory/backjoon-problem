import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
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

public class Main{
    static int N;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Edge>[] adjList;

    static long Prim(Edge start){
        long sum = 0;
        int cnt = 0;

        pq.add(start);
        dist[0] = 0;

        while(!pq.isEmpty() || cnt < N){
            Edge curr = pq.poll();
            if(visited[curr.to]) continue;

            visited[curr.to] = true;
            sum += dist[curr.to];
            cnt++;

            for(Edge edge : adjList[curr.to]){
                if(!visited[edge.to] && dist[edge.to] > edge.weight){
                    dist[edge.to] = edge.weight;
                    pq.add(edge);
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        pq = new PriorityQueue<>();
        visited = new boolean[N];
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        adjList = new ArrayList[N];
        for(int i = 0; i < N; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int weight = Integer.parseInt(st.nextToken());
                adjList[i].add(new Edge(i, j, weight));
                adjList[j].add(new Edge(j, i, weight));
            }
        }

        System.out.println(Prim(new Edge(-1,0,0)));


    }
}