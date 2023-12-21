import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long min = Long.MAX_VALUE;
        int ans_l = 0;
        int ans_r = N - 1;
        int l = 0;
        int r = N - 1;
        while(l < r){
            long sum = arr[r] + arr[l];
            long diff = Math.abs(sum);
            if(diff < min){
                min = diff;
                ans_r = r;
                ans_l = l;
            }
            if(sum == 0) break;
            else if(sum > 0) r--;
            else l++;
        }

        System.out.println(arr[ans_l] + " " + arr[ans_r]);

    }
}