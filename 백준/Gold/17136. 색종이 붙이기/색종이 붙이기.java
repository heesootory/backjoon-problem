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
    static final int N = 10;
    static int[][] arr;
    static int[] paper_num;
    static List<Pair> list;
    static int min = Integer.MAX_VALUE;

    static boolean possible(int x, int y, int size){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(i < 0 || j < 0 || i >= N || j >= N) return false;
                if(arr[i][j] != 1) return false;
            }
        }
        return (paper_num[size] > 0);
    }

    static void put(int x, int y, int size, int value){
        int count = 0;
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                arr[i][j] = value;
                count++;
            }
        }
        if(value == 1) paper_num[size]++;
        else paper_num[size]--;
    }

    static void dfs(int idx, int cnt){
        if(idx == list.size()){
            if(cnt < min) min = cnt;
            return;
        }

        Pair p = list.get(idx);
        for(int size = 1; size <= 5; size++){
            if(possible(p.x, p.y, size)){
                put(p.x, p.y, size, 2);     // 붙이기
                dfs(idx + 1, cnt + 1);
                put(p.x, p.y, size, 1);     // 떼기
            }
        }
        if(arr[p.x][p.y] != 1) dfs(idx + 1, cnt);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        paper_num = new int[]{0,5,5,5,5,5};
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) list.add(new Pair(i, j));
            }
        }

        dfs(0, 0);
        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }
}
