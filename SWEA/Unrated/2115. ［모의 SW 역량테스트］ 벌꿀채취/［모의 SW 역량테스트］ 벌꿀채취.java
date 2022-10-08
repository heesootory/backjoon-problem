import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, C;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] person;
    static int ran;
    static int[] h_arr;
    static int max;
    static int max2;
    static void comb2(int idx, int start, int end, int sum, int cost){
        if(idx == end){
            if(sum <= C){
                if(max2 < cost) max2 = cost;
            }
        }
        for(int i = start; i < h_arr.length; i++){
            comb2(idx + 1, i + 1, end, sum + h_arr[i], cost + (h_arr[i] * h_arr[i]));
        }
    }
    static int profit_cal(){
        max2 = Integer.MIN_VALUE;
        int honey = 0;
        int cost = 0;
        for(int i = 0; i < M; i++) {
            honey += h_arr[i];
            cost += Math.pow(h_arr[i], 2);
        }

        if(honey <= C) return cost;
        else{
            for(int i = 1; i < M; i++){
                comb2(0,0, i, 0,0);
            }
            cost = max2;
            return cost;
        }
    }
    static void comb1(int idx, int start, int sum){
        if(idx == 2){
            if(sum > max) max = sum;
            return;
        }

       for(int i = start; i < N * ran; i++){        // 이차원 배열에서 범위에 맞춰 조합 구하기.
           int r = i / ran;
           int c = i % ran;
           boolean flag = false;
           for(int j = c; j < c + M; j++){      // 이미 선택된 벌통이라면 선택x
               if(visited[r][j]) {
                   flag = true;
                   break;
               }
           }
            if(flag) continue;
           person[idx] = new int[]{r, c};
           int k = 0;
           for(int j = c; j < c + M; j++) {
               h_arr[k++] = arr[r][j];
               visited[r][j] = true;     // 벌꿀통 방문 처리
           }
           comb1(idx + 1, i + 1, sum + profit_cal());
           for(int j = c; j < c + M; j++) {
               visited[r][j] = false;    // 벌꿀통 방문 해제
           }

       }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            ran = N - M + 1;
            max = Integer.MIN_VALUE;

            person = new int[2][2];
            arr = new int[N][N];
            visited = new boolean[N][N];
            h_arr = new int[M];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            comb1(0, 0, 0);
            System.out.printf("#%d %d\n", t, max);
        }
    }
}