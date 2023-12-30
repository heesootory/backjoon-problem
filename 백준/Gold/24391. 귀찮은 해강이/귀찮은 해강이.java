import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] building;
    static void make(){
        for(int i = 1; i < N + 1; i++) building[i] = i;
    }
    static int find(int a){
        if(building[a] == a) return a;
        return building[a] = find(building[a]);
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        if(bRoot < aRoot) building[aRoot] = bRoot;
        else building[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        building = new int[N + 1];
        make();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            union(num1, num2);
        }

//        print(building);

        int ans = 0;
        int curr = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(find(curr) != find(num)) ans++;
            curr = num;
        }
        System.out.println(ans - 1);
    }
//    static void print(int[] arr){
//        for(int i : arr) System.out.print(i + " ");
//        System.out.println();
//    }
}