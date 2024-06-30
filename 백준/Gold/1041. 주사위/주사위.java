import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[6];
        for(int i = 0; i < 6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum1 = Long.MAX_VALUE;
        long sum2 = Long.MAX_VALUE;
        long sum3 = 0;
        long max = 0;

        for(long a : arr) {
            sum1 = Math.min(sum1, a);
            max = Math.max(max, a);
        }

        for(int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i == j || i + j == 5) continue;
                sum2 = Math.min(sum2, arr[i] + arr[j]);
            }
        }

        for(int i = 0, j = 5; i < 3; i++, j--) {
            sum3 += Math.min(arr[i], arr[j]);
        }

        long sum = 0;
        if(N == 1) {
            for(long l : arr) sum += l;
            sum -= max;
        }else{
            sum += (4 * sum3);
            sum += ((8 * N - 12) * sum2);
            sum += ((5 * N * N - 16 * N + 12) * sum1);
        }

        System.out.println(sum);
    }
}

