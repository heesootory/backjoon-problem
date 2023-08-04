import javax.xml.transform.stax.StAXResult;
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int a, b, c;
    ArrayList<Integer> list = new ArrayList<>();
    Edge(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
        list.add(0);
    }
    @Override
    public int compareTo(Edge o){
        return this.c - o.c;
    }
}
public class Main{
    static int N, M, A, B, C;
    static boolean[] visited;
    static int[] dist;
    static int[] shame;
    static ArrayList<Edge>[] adjList;
    static void Dijkstra(int start, int limit){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(-1, start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(visited[curr.b]) continue;
            visited[curr.b] = true;

            for(Edge next : adjList[curr.b]){
                if(!visited[next.b] && dist[next.b] > dist[curr.b] + next.c && dist[curr.b] + next.c <= limit){
                    dist[next.b] = dist[curr.b] + next.c;
                    Edge ee = new Edge(next.a, next.b, dist[next.b]);
                    ee.list.addAll(curr.list);
                    ee.list.add(next.c);
                    if(shame[ee.b] > Collections.max(ee.list)) shame[ee.b] = Collections.max(ee.list);
//                    for(int i : ee.list) System.out.print(i  + " ");
//                    System.out.println();
                    pq.add(ee);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList<>();
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        shame = new int[N + 1];
        Arrays.fill(shame, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Edge e1 = new Edge(a, b, c);
            Edge e2 = new Edge(b, a, c);
            adjList[a].add(e1);
            adjList[b].add(e2);
        }

        Dijkstra(A, C);
//        for(int i : dist) System.out.print(i + " ");
//        System.out.println();
//        for(int i : shame) System.out.print(i + " ");
//        System.out.println();
        System.out.println(shame[B] == Integer.MAX_VALUE ? -1 : shame[B]);


    }
}