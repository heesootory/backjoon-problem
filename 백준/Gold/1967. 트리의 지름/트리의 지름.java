import java.io.*;
import java.util.*;

class Node{
    int p, s, w;
    public Node(int p, int s, int w){
        this.p = p;
        this.s = s;
        this.w = w;
    }
}

public class Main{
    static int N;
    static ArrayList<Node>[] list;
    static int max = Integer.MIN_VALUE;
    static int arrive1;
    static boolean[] visited;

    static void dfs(int idx, int sum){
        if(sum > max) {
            max = sum;
            arrive1 = idx;
        }

        for(int i = 0; i < list[idx].size(); i++){
            int next = list[idx].get(i).s;
            if(visited[next]) continue;

            visited[next] = true;
            dfs(next, sum + list[idx].get(i).w);
            visited[next] = false;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int sun = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Node node1 = new Node(parent, sun, weight);
            Node node2 = new Node(sun, parent, weight);
            list[parent].add(node1);
            list[sun].add(node2);
        }

        // 1. 루트(1)에서 가장 긴 가지를 찾기
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1, 0);
        
        // 2. 첫번째 도착한 리프노드에서 가장 긴 가지를 찾으면 정답.
        visited = new boolean[N+1];
        visited[arrive1] = true;
        dfs(arrive1, 0);

        System.out.println(max);
    }
}