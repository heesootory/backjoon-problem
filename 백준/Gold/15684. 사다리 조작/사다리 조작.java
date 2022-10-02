import java.io.*;
import java.util.*;


public class Main {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, H;
    static int[][] map;
    static List<Pair> list;
    static int min = Integer.MAX_VALUE;

    static boolean check(){
        for(int start = 0; start < N; start++){
            int end = start;
            int idx = 0;
            while(idx < H){
                if(map[idx][end] == 1) end--;
                else if(map[idx][end+1] == 1) end++;
                idx++;
            }
            if(start != end) return false;
        }
        return true;
    }

    static void dfs(int idx, int cnt){
        if(cnt > 3) return;
        if(idx == list.size()){
//            System.out.println(cnt);
//            for(int[] i : map){
//                for(int j : i) System.out.print(j + " ");
//                System.out.println();
//            }
//            System.out.println();
            if(check()){
                if(cnt < min) min = cnt;
            }
            return;
        }

        Pair p = list.get(idx);
        if(map[p.x][p.y-1] == 0 && map[p.x][p.y] == 0 && map[p.x][p.y+1] == 0) {
            map[p.x][p.y] = 1;
            dfs(idx+1, cnt+1);
            map[p.x][p.y] = 0;
            dfs(idx + 1, cnt);
        }
        else dfs(idx + 1, cnt);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N+1];
        min = Integer.MAX_VALUE;
        list = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b] = 1;
        }

        for(int i = 0; i < H; i++){
            for(int j = 1; j < N; j++){
                if(map[i][j-1] == 0 && map[i][j] == 0 && map[i][j+1] == 0) list.add(new Pair(i, j));
            }
        }

        dfs(0, 0);
        System.out.println((min > 3) ? -1 : min);
    }
}
