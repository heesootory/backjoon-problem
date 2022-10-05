import java.io.*;
import java.util.*;


public class Main {
    static class Pair implements Comparable<Pair>{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o){
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }
    static int N, M, F;
    static int[][] arr;
    static Pair[] departure;
    static Pair[] destination;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Pair home;
    static int metergi;
    static Pair bfs(boolean with_guest, Pair p){
        visited = new boolean[N][N];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);
        visited[p.x][p.y] = true;
        metergi = 0;

        while(!queue.isEmpty()){
            int len = queue.size();
            // 다음 이동할 경로 체크

            if(!with_guest){        // 손님을 찾을시.
                List<Pair> list = new ArrayList<>();
                for(Pair g : queue){
                    if(arr[g.x][g.y] == 2) list.add(g);
                }
                if(list.size() > 0) {
                    Collections.sort(list);
                    Pair guest = list.get(0);
                    arr[guest.x][guest.y] = 0;
                    return guest;    // 손님 발견시!
                }
            }

            for(int q = 0; q < len; q++){
                Pair now = queue.poll();
                // 집 도착!
                if(with_guest && now.x == home.x && now.y == home.y) return home;

                for(int d = 0; d < 4; d++){
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(visited[nx][ny] || arr[nx][ny] == 1) continue;

                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
            if(F == 0) return null;     // 연료 부족.

            F--;        // 한칸 이동은 무조건 연로 -1.
            if(with_guest) metergi++;     // 손님이 있을때는 미터기를 잰다.
        }
        return null;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int tx = Integer.parseInt(st.nextToken())-1;
        int ty = Integer.parseInt(st.nextToken())-1;

        departure = new Pair[M];
        destination = new Pair[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken())-1;
            int sy = Integer.parseInt(st.nextToken())-1;
            int dx = Integer.parseInt(st.nextToken())-1;
            int dy = Integer.parseInt(st.nextToken())-1;
            arr[sx][sy] = 2;
            departure[i] = new Pair(sx, sy);
            destination[i] = new Pair(dx, dy);
        }

        boolean ans = true;

        // 택시의 위치가 첫 start
        Pair start = new Pair(tx, ty);
        for(int i = 0; i < M; i++){
            // 손님 찾기 : 시작(집) -> 손님 위치.
//            System.out.println("시작 : " + start.x + " " + start.y);
            Pair guest = bfs(false, start);
            if(guest == null) {
                ans = false; break;
            }
//            System.out.println("손님 : " + guest.x + " " + guest.y);
            // 손님의 목적지 알기
            for(int s = 0; s < M; s++){
                if(departure[s].x == guest.x && departure[s].y == guest.y)
                    home = destination[s];
            }

            // 목적지 데려다주기. : 손님위치 -> 집
//            System.out.println("도착지 : " + home.x + " " + home.y);

            start = bfs(true, guest);
            if(start == null){      // 도착지에 못내려준 경우.
                ans = false;
                break;
            }
            else{               // 잘 내려줌.
                F += (metergi * 2);   // 정상적으로 도착한 경우. 연료 두 배로 채워줌.
                ans = true;
            }

        }
        System.out.println((ans) ? F : -1);

    }
}
