import java.io.*;
import java.util.*;


public class Solution {
    static int N, W, H;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int min = Integer.MAX_VALUE;

    static void clean_map(int[][] arr){     // 공전부 밑으로 정리.
        for(int c = 0; c < W; c++){
            int idx  = -1;   // 자리 있는 인덱스
            for(int r = H - 1; r >= 0; r--){
                if(idx < 0){
                    if(arr[r][c] == 0) idx = r;
                }
                else{
                    if(arr[r][c] != 0){
                        arr[idx][c] = arr[r][c];
                        arr[r][c] = 0;
                        idx--;
                    }
                }
            }
        }
    }

    static void explose(int[][] arr, int x, int y){
        int len = arr[x][y];
        arr[x][y] = 0;
        for(int d = 0; d < 4; d++){
            int l = 1;
            int nx = x;
            int ny = y;
            while(l++ < len){
                nx += dx[d];
                ny += dy[d];
                if(nx < 0 || ny < 0 || nx >= H || ny >= W) break;
                if(arr[nx][ny] == 1) arr[nx][ny] = 0;
                else if(arr[nx][ny] > 1) explose(arr, nx, ny);
            }

        }
    }

    static int[][] attack(int[][] arr, int col){       // 벽돌 부수기
        int sr = 0;
        for(int i = 0; i < H; i++) {
            if(arr[i][col] != 0){
                sr = i; break;
            }
        }
        explose(arr, sr, col);
        clean_map(arr);
        return arr;
    }

    static void dfs(int idx, int[][] arr){
        if(idx == N){
            int cnt = 0;
            for(int[] i : arr){
                for(int j : i) if(j != 0) cnt++;
            }
            if(cnt < min) min = cnt;
            return;
        }

        for(int i = 0; i < W; i++){
            int[][] test_arr = new int[H][W];
            for(int t = 0 ; t < H; t++) test_arr[t] = arr[t].clone();
            dfs(idx + 1, attack(test_arr, i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            int[][] arr = new int[H][W];

            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            dfs(0, arr);
            System.out.printf("#%d %d\n", t, min);
        }
    }

//    static void print(int[][] arr){
//        for(int[] i : arr){
//            for(int j : i) System.out.print(j + " ");
//            System.out.println();
//        }
//        System.out.println();
//    }
}
