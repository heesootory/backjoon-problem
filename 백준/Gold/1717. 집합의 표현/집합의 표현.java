import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parents;

    static void make(){
        for(int i = 0; i < N+1; i++) parents[i] = i;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        make();

        for(int t = 0; t < M; t++){
            st = new StringTokenizer(br.readLine());

            int ver = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(ver == 1){
                System.out.println(find(a) == find(b) ? "YES" : "NO");
            }else{
                union(a,b);
            }
        }
    }
}

