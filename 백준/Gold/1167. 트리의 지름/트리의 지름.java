import java.io.*;
import java.util.*;

public class Main {

    static class Dist{
        int to;
        int len;
        Dist(int to, int len){
            this.to = to;
            this.len = len;
        }
    }

    static int N;
    static List<Dist>[] list;
    static int[] max_arr;
    static boolean[] check;
    static int max;
    static int arrive;

    static void dfs(int idx, int sum){
        // 가장 긴 리프노드의 도착지와 거리 저장
        if(max <= sum){
            arrive = idx;
            max = sum;
        }

        for(Dist next : list[idx]){
            if(!check[next.to]) {
                check[next.to] = true;
                dfs(next.to, sum + next.len);
                check[next.to] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        max_arr = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();
        check = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while(true){
                int input = Integer.parseInt(st.nextToken());
                if(input == -1) break;
                int l = Integer.parseInt(st.nextToken());
                list[idx].add(new Dist(input, l));
            }
        }

        for(int i = 1; i <= N; i++){
            if(list[i].size() == 1){
                check[i] = true;
                dfs(i, 0);
                check[i] = false;
                break;
            }
        }

        check[arrive] = true;
        dfs(arrive, 0);

        System.out.println(max);
    }
}