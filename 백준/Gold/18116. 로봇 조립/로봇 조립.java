import java.io.*;
import java.util.*;


public class Main{
    static int N;
    static final int M = 1000001;
    static int[] parents, counts;
    static StringBuilder sb = new StringBuilder();

    static void make(){
        for(int i = 1; i < M; i++) {
            parents[i] = i;
            counts[i] = 1;      // 모든 대표자 노드의 갯수를 1개로 설정.
        }
    }
    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        counts[aRoot] += counts[bRoot];     // b그룹의 갯수를 a그룹의 갯수에 더해버린다.
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[M];
        counts = new int[M];
        make();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String in = st.nextToken();
            if(in.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            else{
                int n = Integer.parseInt(st.nextToken());
                sb.append(counts[find(n)] + "\n");
            }
        }
        System.out.println(sb);
    }
}