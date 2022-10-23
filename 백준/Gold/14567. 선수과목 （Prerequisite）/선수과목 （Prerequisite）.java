import java.io.*;
import java.util.*;

/**
 * 위상정렬
 */

public class Main{
    static int[] in_degree;
    static List<Integer>[] list;
    static int N, M;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] ans;
    static void bfs(){
        int idx = 1;
        while(!queue.isEmpty()){
            int len = queue.size();

            for(int q = 0; q < len; q++){
                int now = queue.poll();
                ans[now] = idx;

                for(int i : list[now]){
                    in_degree[i]--;
                    if(in_degree[i] == 0) queue.add(i);
                }
            }

            idx++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        in_degree = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) list[i] = new ArrayList<>();
        ans = new int[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            in_degree[out]++;
            list[in].add(out);
        }

        for(int i = 1; i < in_degree.length; i++){
            if(in_degree[i] == 0) queue.add(i);
        }

        bfs();
        for(int i = 1; i < N+1; i++) System.out.print(ans[i] + " ");
    }
}