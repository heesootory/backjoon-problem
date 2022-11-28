import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr, diff_arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        diff_arr = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        for(int i = 0; i < N-1; i++){
            diff_arr[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(diff_arr);
        int sum = 0;
        for(int i = 0; i < diff_arr.length - K + 1; i++) sum += diff_arr[i];
        System.out.println(sum);
    }
}