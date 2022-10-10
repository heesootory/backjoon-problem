import java.io.*;
import java.util.*;

public class Solution {
    static int[] cost;
    static int[] month;
    static int min;

    static void dfs(int idx, int sum){
        if(idx == 13){
            if(sum < min) min = sum;
            return;
        }
        // 사용없으면 안사기
        if(month[idx] == 0) dfs(idx + 1, sum);
        // 1일권으로 구매
        if(month[idx] > 0) dfs(idx + 1, sum + month[idx] * cost[0]);
        // 1달권으로 구매
        if(month[idx] > 0) dfs(idx + 1, sum + cost[1]);
        // 3달권으로 구매
        if(idx < 11) dfs(idx + 3, sum + cost[2]);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            cost = new int[4];
            month = new int[13];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++) cost[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 12; i++) month[i] = Integer.parseInt(st.nextToken());

            min = cost[3];    // 항상 1년치 다사는게 최댓값 기본값.

            dfs(1, 0);
            System.out.printf("#%d %d\n", t, min);

        }
    }
}