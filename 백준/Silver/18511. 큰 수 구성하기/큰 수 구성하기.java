import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int K;
    static int[] arr;
    static boolean[] visited;
    static int ans = Integer.MIN_VALUE;
    static void subset(int idx, int sum, int end){
        if(idx == end){
            if(sum <= N){
                if(sum > ans) ans = sum;
            }
            return;
        }

        int norm = 1;
        for(int i = 0 ; i < idx; i++) norm *= 10;
        for(int i = 0; i < K; i++){
            subset(idx + 1, sum + arr[i] * norm, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        visited = new boolean[K];
        int norm = N;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while(norm > 0){
            norm /= 10;
            cnt++;
        }

        for(int i = 1; i <= cnt; i++) subset(0,0,i);
        System.out.println(ans);
    }
}

