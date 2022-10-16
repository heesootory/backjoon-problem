import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[][] arr;
    static List<Pair> chicken_list = new ArrayList<>();     // 치킨 집 위치 저장.
    static List<Pair> house_list = new ArrayList<>();      // 집의 위치 저장.
    static int min = Integer.MAX_VALUE;
    static Pair[] real_chi_list;

    static void dfs(int idx, int start){
        if(idx == M){
            int sum = 0;
            for(Pair h : house_list){
                int dis = Integer.MAX_VALUE;
                for(Pair c : real_chi_list){
                    dis = Math.min(dis, Math.abs(h.x - c.x) + Math.abs(c.y - h.y));
                }
                sum += dis;
            }
            min = Math.min(min, sum);
            return;
        }

        for(int i = start; i < chicken_list.size(); i++){
            real_chi_list[idx] = chicken_list.get(i);
            dfs(idx + 1, i + 1 );
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        real_chi_list = new Pair[M];
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) chicken_list.add(new Pair(i,j));
                else if(arr[i][j] == 1) house_list.add(new Pair(i,j));
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }
}

