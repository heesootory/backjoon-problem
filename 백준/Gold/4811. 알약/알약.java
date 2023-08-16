import java.io.*;
import java.util.*;


public class Main {
    static long[][] dp;

    static long dpFun(int w, int h){
        if(dp[w][h] != -1) return dp[w][h];

        long value = 0;
        if(h > 0) value += dpFun(w, h - 1);
        if(w > 0 && h < 30) value += dpFun(w - 1, h + 1);
        return dp[w][h] = value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new long[31][31];
        for(int i = 0; i < 31; i++) Arrays.fill(dp[i], -1);
        dp[0][1] = 1;

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            System.out.println(dpFun(n, 0));
        }


    }
}
