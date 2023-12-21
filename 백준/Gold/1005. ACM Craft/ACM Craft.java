import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        int ver;
        int time;

        public Node(int ver, int time){
            this.ver = ver;
            this.time = time;
        }
    }
    static int T, N, K, W;
    static int[] timeArr;
    static ArrayList<Integer>[] adjList;
    static int[] inDegree;
    static int[] dp;
    static void topologySort(){
        Queue<Node> queue = new LinkedList<>();

        for(int i = 1; i < N + 1; i++){
            if(inDegree[i] == 0) {
                dp[i] = Math.max(dp[i], timeArr[i]);
                queue.offer(new Node(i, timeArr[i]));
            }
        }

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for(int j : adjList[curr.ver]){
                dp[j] = Math.max(dp[j], curr.time + timeArr[j]);
                if(--inDegree[j] == 0) queue.offer(new Node(j, dp[j]));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            timeArr = new int[N + 1];
            adjList = new ArrayList[N + 1];
            for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList<>();
            inDegree = new int[N + 1];
            dp = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for(int n = 1; n < N + 1; n++){
                timeArr[n] = Integer.parseInt(st.nextToken());
            }

            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adjList[s].add(e);
                inDegree[e]++;
            }

            W = Integer.parseInt(br.readLine());
            topologySort();
//            for(int i : dp) System.out.print(i + " ");

            System.out.println(dp[W]);
        }

    }
}