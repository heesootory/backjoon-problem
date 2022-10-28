import java.io.*;
import java.util.*;


public class Main {
    static int T;
    static long N;
    static int[] arr;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){

            pq = new PriorityQueue<>();
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                long a = Integer.parseInt(st.nextToken());
                pq.add(a);
            }
            long ans = 0;
            while(true){
                long a = pq.poll();
                long b = pq.poll();
                long sum = a + b;
                ans += sum;
                if(pq.isEmpty()) break;
                pq.add(sum);
            }

            System.out.println(ans);


        }
    }
}