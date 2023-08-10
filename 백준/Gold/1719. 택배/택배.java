import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static final int INF = 987654321;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        for(int i = 0; i < N + 1; i++){
            for(int j = 0; j < N + 1; j++){
                if(i == j) dp[i][j] = 0;
                else dp[i][j] = INF;
            }
        }
        int[][] ans = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dp[from][to] = dp[to][from] = weight;
            ans[from][to] = to;
            ans[to][from] = from;
        }


        for(int k = 1; k < N + 1; k++){
            for(int s = 1; s < N + 1; s++){
                for(int e = 1; e < N + 1; e++){
                    if(dp[s][e] > dp[s][k] + dp[k][e]){
                        dp[s][e] = dp[s][k] + dp[k][e];
                        ans[s][e] = k;
                    }
                }
            }
//            System.out.println("k : ====> " + k);
//            for(int i = 1; i < N + 1; i++){
//                for(int j = 1; j < N + 1; j++){
//
//                    System.out.print(dp[i][j] == INF ? -1 + " " : dp[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

//        System.out.println();
//        System.out.println();

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if(i == j) System.out.print("- ");
                else{
                    int k = j;
                    while(ans[i][k] != k){
                        k = ans[i][k];
                    }
                    System.out.print(k + " ");
                }
            }
            System.out.println();
        }

    }
}
