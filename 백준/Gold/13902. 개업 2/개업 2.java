import java.io.*;
import java.util.*;


public class Main {

    static int N, M, max_set;
    static int[] arr, dp;
    static HashSet<Integer> set = new HashSet<>();

    static void comb(int idx, int start, int end, int sum){
        if(idx == end) {
            set.add(sum);
            max_set = Math.max(max_set, sum);
            return;
        }


        for(int i = start; i < M; i++){
            comb(idx + 1, i + 1, end, sum + arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= 2; i++) comb(0, 0, i, 0);

        for(int s : set) {
            if(s <= N) dp[s] = 1;
        }
        for(int i = 1; i <= N; i++){
            if(dp[i] == 0){
                int min = Integer.MAX_VALUE;
                for(int s : set){
                    if(i - s >= 0 && dp[i - s] > 0){
                        min = Math.min(min, dp[i - s]);
                    }
                }
                dp[i] = (min == Integer.MAX_VALUE) ? 0 : min + 1;
            }
        }
//        for(int d : dp) System.out.print(d + " ");
//        System.out.println();
        System.out.println((dp[N] == 0) ? -1: dp[N]);
    }
}