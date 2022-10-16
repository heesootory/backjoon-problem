import java.io.*;
import java.util.*;


/**
 * 다익스트라
 */

public class Main{
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
    static int N, M;
    static List<Edge>[] list;   // 간선 배열.
    static int[] dist;      // 최단 경로들의 가중치 저장.
    static int[] pre;       // 최단 경로 직전의 노드 저장.
    static final int INF = Integer.MAX_VALUE;
    static int end;
    static void Dijkstra(int st){
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(st, 0));        // 임의의 출발점을 향하는 간선 집어넣기.
        dist[st] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if(visited[now.to]) continue;

            visited[now.to] = true;
            for(Edge next: list[now.to]){
                if(!visited[next.to] && dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;     // 최소 가중치로 갱신.
                    pre[next.to] = now.to;      // 갱신된 간선의 출발지에 해당하는 노드를 저장.
                    pq.add(new Edge(next.to, dist[next.to]));     // pq에 경유하는 간선 삽입.
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();
        dist = new int[N+1];
        pre = new int[N+1];
        Arrays.fill(dist, INF);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Dijkstra(start);
        System.out.println(dist[end]);
        // 스택에 집어 넣으며, 경로수 세기.
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        while(end != 0){
            stack.add(end);
            end = pre[end];
            cnt++;
        }
        System.out.println(cnt);
        // 스택에서 빼내며, 경로 복원.
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }
}