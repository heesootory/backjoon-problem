import java.io.*;
import java.util.*;


// 같은 것이 포함된 순열 뽑기 - > 배치
public class Main {

    static int parents[];
    static int N, M;

    static void make(){
        for(int i = 0; i < N; i++){        // 1부터 N까지로 구성.
            parents[i] = i;
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

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            parents = new int[N];
            make();

            int k = Integer.parseInt(br.readLine());
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            sb.append(String.format("Scenario %d:\n", t));
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                sb.append((find(a) == find(b)) ? 1 : 0).append("\n");
            }

            System.out.println(sb);
        }

    }
}