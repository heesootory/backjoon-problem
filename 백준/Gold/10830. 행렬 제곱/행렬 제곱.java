import java.io.*;
import java.util.*;

public class Main {
    static final int mod = 1000;
    static int N;
    static long B;
    static int[][] norm;
    static void print(int[][] arr){
        for(int[] i : arr){
            for(int j : i) System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
    }

    static int[][] arr_mul(int[][] arr1, int[][] arr2){
        int[][] new_arr = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int sum = 0;
                for(int a = 0, b = 0; a < N; a++, b++) {
                    sum += ((arr1[i][b] * arr2[a][j]) % mod);
                    sum %= mod;
                }
                new_arr[i][j] = sum;
            }
        }

        return new_arr;
    }

    static int[][] sol(int[][] arr, long n){        // 분할 정복을 이용한 계산
        if(n == 1) return arr;

        int[][] half_arr = sol(arr, n/2);

        if(n % 2 == 0) return arr_mul(half_arr, half_arr);
        else return arr_mul(arr_mul(half_arr, half_arr), norm);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int[][] arr = new int[N][N];
        norm = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) % mod;
                norm[i][j] = arr[i][j];
            }
        }
        print(sol(arr, B));

    }
}