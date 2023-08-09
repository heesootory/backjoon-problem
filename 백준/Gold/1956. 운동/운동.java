import java.io.*;
import java.util.*;

public class Main{
    static int V, E;
    static int[][] dp;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dp = new int[V + 1][V + 1];
        for(int i = 1; i < V + 1; i++) Arrays.fill(dp[i], INF);

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dp[from][to] = cost;
        }

        for(int k = 1; k < V + 1; k++){
            for(int s = 1; s < V + 1; s++){
                for(int e = 1; e < V + 1; e++){
                    if(s != e) dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k][e]);
                }
            }
        }

        int ans = INF;
        for(int i = 1; i < V + 1; i++){
            for(int j = 1; j < V + 1; j++){
                if(i < j){
                    if(dp[i][j] != INF && dp[j][i] != INF) {
                        ans = Math.min(ans, dp[i][j] + dp[j][i]);
                    }
                }
            }
        }

        System.out.println(ans == INF ? -1 : ans);
    }
}