import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static final int mod = 10007;
    static List<Integer>[] list;

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dp = new int[N + 1][H + 1];

        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < H + 1;j++){
                dp[i][j] = dp[i-1][j];
                for(int k = 0; k < list[i].size(); k++){
                    int before = j - list[i].get(k);
                    if( before >= 0) {
                        dp[i][j] += dp[i-1][before];
                        dp[i][j] %= mod;
                    }
                    if(list[i].get(k) == j) dp[i][j]++;
                }
            }
        }
        
        System.out.println(dp[N][H]);

    }
}