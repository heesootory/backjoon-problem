import java.util.*;
import java.io.*;


public class Main{
    static int N, M;
    static int[] names;
    static int[][] dp;
    static int dfs(int name, int len){
        if(name >= N) return 0;     // 마지막 줄은 무조건 0

        int res = dp[name][len];
        if(res != -1) return res;

        // 같은 줄에 쓰는 경우.
        res = (M - len + 1) * (M - len + 1) + dfs(name + 1, names[name] + 1);

        // 다음 줄에 내려서 쓰는 경우.
        if(len + names[name] <= M)
            res = Math.min(res, dfs(name + 1, len + names[name] + 1));

        return dp[name][len] = res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        names = new int[1001];
        dp = new int[1001][1002];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            names[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 1001; i++) Arrays.fill(dp[i], -1);

        System.out.println(dfs(0, 0));

    }

}