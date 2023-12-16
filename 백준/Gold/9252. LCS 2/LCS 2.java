import java.util.*;
import java.io.*;


public class Main{
    static String str1, str2;
    static int[][] dp;
    static Stack<Character> stack;
    static int dfs(int idx, int i, int j){
        if(i <= 0 || j <= 0) return 0;

        int cache = dp[i][j];
        if(cache != -1) return cache;

        if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return dp[i][j] = dfs(idx + 1, i - 1, j - 1) + 1;
        }
        else return dp[i][j] = Math.max(dfs( idx, i - 1, j), dfs(idx, i, j - 1));
    }

    static void getString(int i, int j){
        stack = new Stack<>();

        while(i > 0 && j > 0){
            if(dp[i][j] == dp[i - 1][j]) i--;
            else if(dp[i][j] == dp[i][j - 1]) j--;
            else{
                stack.push(str1.charAt(i - 1));
                i--; j--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();
        int len1 = str1.length();
        int len2 = str2.length();

        dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, len1, len2));

        getString(len1, len2);

        while(!stack.isEmpty()){
            char c = stack.pop();
            System.out.print(c);
        }

    }
}