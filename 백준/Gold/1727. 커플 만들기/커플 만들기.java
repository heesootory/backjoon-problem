import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] mans = new int[n];
        int[] womans = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) mans[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) womans[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(mans);
        Arrays.sort(womans);

        int big = Math.max(n, m);
        int small = Math.min(n, m);

        int[][] dp = new int[small][big];

        if(n > m){      // 남자 > 여자
            for(int i = small - 1; i >= 0; i--){
                for(int j = big - 1 - (small - 1 - i); j >= i; j--){
                    int diff = Math.abs(womans[i] - mans[j]);
                    if(i == small - 1) {
                        if(j == big - 1 - (small - 1 - i)) dp[i][j] = diff;
                        else dp[i][j] = Math.min(diff, dp[i][j + 1]);
                    }
                    else {
                        if(j == big - 1 - (small - 1 - i)) dp[i][j] = dp[i+1][j+1] + diff;
                        else dp[i][j] = Math.min(dp[i+1][j+1] + diff, dp[i][j + 1]);
                    }
                }
            }
        }else{          // 여자 > 남자
            for(int i = small - 1; i >= 0; i--){
                for(int j = big - 1 - (small - 1 - i); j >= i; j--){
                    int diff = Math.abs(mans[i] - womans[j]);
                    if(i == small - 1) {
                        if(j == big - 1 - (small - 1 - i)) dp[i][j] = diff;
                        else dp[i][j] = Math.min(diff, dp[i][j + 1]);
                    }
                    else {
                        if(j == big - 1 - (small - 1 - i)) dp[i][j] = dp[i+1][j+1] + diff;
                        else dp[i][j] = Math.min(dp[i+1][j+1] + diff, dp[i][j + 1]);
                    }
                }
            }
        }

//        for(int i = 0; i < small; i++){
//            for(int j = 0; j < big; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[0][0]);


    }
}