import java.util.*;
import java.io.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int answer;
    static char[][] map;
    static boolean[] visited_perm;
    static boolean[][] choose;
    static boolean[][] visited_bfs;
    static int[] arr;
    static int[][] way = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static boolean bfs(){
        int cnt = 0;
        int s_cnt = 0;
        visited_bfs = new boolean[5][5];
        Queue<Pair> queue = new LinkedList<>();
        Pair start = new Pair(arr[0] / 5, arr[0] % 5);
        queue.add(start);
        visited_bfs[start.x][start.y] = true;
        cnt++;
        if(map[start.x][start.y] == 'S') s_cnt++;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();

            int curr_x = pair.x;
            int curr_y = pair.y;

            for(int w = 0; w < 4; w++){
                int next_x = curr_x + way[w][0];
                int next_y = curr_y + way[w][1];

                if(next_x < 0 || next_x >= 5 || next_y < 0 || next_y >= 5) continue;
                if(visited_bfs[next_x][next_y]) continue;
                if(choose[next_x][next_y]) {
                    visited_bfs[next_x][next_y] = true;
                    cnt++;
                    if(map[next_x][next_y] == 'S') s_cnt++;
                    queue.add(new Pair(next_x, next_y));
                }
            }
        }

        return (cnt == 7 && s_cnt >= 4);

    }
    static void comb(int idx, int num){
        if(idx == 7){
            // 연결확인 -> bfs
            if(bfs()) answer++;
            return;
        }

        for(int i = num + 1; i < 25; i++){
            if(visited_perm[i]) continue;

            arr[idx] = i;
            int x = i / 5;
            int y = i % 5;
            visited_perm[i] = true;
            choose[x][y] = true;
            comb(idx + 1, i);
            // 복구
            visited_perm[i] = false;
            choose[x][y] = false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new char[5][5];
        visited_perm = new boolean[25];      // 순열로 25개 중 7개 선택.
        choose = new boolean[5][5];        // 연결이 되어있는지 확인 배열.
        arr = new int[7];

        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            for(int j = 0; j < 5; j++){
                map[i][j] = str.charAt(j);
            }
        }

        comb(0, -1);
        System.out.println(answer);

    }

}