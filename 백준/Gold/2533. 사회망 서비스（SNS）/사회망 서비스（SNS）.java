import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static ArrayList<Integer>[] adjList;
    static int[][] dp;
    static void dfs(int curr, int parent){
        dp[curr][0] = 0;
        dp[curr][1] = 1;

        for(int next : adjList[curr]){
            if(next == parent) continue;
            dfs(next, curr);
            dp[curr][0] += dp[next][1];
            dp[curr][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList<>();
        dp = new int[N + 1][2];

        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }
}