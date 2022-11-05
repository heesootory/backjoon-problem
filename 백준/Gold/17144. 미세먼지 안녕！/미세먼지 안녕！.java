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

    static int r, c, t;
    static int[][] arr, arr2;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Pair[] air_cleaner;
    static Queue<Pair> queue;

    static void diffusion(){        // 미세먼지 확산
        int len = queue.size();
        for(int i = 0; i < len; i++){
            Pair now = queue.poll();
            int tiny_dust = arr[now.x][now.y] / 5;     // 확산되는 먼지의 양
            int cnt = 0;
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == -1) continue;
                cnt++;          // 확산되는 먼지의 갯수
                arr2[nx][ny] += tiny_dust;     // 먼지 확산 - arr2에 따로 저장
            }
            arr[now.x][now.y] -= tiny_dust * cnt;       // 기존 먼지 감소
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] += arr2[i][j];     // 확산된 먼지 + 기존 먼지
            }
        }
    }

    static void air_clean(){        // 공기청정기 가동
        // 순환 1
        Pair cir1 = air_cleaner[0];
        arr[cir1.x-1][cir1.y] = 0;
        for(int i = cir1.x - 2; i >= 0; i--) arr[i+1][cir1.y] = arr[i][cir1.y];
        for(int j = 1; j < c; j++) arr[0][j-1] = arr[0][j];
        for(int i = 1; i <= cir1.x; i++) arr[i-1][c-1] = arr[i][c-1];
        for(int j = c-2; j > cir1.y; j--) arr[cir1.x][j+1] = arr[cir1.x][j];
        arr[cir1.x][cir1.y+1] = 0;

        // 순환 2
        Pair cir2 = air_cleaner[1];
        arr[cir2.x+1][cir2.y] = 0;
        for(int i = cir2.x + 2; i < r; i++) arr[i-1][0] = arr[i][0];
        for(int j = 1; j < c; j++) arr[r-1][j-1] = arr[r-1][j];
        for(int i = r-2; i >= cir2.x; i--) arr[i+1][c-1] = arr[i][c-1];
        for(int j = c - 2; j > cir2.y; j--) arr[cir2.x][j+1] = arr[cir2.x][j];
        arr[cir2.x][cir2.y+1] = 0;
    }

    static int simulation(){
        while(t-- > 0){
            // 먼지 큐에 입장.
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(arr[i][j] > 0) queue.add(new Pair(i,j));
                }
            }
            arr2 = new int[r][c];   // 확산 먼지 배열 초기화
            diffusion();        // 확산
//            print();
//            System.out.println();
            air_clean();        // 공기 청정기 가동
//            print();
//            System.out.println();
        }
        // 총 먼지 구하기
        int sum = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(arr[i][j] > 0) sum += arr[i][j];
            }
        }
        return sum;
    }

//    static void print(){
//        for(int i = 0; i < r; i++){
//            for(int j = 0; j < c; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        air_cleaner = new Pair[2];
        queue = new LinkedList<>();

        int m = 0;
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) air_cleaner[m++] = new Pair(i,j);
            }
        }

        System.out.println(simulation());

    }
}