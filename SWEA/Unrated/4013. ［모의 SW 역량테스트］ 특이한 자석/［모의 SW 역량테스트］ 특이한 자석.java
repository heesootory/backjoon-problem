import java.io.*;
import java.util.*;


public class Solution{
    static int K;
    static int[][] arr;

    static void rotate(int row, int wise){
        if(wise == -1){      // 시계방향
            int tmp = arr[row][0];
            for(int i = 1; i < 8; i++) arr[row][i - 1] = arr[row][i];
            arr[row][7] = tmp;
        }
        else if(wise == 1){    // 반시계
            int tmp = arr[row][7];
            for(int i = 6; i >= 0; i--) arr[row][i + 1] = arr[row][i];
            arr[row][0] = tmp;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            K = Integer.parseInt(br.readLine());
            arr = new int[4][8];

            for(int i = 0; i < 4; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 8; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0 ; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int wise = Integer.parseInt(st.nextToken());

                boolean[] check = new boolean[3];
                for(int c = 0; c < 3; c++){     //서로 극이 다른 부분 체크하기.
                    if(arr[c][2] != arr[c+1][6]) check[c] = true;
                }

                // 나머지 자석 먼저 회전.
                switch(row){
                    case 1:     // 0번 자석
                        if(check[0]) rotate(1, wise * -1);
                        else break;
                        if(check[1]) rotate(2, wise);
                        else break;
                        if(check[2]) rotate(3, wise * -1);
                        break;
                    case 2:     // 1번 자석
                        if(check[0]) rotate(0, wise * -1);
                        if(check[1]) rotate(2, wise * -1);
                        else break;
                        if(check[2]) rotate(3, wise);
                        break;
                    case 3:     // 2번 자석
                        if(check[2]) rotate(3, wise * -1);
                        if(check[1]) rotate(1, wise * -1);
                        else break;
                        if(check[0]) rotate(0, wise);
                        break;
                    case 4:     // 3번 자석
                        if(check[2]) rotate(2, wise * -1);
                        else break;
                        if(check[1]) rotate(1, wise);
                        else break;
                        if(check[0]) rotate(0, wise * -1);
                }
                // 타켓 자석 회전.
                rotate(row - 1, wise);

            }

            int sum = 0;
            for(int i = 0; i < 4; i++){
                if(arr[i][0] == 1) sum += Math.pow(2, i);
            }

            System.out.printf("#%d %d\n", t, sum);

        }
    }
}