import java.io.*;
import java.util.*;


public class Main{
    static int N, M;
    static int[] parents, plans;
    static int[][] arr;
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
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        parents = new int[N];
        plans = new int[M];
        make();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) union(i,j);
            }
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            plans[i] = Integer.parseInt(st.nextToken()) - 1;
            if(i > 0){
                if(find(plans[i]) != find(plans[i-1])) flag = false;
            }
        }

        System.out.println((flag) ? "YES" : "NO");

    }
}