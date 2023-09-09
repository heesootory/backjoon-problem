import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static ArrayList<Integer>[] adjList;
    static int[] smallCount;
    static int[] bigCount;
    static boolean[] visited;

    static void bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        visited[idx] = true;
        queue.add(idx);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int next : adjList[curr]){
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(next);
                bigCount[idx]++;
                smallCount[next]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) adjList[i] = new ArrayList<>();
        smallCount = new int[N + 1];
        bigCount = new int[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
        }

        for(int i = 1; i < N + 1; i++){
            bfs(i);
        }

        int ans = 0;
        for(int i = 0; i < N + 1; i++){
            if(smallCount[i] + bigCount[i] == N - 1) ans++;
        }

        System.out.println(ans);
    }
}
