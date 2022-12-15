import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] dp;
    static ArrayList<Integer>[][] list;     // 경유지 리스트를 저장할 배열.
    static final int INF = 123456789;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        list = new ArrayList[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n+1; j++){
                list[i][j] = new ArrayList<Integer>();
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++){
                if(i != j) dp[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 같은 경로이지만, 다른 비용이 입력값으로 주어질 수 있음.
            if(cost < dp[start][end]) dp[start][end] = cost;
        }

        // 플로이드-워셜
        for(int k = 1; k < n + 1; k++){     // 경
            for(int i = 1; i < n + 1; i++){     // 출
                for(int j = 1; j < n + 1; j++){     // 도
                    if(dp[i][k] + dp[k][j] < dp[i][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                        // 경유지 모두 추가하기.
                        list[i][j].clear();
                        // 출발지 ~ 경유지까지의 루트 + 경유지(k) +  경유지 ~ 도착지까지의 루트 모두 경유지로 추가.
                        for(int a = 0; a < list[i][k].size(); a++) list[i][j].add(list[i][k].get(a));
                        list[i][j].add(k);
                        for(int b = 0; b < list[k][j].size(); b++) list[i][j].add(list[k][j].get(b));
                    }
                }
            }
        }

        // 최단경로 출력
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                // 지나갈수 없는 경로 일때 갱신이 아예 안되므로, 0으로 처리
                if(dp[i][j] == INF) dp[i][j] = 0;
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // 경유지 출력
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(dp[i][j] == 0) System.out.print(0);
                else{
                    System.out.print((list[i][j].size() + 2)+ " ");
                    System.out.print(i + " ");
                    for(int k = 0; k < list[i][j].size(); k++) System.out.print(list[i][j].get(k) + " ");
                    System.out.print(j);
                }
                System.out.println();
            }
        }


    }
}