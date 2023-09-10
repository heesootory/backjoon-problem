import java.io.*;
import java.util.*;

public class Main {
    static int N ,M;
    static boolean[] holiday;
    static Integer[][] dp;
    static int resort(int day, int coupon){
        //기저
        if(day > N) return 0;
        // 메모이
        if(dp[day][coupon] != null) return dp[day][coupon];

        //탐색
        dp[day][coupon] = Integer.MAX_VALUE;
        if(holiday[day])        // 리조트에 갈 수 없는 날.
            return dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 1, coupon));
        else{       // 리조트에 갈 수 있는 날.
            if(coupon >= 3) {     // 쿠폰이 3장 이상일때.
                dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 1, coupon - 3));
            }
            dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 1, coupon) + 10000);
            dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 3, coupon + 1) + 25000);
            dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 5, coupon + 2) + 37000);
        }
        return dp[day][coupon];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        holiday = new boolean[N + 1];

        if(M > 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) holiday[Integer.parseInt(st.nextToken())] = true;
        }

        dp = new Integer[N + 1][N + 1];
        System.out.println(resort(1, 0));

    }
}