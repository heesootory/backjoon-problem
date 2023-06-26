import java.util.*;
import java.io.*;



public class Main{
    static final int size = 10;
    static int[][] map;
    static int[] paper_cnt = {0,5,5,5,5,5};
    static int ans = 987654321;
    static void dfs(int idx, int count){
        if(count >= ans) return;
        if(idx == 100) {
            boolean flag = true;
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(map[i][j] == 1) {
                        flag = false; break;
                    }
                }
                if(!flag) break;
            }
            if(flag) ans = Math.min(ans, count);
            return;
        }

        int x = idx / size;
        int y = idx % size;

        if(map[x][y] == 1){
            boolean flag = true;
            int len = 1;
            for(int l = 2; l <= 5; l++){
                for(int i = x; i < x + l; i++){
                    for(int j = y; j < y + l; j++){
                        if(i >= size || j >= size || map[i][j] == 0){
                            flag = false; break;
                        }
                    }
                    if(!flag) break;
                }
                if(!flag) break;
                len = l;
            }

            // 색종이 갯수 카운트
            for(int l = len; l >= 1; l--) {
                if (paper_cnt[l] > 0) {
                    // 색종이 붙이기
                    paper_cnt[l]--;
                    for (int i = x; i < x + l; i++) {
                        for (int j = y; j < y + l; j++) {
                            map[i][j] = 0;
                        }
                    }

                    // 탐색
                    dfs(idx + 1, count+1);

                    // 색종이 떼기
                    paper_cnt[l]++;
                    for (int i = x; i < x + l; i++) {
                        for (int j = y; j < y + l; j++) {
                            map[i][j] = 1;
                        }
                    }
                }
            }
        }

        else dfs(idx + 1, count);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[size][size];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0, 0);
        System.out.println(ans == 987654321 ? -1 : ans);
    }
}