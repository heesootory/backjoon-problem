import java.io.*;
import java.util.*;


public class Main {
    static int count;
    static Integer[][][] dp;
    static List<Integer> list_w;
    static List<Integer> list_b;

    static int dfs(int idx, int wc, int bc){
        // 기저
        if(idx >= count || wc == 15 && bc == 15) return 0;

        // 메모이
        if(dp[idx][wc][bc] != null) return dp[idx][wc][bc];

        // 탐색 - 3가지의 경우의 수
        // 고르지 않을 때,
        int result0 = dfs(idx + 1, wc, bc);
        // 백 선택
        int result1 = 0;
        if(wc < 15) result1 = dfs(idx + 1, wc + 1, bc) + list_w.get(idx);
        // 흑 선택
        int result2 = 0;
        if(bc < 15) result2 = dfs(idx + 1, wc, bc + 1) + list_b.get(idx);

        return dp[idx][wc][bc] = Math.max(result0, Math.max(result1, result2));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Scanner scan = new Scanner(System.in);

        list_w = new ArrayList<>();
        list_b = new ArrayList<>();
        // 입력이 숫자가 아닐때까지 입력받기
        while(scan.hasNextInt()) {
            list_w.add(scan.nextInt());
            list_b.add(scan.nextInt());
            count++;
        }
        dp = new Integer[count][16][16];

        System.out.println(dfs(0, 0, 0));
    }
}