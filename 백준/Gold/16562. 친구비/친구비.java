import java.io.*;
import java.util.*;


public class Main{
    static int N, M, K;
    static int[] parents;
    static int[] costs;

    static void make(){
        for(int i = 0; i < N; i++) parents[i] = i;
    }

    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());       // 연결되어 있는 간선의 갯수.
        K = Integer.parseInt(st.nextToken());

        parents = new int[N];
        costs = new int[N];
        make();
        int[] min = new int[N];
        Arrays.fill(min, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) costs[i] = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            union(a, b);        // 친구관계 전부 설정.
        }

        // 친구 그룹마다 최소 비용을 찾기.
        for(int i = 0; i < N; i++){
            int root = find(i);
            min[root] = Math.min(costs[i], min[root]);
        }

        // 모든 그룹의 최소 친구가격 총합.
        int sum = 0;
        for(int i : min) {
            if(i != Integer.MAX_VALUE) sum += i;
        }

        System.out.println((sum > K) ? "Oh no" : sum);

    }
}