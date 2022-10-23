import java.io.*;
import java.util.*;

public class Main{
    static class Edge{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static int N, M, K;
    static int[] parents;
    static List<Edge> list;
    static int[] ans;

    static void make(){
        for(int i = 0; i < N; i++) parents[i] = i;
    }

    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
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
        K = Integer.parseInt(st.nextToken());

        ans = new int[K];
        parents = new int[N];
        list = new ArrayList<>();

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            list.add(new Edge(from, to, i));
        }

        // 가중치가 들어온 순서이므로, 따로 오름차순 할 필요x.

        for(int k = 0; k < K; k++){
            make();
            int sum = 0;    // mst 가중치의 합.
            int cnt = 0;
            for(int i = k; i < M; i++){
                Edge e = list.get(i);
                if(union(e.from, e.to)){
                    sum += e.weight;
                    if(++cnt == N - 1) break;
                }
            }
            if(cnt == N-1) ans[k] = sum;
        }

        for(int a : ans) System.out.print(a + " ");

    }
}