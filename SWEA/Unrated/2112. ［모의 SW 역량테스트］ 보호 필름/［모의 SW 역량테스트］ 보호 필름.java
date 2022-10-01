import java.io.*;
import java.util.*;


public class Solution {
    static int D, W, K;
    static int[][] arr;
    static int[][] test_arr;
    static int min = Integer.MAX_VALUE;

    static void test(int idx, int cnt){      // idx가 층을 뜻함. / cnt는 약품을 넣은 횟수.
        // 한 줄씩 약품이 K씩 있는지 확인..
        if(idx == D){

            for(int j = 0; j < W; j++){
                int count = 0;
                boolean flag = false;
                for(int i = 1; i < D; i++){
                    if(test_arr[i][j] == test_arr[i-1][j]) count++;
                    else count = 0;
                    if(count >= K - 1) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) return;
            }
            // 여기로 내려온다면, 가능한 경우로 -> min값 갱신.
            if(cnt < min) min = cnt;

            return;
        }

        test(idx + 1, cnt);      // 아무 약품 안넣고 다음 층으로
        Arrays.fill(test_arr[idx], 0);     // a약품 넣어보기
        test(idx + 1, cnt + 1);      // 다음 층으로
        Arrays.fill(test_arr[idx], 1);     // b약품 넣어보기
        test(idx + 1, cnt + 1);      // 다음 층으로
        test_arr[idx] = arr[idx].clone();      // 원본으로 다시 복구
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            arr = new int[D][W];
            test_arr = new int[D][W];

            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    test_arr[i][j] = arr[i][j];
                }
            }

            test(0,0);
            System.out.printf("#%d %d\n", t, min);
        }
    }
}
