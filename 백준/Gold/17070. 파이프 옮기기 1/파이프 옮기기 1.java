import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[][] arr;
    static int cnt;
    
    //  way - 0 : 가로, 1: 세로, 2 : 대각선
    static void dfs(int x, int y, int way){
        if(x == N-1 && y == N-1){
            cnt++;
            return;
        }

        if(way == 0){
            if(y+1 < N && arr[x][y+1] == 0) {
                arr[x][y+1] = 1;
                dfs(x, y+1,0);
                arr[x][y+1] = 0;
            }
        }
        else if(way == 1){
            if(x + 1 < N && arr[x+1][y] == 0){
                arr[x+1][y] = 1;
                dfs(x+1, y, 1);
                arr[x+1][y] = 0;
            }
        }
        else{
            if(y+1 < N && arr[x][y+1] == 0) {
                arr[x][y+1] = 1;
                dfs(x, y+1,0);
                arr[x][y+1] = 0;
            }
            if(x + 1 < N && arr[x+1][y] == 0){
                arr[x+1][y] = 1;
                dfs(x+1, y, 1);
                arr[x+1][y] = 0;
            }
        }
        if(x + 1 < N && y + 1 < N
                && arr[x+1][y+1] == 0 && arr[x+1][y] == 0 && arr[x][y+1] == 0){
            arr[x+1][y+1] =1; arr[x+1][y] = 1; arr[x][y+1] = 1;
            dfs(x+1, y+1, 2);
            arr[x+1][y+1] =0; arr[x+1][y] = 0; arr[x][y+1] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[0][0] = 1;
        arr[0][1] = 1;
        dfs(0, 1, 0);
//        for(int[] i : arr){
//            for(int j : i) System.out.print(j + " ");
//            System.out.println();
//        }
        System.out.println(cnt);

    }
}