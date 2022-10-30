import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int size = 0;

        for(int i = 0; i < N; i++){
            int pos = Arrays.binarySearch(dp, 0, size, arr[i]);
            if(pos >= 0) continue;

            int insertPos = Math.abs(pos) - 1;
            dp[insertPos] = arr[i];

            if(insertPos == size) size++;
        }

        System.out.println(size);

    }
}