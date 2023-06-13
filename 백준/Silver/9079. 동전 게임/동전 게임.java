import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int T;
    static int[][] arr;
    static int min;

    static int[][] flip(int[][] arr, int ver){
        int[][] new_arr = new int[3][3];
        for(int i = 0; i < 3; i++) new_arr[i] = arr[i].clone();

        switch(ver){
            case 0:
                for(int i = 0; i < 3; i++) new_arr[i][0] *= -1; break;
            case 1:
                for(int i = 0; i < 3; i++) new_arr[i][1] *= -1; break;
            case 2:
                for(int i = 0; i < 3; i++) new_arr[i][2] *= -1; break;
            case 3:
                for(int i = 0; i < 3; i++) new_arr[0][i] *= -1; break;
            case 4:
                for(int i = 0; i < 3; i++) new_arr[1][i] *= -1; break;
            case 5:
                for(int i = 0; i < 3; i++) new_arr[2][i] *= -1; break;
            case 6:
                for(int i = 0, j = 0; i < 3; i++, j++) new_arr[i][j] *= -1; break;
            case 7:
                for(int i = 0, j = 2; i < 3; i++, j--) new_arr[i][j] *= -1; break;
        }

        return new_arr;
    }

    static void dfs(int idx, int start, int[][] arr){
        int sum = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                sum += arr[i][j];
            }
        }
        if(sum == 9 || sum == -9){
            min = Math.min(min, idx);
            return;
        }

        for(int i = start; i < 8; i++){
            dfs(idx + 1, i + 1, flip(arr, i));
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        arr = new int[3][3];

        for(int t = 0; t < T; t++){
            min = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++){
                    arr[i][j] = (st.nextToken().charAt(0) == 'H') ? 1: -1;
                }
            }

            dfs(0, 0, arr);
            System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
        }


    }
}
