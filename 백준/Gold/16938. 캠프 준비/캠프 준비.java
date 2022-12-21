import java.io.*;
import java.util.*;


public class Main {
    static int N, L, R, X, total;
    static int[] arr, ans;
    static void comb(int idx, int start, int cnt){
        if(idx == cnt){
            int sum = 0;
            int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
            for(int j = 0; j < cnt; j++) {
                max = Math.max(max, ans[j]);
                min = Math.min(min, ans[j]);
                sum += ans[j];
            }
            if(L <= sum && sum <= R && Math.abs(max - min) >= X) total++;
            return;
        }

        for(int i = start; i < N; i++){
            ans[idx] = arr[i];
            comb(idx + 1, i + 1, cnt);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            ans = new int[i];
            comb(0, 0, i);
        }

        System.out.println(total);

    }
}