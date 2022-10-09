import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[] cnt_arr;
    static int[] arr;

    static int min;
    static int max;

    static int calculate(int sum, int i, int next){
        switch(i){
            case 0: return sum + next;
            case 1: return sum - next;
            case 2: return sum * next;
            case 3: return sum / next;
        }
        return -1;
    }

    static void dfs(int idx, int sum){
        if(idx == N - 1){
            if(sum < min) min = sum;
            if(sum > max) max = sum;
            return;
        }

        for(int i = 0; i < 4; i++){
            if(cnt_arr[i] <= 0) continue;
            cnt_arr[i]--;
            dfs(idx + 1, calculate(sum, i, arr[idx + 1]));
            cnt_arr[i]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cnt_arr = new int[4];
            arr = new int[N];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++) cnt_arr[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());


            dfs(0, arr[0]);
            int a = Math.abs(max - min);
            System.out.printf("#%d %d\n", t, a);

        }
    }
}