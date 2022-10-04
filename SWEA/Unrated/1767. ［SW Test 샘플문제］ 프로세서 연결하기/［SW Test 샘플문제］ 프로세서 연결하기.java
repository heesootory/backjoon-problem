import java.io.*;
import java.util.*;


public class Solution {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] origin_arr;
    static List<Pair> list;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] ans_arr;
    static int INF = Integer.MAX_VALUE;
    static int possible(int idx, int[][] arr, int d){
        int cnt = 0;
        Pair core = list.get(idx);
        int nx = core.x;
        int ny = core.y;
        while(true){
            nx += dx[d];
            ny += dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            if(arr[nx][ny] == 1) return -1;
            cnt++;
        }
        return cnt;
    }

    static int[][] connect(int idx, int[][] arr, int d){
        Pair core = list.get(idx);
        int nx = core.x;
        int ny = core.y;
        while(true){
            nx += dx[d];
            ny += dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            arr[nx][ny] = 1;
        }
        return arr;
    }

    static void dfs(int idx, int sum, int[][] arr, int core_cnt){
        if(idx == list.size()){
            if(ans_arr[core_cnt] > sum) ans_arr[core_cnt] = sum;
            return;
        }

        // 4방향으로 연결이 가능하다면 연결하는 경우
        for(int i = 0; i < 4; i++){
            if(possible(idx, arr, i) > 0){
                int[][] new_arr = new int[N][N];            // 재귀함수에 넘겨줄때, 주의할것 -> 매개변수에 함수로 넣어준 배열은 변하고 넘어간다!!!
                for(int j = 0; j < N; j++) new_arr[j] = arr[j].clone();
                dfs(idx + 1, sum + possible(idx, arr, i), connect(idx, new_arr, i), core_cnt + 1);
            }
        }
        // 연결안하는 경우.
        dfs(idx + 1, sum, arr, core_cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            origin_arr = new int[N][N];
            int[][] test_arr = new int[N][N];
            list = new ArrayList<>();

            for(int i = 0 ; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    origin_arr[i][j] = Integer.parseInt(st.nextToken());
                    test_arr[i][j] = origin_arr[i][j];
                    if(origin_arr[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1) list.add(new Pair(i, j));
                }
            }

            ans_arr = new int[list.size()+1];
            Arrays.fill(ans_arr, INF);

            dfs(0,  0, test_arr, 0);

            int ans = INF;
            for(int i = list.size() ; i >= 0; i--) {
                if(ans_arr[i] < ans) {
                    ans = ans_arr[i]; break;
                }
            }
            System.out.printf("#%d %d\n", t, (ans == INF) ? 0 : ans);
        }
    }
}
