import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] height;
    static ArrayList<Integer>[] adjList;
    static int[] dp;
    static int dfs(int start){

        int max = 0;
        for(int i = 0; i < adjList[start].size(); i++){
            int next = adjList[start].get(i);

            if(height[next] > height[start]){
                if(dp[next] == -1) max = Math.max(max, dfs(next));
                else max = Math.max(max, dp[next]);
            }
        }
        return dp[start] = max + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        height = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) height[i] = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        for(int i = 1; i < N + 1; i++) dfs(i);
        for(int i = 1; i < N + 1; i++) System.out.println(dp[i]);

    }
}
