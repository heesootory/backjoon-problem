import java.io.*;
import java.util.*;

class Pair{
    int depart;
    int weight;

    Pair(int depart, int weight){
        this.depart = depart;
        this.weight = weight;
    }
}

public class Main {
    static int INF = Integer.MIN_VALUE;
    static int N, M, K;
    static ArrayList<Pair>[] list;
    static int[][] dp;
    static int dfs(int arrive, int passingby){
        if(passingby == 1 && arrive != 1) return INF;
        if(dp[arrive][passingby] != INF) return dp[arrive][passingby];

        int max = INF;
        for(int i = 0; i < list[arrive].size(); i++){
            int start = list[arrive].get(i).depart;
            int dinner = list[arrive].get(i).weight;
            int postMax = dfs(start, passingby - 1);
            if(postMax + dinner > max) max = postMax + dinner;
        }

        return dp[arrive][passingby] = max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();
        dp = new int[N + 1][M + 1];
        for(int i = 0; i < N + 1; i++) Arrays.fill(dp[i], INF);
        dp[1][1] = 0;

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a < b) list[b].add(new Pair(a, c));
        }

        int ans = 0;
        for(int i = 1; i <= M; i++) {
            ans = Math.max(ans, dfs(N, i));
        }

        System.out.println(ans);

//        for(int i = 0; i < N + 1; i++){
//            for(int j = 0; j < M + 1; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}
