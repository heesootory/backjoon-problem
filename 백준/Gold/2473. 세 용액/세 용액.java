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

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int one = 0, two = 0, three = 0;
        for(int i = 0; i < N - 2; i++){
            int l = i + 1;
            int r = N - 1;

            while(l < r){
                long sum = (long)arr[i] + arr[l] + arr[r];
                long diff = Math.abs(sum);

                if(diff < min){
                    min = diff;
                    one = i;
                    two = l;
                    three = r;
                }
                if(sum >= 0) r--;
                else l++;
            }
        }

        System.out.println(arr[one] + " " + arr[two] + " " + arr[three]);

    }
}