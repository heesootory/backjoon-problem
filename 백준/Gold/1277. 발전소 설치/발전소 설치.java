import java.io.*;
import java.util.*;

class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Edge implements Comparable<Edge>{
    int to;
    double weight;
    Edge(int to, double weight){
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o){
        if(this.weight > o.weight) return 1;
        else if(this.weight == o.weight) return 0;
        else return -1;
    }
}

public class Main{
    static int INF = 987654321;
    static int N, W;
    static double M;
    static boolean[] visited;
    static double[] dist;
    static Node[] nodeArr;
    static double[][] adjArr;
    static double getLength(Node n1, Node n2){
        long d1 = n1.x - n2.x;
        long d2 = n1.y - n2.y;
        return Math.sqrt(d1 * d1 + d2 * d2);
    }

    // 간선없이 노드만 가지고 최단경로를 일단 뽑아냄.
    static void Dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(int i = 1; i < N + 1; i++){
                if(!visited[i] && adjArr[curr.to][i] != INF
                        && dist[i] > dist[curr.to] + adjArr[curr.to][i]){
                    dist[i] = dist[curr.to] + adjArr[curr.to][i];
                    pq.add(new Edge(i, dist[i]));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        M = Double.parseDouble(br.readLine());

        visited = new boolean[N + 1];
        dist = new double[N + 1];
        Arrays.fill(dist, INF);
        nodeArr = new Node[N + 1];
        adjArr = new double[N + 1][N + 1];
        for(int i = 1; i < N + 1; i++){
            Arrays.fill(adjArr[i], INF);
        }

        // 정점 정리
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodeArr[i] = new Node(x, y);
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if(i != j) {
                    double distance = getLength(nodeArr[i], nodeArr[j]);
                    if(distance <= M) adjArr[i][j] = distance;
                }
            }
        }

        // 간선 정리 -> 이미 존재하는 간선들의 가중치를 0으로 하면 무조건 이걸 연결하게됨. (이미 연결된 효과 만들기)
        for(int i = 0; i < W; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjArr[from][to] = adjArr[to][from] = 0;
        }

        Dijkstra(1);
        System.out.println((int)(dist[N] * 1000));

    }
}