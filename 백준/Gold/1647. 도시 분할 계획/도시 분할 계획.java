import java.io.*;
import java.util.*;


/**
 * 크루스칼
 */

public class Main{
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
    static int N, M;
    static int[] parents;
    static List<Edge> edgelist;
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
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        edgelist = new ArrayList<>();
        make();

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            edgelist.add(new Edge(from, to, weight));
        }
        Collections.sort(edgelist);

        int cnt = 0;
        int result = 0;
        for(Edge e : edgelist){
            if(union(e.from, e.to)){
                result += e.weight;
                cnt++;
            }
            if(cnt == N - 2) break;
        }
        System.out.println(result);
    }
}