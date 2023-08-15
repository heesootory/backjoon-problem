import java.io.*;
import java.util.*;


class Edge {
    int to, weight;
    Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}
public class Main {
    static int T, N, M, K;
    static int[][] dp;
    static final int INF = 987654321;
    static int[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new int[N + 1][N + 1];
            for(int i = 0; i < N + 1; i++) Arrays.fill(dp[i], INF);

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int from =Integer.parseInt(st.nextToken());
                int to =Integer.parseInt(st.nextToken());
                int weight =Integer.parseInt(st.nextToken());

                dp[from][to] = weight;
                dp[to][from] = weight;
            }
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            friends = new int[K];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < K; i++) friends[i] = Integer.parseInt(st.nextToken());


            for(int k = 1; k < N + 1; k++){
                for(int s = 1; s < N + 1; s++){
                    for(int e = 1; e < N + 1; e++){
                        if(s == e) dp[s][e] = 0;
                        else dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k][e]);
                    }
                }
            }

            int[] ans = new int[N + 1];
            for(int i = 1; i < N + 1; i++){
                for(int j : friends){
                    ans[i] += dp[j][i];
                }
            }

//            System.out.println(Arrays.toString(ans));

            int min = INF;
            int answer = 0;
            for(int i = 1; i < N + 1; i++) {
                if(ans[i] < min) {
                    min = ans[i];
                    answer = i;
                }
            }

            System.out.println(answer);
        }



    }
}
