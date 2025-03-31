import java.io.*;
import java.util.*;


public class Main {
    static String S;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        dp = new int[26][S.length()];

        for(int i = 0; i < 26; i++){
            int cnt = 0;
            for(int j = 0; j < S.length(); j++){
                if(S.charAt(j) - 'a' == i) cnt++;
                dp[i][j] = cnt;
            }
        }

        int q = Integer.parseInt(br.readLine());

        for(int i = 0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == 0) System.out.println(dp[idx][end]);
            else System.out.println(dp[idx][end] - dp[idx][start - 1]);
        }
    }
}

