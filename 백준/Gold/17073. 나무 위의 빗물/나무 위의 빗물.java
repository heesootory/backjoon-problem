import java.io.*;
import java.util.*;


public class Main {
    static int N, W;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        tree = new int[N];

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u-1]++;
            tree[v-1]++;
        }

        int cnt = 0;
        for(int t = 1; t < tree.length; t++){
            if(tree[t] == 1) cnt++;
        }

        System.out.println(String.format("%.10f", (double)W / cnt));

    }

}
