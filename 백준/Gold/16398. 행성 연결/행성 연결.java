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
    static int[][] arr;
    static ArrayList<Edge>[] adjList;
    static boolean[] visited;

    static long Prim(int start){
        long ans = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.addAll(adjList[start]);
        visited[start] = true;
        int pick = 1;

        while(pick < N){
            Edge minEdge = pq.poll();
            if(visited[minEdge.to]) continue;

            visited[minEdge.to] = true;
            pq.addAll(adjList[minEdge.to]);
            ans += minEdge.weight;
            pick++;
        }

        return ans;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i < j) {
                    // 무향그래프로 인접리스트 만들어주기.
                    Edge edge1 = new Edge(i + 1, j + 1, arr[i][j]);
                    Edge edge2 = new Edge(j + 1, i + 1, arr[i][j]);
                    adjList[i + 1].add(edge1);
                    adjList[j + 1].add(edge2);
                }
            }
        }

        System.out.println(Prim(1));


    }
}