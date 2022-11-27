import java.io.*;
import java.util.*;

public class Main {

    static int N, K, cnt;
    static int[] arr;
    static int[] ans;
    static void print(int[] ar){
        for(int i : ar) System.out.print(i + " ");
        System.out.println();
    }

    static void perm(int idx, int sum){
        if(cnt == K) return;
        if(idx == N || sum == N) {
            cnt++;
            if(cnt == K) ans = arr.clone();
            return;
        }

        for(int i = 1; i < 4; i++){
            if(sum + i <= N){
                arr[idx] = i;
                perm(idx + 1, sum + i);
                arr[idx] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[N];

        perm(0,0);
        if(K > cnt) System.out.println(-1);
        else{
            for(int i = 0; i < N; i++){
                if(ans[i] == 0) break;
                if(i == 0) System.out.print(ans[i]);
                else System.out.print("+" + ans[i]);
            }
        }
    }
}