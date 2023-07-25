import java.io.*;
import java.util.*;



public class Main{
    static int N, M, maxTime;
    static int[] time;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            if(t > maxTime) maxTime = t;
        }

        long low = 0;
        long high = (long)maxTime * M;

        while(low <= high){
            long mid = (low + high) / 2;
            long sum = 0;

            for(int t : time) {
                sum += mid / t;
                if(sum >= M) break;
            }

            // 모든 인원을 수용 가능한 범위니까 일단 가능한(T) 범위
            if(sum >= M) {
                // 그 중 최솟값.
                if(mid < ans) ans = mid;
                high = mid - 1;
            }
            // 불가능한 범위(F)
            else low = mid + 1;
        }

        System.out.println(ans);
    }
}