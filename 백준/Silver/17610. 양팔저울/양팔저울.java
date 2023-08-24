import java.io.*;
import java.util.*;

public class Main {
    static int N, total;
    static int[] arr;
    static boolean[] check_arr;

    static void sol(int idx, int sum){
        if(idx == N){
            if(sum >= 0) check_arr[sum] = true;
            return;
        }

        sol(idx + 1, sum + arr[idx]);
        sol(idx + 1, sum);
        sol(idx + 1, sum - arr[idx]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        total = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        check_arr = new boolean[total + 1];

        sol(0, 0);

        int cnt = 0;
        for(int i = 1; i <= total; i++) {
            if(!check_arr[i]) cnt++;
        }
        System.out.println(cnt);
    }
}