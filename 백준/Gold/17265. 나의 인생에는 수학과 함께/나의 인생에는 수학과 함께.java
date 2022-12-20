import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] arr;
    static int ans_max = Integer.MIN_VALUE, ans_min = Integer.MAX_VALUE;
    static void dfs(int row, int col, char tmp, int result){
        // 기저
        if(row == N || col == N) return;

        // 탐색
        if("+*-".indexOf(arr[row][col]) != -1) tmp = arr[row][col];
        else{      // 숫자일때
            int num = arr[row][col] - '0';
            if(tmp == '+') result += num;
            else if(tmp == '-') result -= num;
            else result *= num;
        }

        // 종료조건
        if(row == N-1 && col == N-1){
            ans_max = Math.max(ans_max, result);
            ans_min = Math.min(ans_min, result);
            return;
        }
    
        // 탐색
        dfs(row + 1, col, tmp, result);
        dfs(row, col + 1, tmp, result);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N =  Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = st.nextToken().charAt(0);
            }
        }
        dfs(0,0,'+', 0);
        System.out.println(ans_max + " " + ans_min);

    }
}