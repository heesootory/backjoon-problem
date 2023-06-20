import java.util.*;
import java.io.*;


public class Main{
    static int C;
    static int[][] arr;
    static int[] perm;
    static boolean[] visited;
    static int max;

    static void dfs(int idx){
        if(idx == 11){
            int sum = 0;
            for(int i = 0 ; i < 11; i++){
                sum += perm[i];
            }
            max = Math.max(max, sum);
        }

        for(int i = 0; i < 11; i++){
            if(visited[i] || arr[idx][i] == 0) continue;

            perm[idx] = arr[idx][i];
            visited[i] = true;
            dfs(idx + 1);
            visited[i] = false;
        }

    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());

        for(int c = 0; c < C; c++){
            max = 0;
            arr = new int[11][11];

            for(int i = 0 ;i < 11; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 11; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            perm = new int[11];
            visited = new boolean[11];

            dfs(0);
            System.out.println(max);
        }

    }
}