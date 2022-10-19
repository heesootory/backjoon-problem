import java.io.*;
import java.util.*;

public class Main{
    static int N, k;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static void dfs(int idx, boolean big_jump, int sum){
        if(idx == N){
            if(sum < min) min = sum;
            return;
        }

        if(idx + 1 <= N) dfs(idx + 1, big_jump, sum + arr[0][idx]);
        if(idx + 2 <= N) dfs(idx + 2, big_jump, sum + arr[1][idx]);
        if(big_jump && idx + 3 <= N) dfs(idx + 3, false, sum + k);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[2][N];
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
        dfs(1, true, 0);
        System.out.println(min);
    }
}