import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static Integer[][][] dp;

    static int drink(int row, int col, int milk){       // milk : 마지막으로 마신 우유맛
        // 기저
        if(row == N || col == N) return 0;
        // 메모이
        if(dp[row][col][milk] != null) return dp[row][col][milk];

        //탐색
        dp[row][col][milk] = 0;
        // 동쪽
        int result1 = 0;
        if(col< N){
            // 안마시는 경우
            result1 = drink(row, col + 1, milk);
            //마시는 경우
            if(arr[row][col] == milk)
                result1 = Math.max(result1, drink(row, col + 1, (milk + 1) % 3) + 1);
        }
        // 남쪽
        int result2 = 0;
        if(row< N){
            // 안마시는 경우
            result2 = drink(row + 1, col, milk);
            //마시는 경우
            if(arr[row][col] == milk)
                result2 = Math.max(result2, drink(row + 1, col, (milk + 1) % 3) + 1);
        }

        return dp[row][col][milk] = Math.max(result1, result2);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j< N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new Integer[N][N][3];
        System.out.println(drink(0,0,0));
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(dp[i][j][0] + " ");
//            }
//            System.out.println();
//        }

    }
}