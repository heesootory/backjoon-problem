import java.io.*;
import java.util.*;


public class Main {
    static String str;
    static char[][] bridge;
    static int[][][] dp;

    static int dfs(int bri, int idx, int s){
        if(s == 0) return dp[bri][idx][s] = 1;
        if(bridge[bri][idx] == str.charAt(s) && dp[bri][idx][s] != -1) return dp[bri][idx][s];

        int sum = 0;
        if(bri == 0){
            for(int i = 0; i < idx; i++){
                if(bridge[bri + 1][i] == str.charAt(s - 1))
                    sum += dfs(bri + 1, i, s - 1);
            }
        }else{
            for(int i = 0; i < idx; i++){
                if(bridge[bri - 1][i] == str.charAt(s - 1))
                    sum += dfs(bri - 1, i, s - 1);
            }
        }

        return dp[bri][idx][s] = sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        bridge = new char[2][];
        bridge[0] = br.readLine().toCharArray();
        bridge[1] = br.readLine().toCharArray();
        int len = bridge[0].length;
        int str_len = str.length();

        dp = new int[2][len][str_len];
        for(int i = 0 ; i < 2; i++){
            for(int j = 0; j < len; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < len; j++){
                if(bridge[i][j] == str.charAt(str_len - 1)){
                    ans += dfs(i, j, str_len - 1);
                }
            }
        }

//        for(int i = 0; i < 2; i++){
//            for(int j = 0; j < len; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(ans);
    }

}
