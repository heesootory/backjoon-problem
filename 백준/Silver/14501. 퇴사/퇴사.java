import java.util.*;
import java.io.*;


public class Main{
    static int N;
    static int[][] schedule;
    static int max = 0;
    static void dfs(int idx, int sum){
        max = Math.max(max, sum);

        for(int i = idx + schedule[idx][0]; i < N + 1; i++){
            if(i + schedule[i][0] - 1 <= N) dfs(i, sum + schedule[i][1]);
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        schedule = new int[N+1][2];

        for(int n = 1 ;n < N+1; n++){
            st = new StringTokenizer(br.readLine());
            schedule[n][0] = Integer.parseInt(st.nextToken());
            schedule[n][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N+1; i++){
            if(i + schedule[i][0] - 1 <= N) dfs(i, schedule[i][1]);
        }

        System.out.println(max);

    }
}