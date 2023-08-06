import java.io.*;
import java.util.*;

class House implements Comparable<House>{
    int to, weight;

    House(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(House o){
        return this.weight - o.weight;
    }
}

public class Main{
    static int n ,m;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<House>[] adjList;

    static int Prim(int start){
        int sum = 0;
        int cnt = 0;
        PriorityQueue<House> pq  = new PriorityQueue<>();
        pq.add(new House(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty() && cnt < n){
            House curr = pq.poll();

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            sum += dist[curr.to];
            cnt++;

            for(House next : adjList[curr.to]) {
                if (!visited[next.to] && dist[next.to] > next.weight) {
                    dist[next.to] = next.weight;
                    pq.add(next);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            visited = new boolean[n];
            dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

            int total = 0;
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                total += weight;
                adjList[from].add(new House(to, weight));
                adjList[to].add(new House(from, weight));
            }

            System.out.println(total - Prim(0));
        }

    }
}