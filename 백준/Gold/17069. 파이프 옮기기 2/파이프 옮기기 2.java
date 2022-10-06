import java.io.*;
import java.util.*;

/**
 * bottom - top (상향식)
 */

public class Main {
    static int N;
    static int[][] arr;
    static long[][][] max_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        max_arr = new long[3][N+1][N+1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max_arr[0][1][2] = 1;

        for(int i = 1; i < N + 1; i++){
            for(int j = 3; j < N + 1; j++){
                if(arr[i][j] == 1) continue;
                max_arr[0][i][j] = max_arr[0][i][j-1] + max_arr[1][i][j-1];
                if(arr[i-1][j] != 1 && arr[i][j-1] != 1)
                    max_arr[1][i][j] = max_arr[0][i-1][j-1] + max_arr[1][i-1][j-1] + max_arr[2][i-1][j-1];
                max_arr[2][i][j] = max_arr[2][i-1][j] + max_arr[1][i-1][j];
            }
        }

//        print(max_arr[0]);
//        print(max_arr[1]);
//        print(max_arr[2]);

        System.out.println(max_arr[0][N][N] + max_arr[1][N][N] + max_arr[2][N][N]);

    }
    static void print(long[][] arr){
        for(long[] i : arr){
            for(long j : i) System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
    }
}


