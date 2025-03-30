import java.io.*;
import java.util.*;


public class Main {
    static String str1, str2;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1; i < str1.length() + 1; i++){
            for(int j = 1; j < str2.length() + 1; j++){
                int idx1 = i - 1;
                int idx2 = j - 1;

                if(str1.charAt(idx1) == str2.charAt(idx2)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);

    }

}
