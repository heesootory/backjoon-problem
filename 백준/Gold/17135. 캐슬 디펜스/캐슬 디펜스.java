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
        public int hashCode(){
            return Objects.hash(x * 10 + y);
        }
        @Override
        public int compareTo(Pair o){
            return this.y - o.y;
        }
        @Override
        public boolean equals(Object obj){
            if(obj instanceof Pair){
                return (this.x == ((Pair)obj).x) && (this.y == ((Pair)obj).y);
            }
            return false;
        }
    }
    static int N, M, D;
    static int[][] map;
    static int[] comb_arr = new int[3];
    static int[][] new_map;
    static int[] dx = {-1,0,0};
    static int[] dy = {0,-1,1};
    static int max_cnt;
    static int cnt;

    static void move(int line){
        new_map[line - 1] = new_map[line].clone();
        Arrays.fill(new_map[line], 0);
    }

    static void archer_play(int line){      // 한 라인마다 궁수들이 죽이는 플레이.
        Set<Pair> kill_list = new HashSet<>();
        for(int i = 0; i < M ; i++){
            if(new_map[line][i] == 2){
                boolean[][] visited = new boolean[N + 1][M];
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(line, i));
                visited[line][i] = true;
                int range = 1;

                while(!q.isEmpty() && range <= D){
                    List<Pair> mon_list = new ArrayList<>();
                    int len = q.size();

                    for(int l = 0; l < len; l++){
                        Pair now = q.poll();

                        for(int d = 0; d < 3; d++){
                            int nx = now.x + dx[d];
                            int ny = now.y + dy[d];

                            if(nx < 0 || ny < 0 || ny >= M) continue;
                            if(visited[nx][ny]) continue;

                            visited[nx][ny] = true;
                            if(new_map[nx][ny] == 1) mon_list.add(new Pair(nx, ny));
                            q.add(new Pair(nx, ny));

                        }
                    }
                    range++;
                    if(mon_list.size() != 0){
                        Collections.sort(mon_list);
                        Pair kill = mon_list.get(0);
                        kill_list.add(kill);
                        break;      // 궁수 한명당 한마리만 잡을 수 있으므로, 잡았다면 바로 다음 궁수차례
                    }

                }
            }
        }
        // 실제 죽이기
        cnt += kill_list.size();
//        System.out.println("size : " + cnt);
        for(Pair p : kill_list) {
//            System.out.println(p.x + " " + p.y);
            new_map[p.x][p.y] = 0;
        }
    }

    static void play(){
        // 새로운 배열에 복사
        new_map = new int[N + 1][M];
        for(int i = 0; i < N + 1; i++) new_map[i] = map[i].clone();
        // 궁수 배치
        for(int i : comb_arr) new_map[N][i] = 2;

        // N턴만큼 게임이 진행.
        for(int n = N; n > 0; n--){
            // 1. 궁수 공격 - bfs
            archer_play(n);
//            print(new_map);
            // 2. 궁수 이동. - 배열 복사
            move(n);
//            print(new_map);
        }
    }

    static void comb(int idx, int start){       // 조합으로 궁수 배치
        if(idx == 3){
            cnt = 0;
            play();
//            System.out.println(cnt);
            max_cnt = Math.max(max_cnt, cnt);
            return;
        }

        for(int i = start; i < M; i++){
            comb_arr[idx] = i;
            comb(idx + 1, i + 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];        // N 라인에 궁수 배치.

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.fill(map[N], 0);
        comb(0,0);
        System.out.println(max_cnt);
    }

    static void print(int[][] arr){
        for(int[] i : arr){
            for(int j : i) System.out.print(j +  " ");
            System.out.println();
        }
        System.out.println();
    }
}
