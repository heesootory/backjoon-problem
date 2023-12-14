import java.util.*;
import java.io.*;

/**
 *
 */

public class Main{
    static int N;
    static int[] cntArr;
    static long[][][][][][][] dp;
    static long dfs(int before2, int before1, int a, int b, int c, int d, int e){
        if(a == 0 && b == 0 && c == 0 && d == 0 && e == 0) return 1;

        long cache = dp[before2][before1][a][b][c][d][e];
        if(cache != -1) return cache;

        long sum = 0L;
        if(a > 0 && before2 != 1 && before1 != 1) sum += dfs(before1, 1, a - 1, b, c, d, e);
        if(b > 0 && before2 != 2 && before1 != 2) sum += dfs(before1, 2, a, b - 1, c, d, e);
        if(c > 0 && before2 != 3 && before1 != 3) sum += dfs(before1, 3, a, b, c - 1, d, e);
        if(d > 0 && before2 != 4 && before1 != 4) sum += dfs(before1, 4, a, b, c, d - 1, e);
        if(e > 0 && before2 != 5 && before1 != 5) sum += dfs(before1, 5, a, b, c, d, e - 1);

        return dp[before2][before1][a][b][c][d][e] = sum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        cntArr = new int[6];        // 구슬의 종류 : 1 ~ N

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            cntArr[i] = Integer.parseInt(st.nextToken());
        }

        // -2번째, -1번째, 구슬의 종류 5가지의 각 갯수.
        dp = new long[6][6][11][11][11][11][11];

        for(int a = 0; a < 6; a++){
            for(int b = 0; b < 6; b++){
                for(int c = 0; c < 11; c++){
                    for(int d = 0; d < 11; d++){
                        for(int e = 0; e < 11; e++){
                            for(int f = 0; f < 11; f++){
                                for(int g = 0; g < 11; g++){
                                    dp[a][b][c][d][e][f][g] = -1;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dfs(0, 0, cntArr[1], cntArr[2], cntArr[3], cntArr[4], cntArr[5]));

    }

}