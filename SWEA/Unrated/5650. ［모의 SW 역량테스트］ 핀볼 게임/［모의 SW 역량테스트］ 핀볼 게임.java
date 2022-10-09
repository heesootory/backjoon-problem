import java.io.*;
import java.util.*;

public class Solution {
    static class Pair{
        int x, y;
        int d;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] arr;
    static List<Pair> list;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};   // 상0, 하1, 좌2, 우3
    static Pair[][] hole_list;
    static boolean[] hole_cnt;
    static int max = Integer.MIN_VALUE;

    static void hole_change(Pair p, int v){

        if(hole_list[0][v].x == p.x && hole_list[0][v].y == p.y){
            p.x = hole_list[1][v].x;
            p.y = hole_list[1][v].y;
        }
        else if(hole_list[1][v].x == p.x && hole_list[1][v].y == p.y){
            p.x = hole_list[0][v].x;
            p.y = hole_list[0][v].y;
        }
    }

    static void block_change(Pair p, int block){
        switch(block){
            case 1:
                if(p.d == 2) p.d = 0;
                else if(p.d == 1) p.d = 3;
                else if(p.d == 3) p.d = 2;
                else if(p.d == 0) p.d = 1;
                break;
            case 2:
                if(p.d == 2) p.d = 1;
                else if(p.d == 0) p.d = 3;
                else if(p.d == 3) p.d = 2;
                else if(p.d == 1) p.d = 0;
                break;
            case 3:
                if(p.d == 3) p.d = 1;
                else if(p.d == 0) p.d = 2;
                else if(p.d == 1) p.d = 0;
                else if(p.d == 2) p.d = 3;
                break;
            case 4:
                if(p.d == 3) p.d = 0;
                else if(p.d == 1) p.d = 2;
                else if(p.d == 2) p.d = 3;
                else if(p.d == 0) p.d = 1;
                break;
            case 5:
                if(p.d == 0) p.d = 1;
                else if(p.d == 1) p.d = 0;
                else if(p.d == 2) p.d = 3;
                else if(p.d == 3) p.d = 2;
                break;
        }
    }
    static void play(Pair p, int ori_x, int ori_y){
        boolean check = false;
        int cnt = 0;

        while(true){
            p.x += dx[p.d];
            p.y += dy[p.d];

            // 벽 방향 바꾸기 - 맵 밖으로 나갔다 들어오는 걸로 하는게 오히려 생각하기 편함.
            // 주의해야할 점은 밖으로 나갔다가 바로 들어오는 로직을 꼭 넣어줘서, 바로 블록에 부디치는지 확인해야한다!!
            if(p.x == -1 && p.d == 0) {
                p.x += 1; p.d = 1; cnt++;
            }
            else if(p.x == N && p.d == 1) {
                p.x -= 1; p.d = 0; cnt++;
            }
            else if(p.y == -1 && p.d == 2) {
                p.y += 1; p.d = 3; cnt++;
            }
            else if(p.y == N && p.d == 3) {
                p.y -= 1; p.d = 2; cnt++;
            }

            int value = arr[p.x][p.y];
            if(value != 0){     // 블록 방향 바꾸기
                if(0 < value && value < 6) {
                    block_change(p, value);
                    cnt++;
                }
                else if(value >= 6) hole_change(p, value);
                else if(value == -1) {
                    check = true;
                    break;
                }
            }

            // 블록에 맞고 맵밖으로 나갈 경우 방지.
//            if(p.x < 0 || p.y < 0 || p.x >= N || p.y >= N) break;
            // 출발지로 돌아오면 끝
            if(p.x == ori_x && p.y == ori_y) {
                check = true;
                break;
            }
        }
        if(check){
            if(cnt > max) {
                if(cnt == 10) System.out.println(ori_x + " " + ori_y);
                max = cnt;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            max = Integer.MIN_VALUE;
            arr = new int[N][N];
            list = new ArrayList<>();
            hole_cnt = new boolean[11];
            hole_list = new Pair[2][11];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    int kan = arr[i][j];
                    if(kan == 0) list.add(new Pair(i, j));
                    else if(kan >= 6) {
                        if(!hole_cnt[kan]) {
                            hole_cnt[kan] = true;
                            hole_list[0][kan] = new Pair(i, j);
                        }
                        else hole_list[1][kan] = new Pair(i, j);
                    }
                }
            }

            for(Pair p : list){
                int ori_x = p.x;
                int ori_y = p.y;
                for(int i = 0; i < 4; i++){
                    p.x = ori_x; p.y = ori_y;
                    p.d = i;        // 시작 방향 설정
                    play(p, ori_x, ori_y);        // 플레이!

                }
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}