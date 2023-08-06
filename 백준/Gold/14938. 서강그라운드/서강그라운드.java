import java.io.*;
import java.util.*;

class Ground implements Comparable<Ground>{
    int to, weight;

    Ground(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Ground o){
        return this.weight - o.weight;
    }
}

public class Main{
    static int n, m, r;
    static int[] itemArr;
    static int[] ansArr;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Ground>[] adjList;
    static int Dijkstra(int start){
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Ground> pq = new PriorityQueue<>();
        pq.add(new Ground(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Ground curr = pq.poll();
            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            for(Ground next : adjList[curr.to]){
                if(!visited[next.to] && dist[next.to] > dist[curr.to] + next.weight){
                    dist[next.to] = dist[curr.to] + next.weight;
                    pq.add(new Ground(next.to, dist[next.to]));
                }
            }
        }

        int sum = 0;
        for(int i = 1; i < n + 1; i++){
            if(dist[i] <= m) sum += itemArr[i];
        }
        return sum;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        ansArr = new int[n + 1];
        itemArr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) itemArr[i] = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Ground(to, weight));
            adjList[to].add(new Ground(from, weight));

        }

        for(int i = 1; i < n + 1; i++){
            ansArr[i] = Dijkstra(i);
        }
        Arrays.sort(ansArr);
        System.out.println(ansArr[n]);

    }
}