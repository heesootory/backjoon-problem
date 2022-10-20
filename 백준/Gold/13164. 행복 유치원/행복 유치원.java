import java.io.*;
import java.util.*;

public class Main{

    static int N, K;
    static int[] arr, diff;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        diff = new int[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) diff[i-1] = arr[i] - arr[i-1];
        Arrays.sort(diff);
        int sum = 0;
        for(int i = 0; i < (N-1) - (K-1); i++) sum += diff[i];

        System.out.println(sum);


    }
}