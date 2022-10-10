import java.io.*;
import java.util.*;


public class Solution{
    static int N, X;
    static int[][] arr;
    static int road;

    static boolean airstrip(int[] arr){
        boolean[] check = new boolean[N];
        int asc_cnt = 1;
        // 올라가는 길 확인.
        for(int i = 1; i < N; i++){
            if(arr[i - 1] == arr[i]) asc_cnt++;
            else if(arr[i - 1] < arr[i]) {      // 높이 차이가 발생!
                if(arr[i] - arr[i - 1] >= 2) return false;
                else if(asc_cnt < X) return false;
                else {
                    for(int j = i - 1; j >= i - X; j--) {
                        if(check[j]) return false;
                        check[j] = true;
                    }
                    asc_cnt = 1;
                }
            }
        }
        // 내려가는 길 확인.
        asc_cnt = 1;
        for(int i = N - 2; i >= 0; i--){
            if(arr[i + 1] == arr[i]) asc_cnt++;
            else if(arr[i + 1] < arr[i]) {
                if(arr[i] - arr[i + 1] >= 2) return false;
                else if(asc_cnt < X) return false;
                else {
                    for(int j = i + 1; j <= i + X; j++) {
                        if(check[j]) return false;
                        check[j] = true;
                    }
                    asc_cnt = 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            road = 0;

            arr = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 행 검사
            for(int i = 0; i < N; i++){
                if(airstrip(arr[i])) {
                    road++;
                }
            }
            //열 검사
            for(int i = 0 ; i < N; i++){
                int[] ex = new int[N];
                for(int j = 0; j < N; j++) ex[j] = arr[j][i];
                if(airstrip(ex)){
                    road++;
                }
            }

            System.out.printf("#%d %d\n", t, road);


        }
    }
}