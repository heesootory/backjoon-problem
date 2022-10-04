import java.io.*;
import java.util.*;


public class Main {
    static class camera{
        int x, y;
        int camera_num;
        camera(int x, int y, int camera_num){
            this.x = x;
            this.y = y;
            this.camera_num = camera_num;
        }
    }
    static int N, M;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};    // 왼, 위, 오, 아래
    static int[] dy = {-1, 0, 1, 0};
    static List<camera> list;
    static List<camera> list2;
    static int min = Integer.MAX_VALUE;

    static void observe(int[][] arr, camera cam, int d){
        int nx = cam.x;
        int ny = cam.y;
        while(true){
            nx += dx[d];
            ny += dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) return;
            if(arr[nx][ny] == 6) return;
            arr[nx][ny] = 1;
        }
    }

    static void which_cam(int[][] arr, camera cam, int d){
        switch(cam.camera_num){
            case 1: observe(arr, cam, d); break;
            case 2: observe(arr, cam, d); observe(arr, cam, (d + 2) % 4); break;
            case 3: observe(arr, cam, d); observe(arr, cam, (d + 1) % 4); break;
            case 4: observe(arr, cam, d); observe(arr, cam, (d + 1) % 4); observe(arr, cam, (d + 2) % 4); break;
        }
    }

    static void detect(int idx, int[][] arr){
        if(idx == list.size()){
            int cnt = 0;
            for(int[] i : arr){
                for(int j : i) if(j == 0) cnt++;
            }
            if(cnt < min) min = cnt;
            return;
        }

        camera cam = list.get(idx);
        for(int i = 0; i < 4; i++){
            int[][] new_arr = new int[N][M];
            for(int n = 0; n < N; n++) new_arr[n] = arr[n].clone();

            which_cam(new_arr, cam, i);
            detect(idx + 1, new_arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();
        list2 = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1 ||map[i][j] == 2 || map[i][j] == 3|| map[i][j] == 4) list.add(new camera(i, j, map[i][j]));
                else if(map[i][j] == 5) list2.add(new camera(i, j, map[i][j]));
            }
        }
        // 5번 카메라 감시
        for(camera c : list2){
            for(int i = 0; i < 4; i++) observe(map, c, i);
        }

        detect(0, map);
        System.out.println(min);

    }
}
