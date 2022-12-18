import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int mod = 1000000;
    static Integer[][][] dp;

    static int dfs(int day, int l, int a){
        // 기저
        // 개근을 못한 경우
        if(l == 2 || a == 3) return 0;
        // 개근힌 경우
        if(day == N) return 1;

        // 메모이
        if(dp[day][l][a] != null) return dp[day][l][a];

        // 탐색
        dp[day][l][a] = 0;
        // 해당 날의 경우의 수 = 다음날의 참석한경우 + 다음날 지각한 경우 + 다음날 결석한 경우
        dp[day][l][a] = (dfs(day + 1, l, 0) + dfs(day + 1, l + 1, 0) + dfs(day + 1, l, a + 1)) % mod;

        return dp[day][l][a];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new Integer[N][2][3];   //  출석, 지각, 결석 -> 해당하는 값이 총 갯수.

        System.out.println(dfs(0,0,0));       // 첫날(0) -> 지각(0) 이고, 결석(0)인 상태의 값을 구하기.

    }
}