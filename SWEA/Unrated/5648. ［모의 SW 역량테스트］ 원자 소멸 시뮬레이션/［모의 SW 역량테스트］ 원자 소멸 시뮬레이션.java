import java.io.*;
import java.util.*;


public class Solution{
    static class Atom{
        int x, y;
        int dir, power;
        Atom(int x, int y, int d, int p){
            this.x = x;
            this.y = y;
            this.dir = d;
            this.power = p;
        }
    }
    static int N;
    static int[][] arr = new int[4001][4001];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};   // 상,하,좌,우
    static Queue<Atom> queue;
    static Queue<Atom> manager;
    static int result;
    static Queue<Atom> remove_q;
    static void bfs(){

        // 각 원자들 모두 이동. 맵밖으로 나가는 놈들은 제외.
        while(!queue.isEmpty()){
            int len = queue.size();

            for(int q = 0; q < len; q++){
                Atom now = queue.poll();
                arr[now.x][now.y] = 0;

                now.x += dx[now.dir];
                now.y += dy[now.dir];

                if(now.x < 0 || now.y < 0 || now.x > 4000 || now.y > 4000) continue;

                arr[now.x][now.y]++;
                manager.add(now);
            }

            // 충돌이 유무에 따라 다른 큐로 넣기
            while(!manager.isEmpty()){
                Atom a = manager.poll();
                if(arr[a.x][a.y] > 1) remove_q.add(a);
                else queue.add(a);
            }

            // 소멸된 원자들의 에너지 합 구하기 + 맵에서 지우기.
            while(!remove_q.isEmpty()){
                Atom re = remove_q.poll();
                result += re.power;
                arr[re.x][re.y] = 0;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            
            N = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();
            manager = new LinkedList<>();
            remove_q = new LinkedList<>();      // 충돌이 일어난 원자들 넣을 큐,
            result = 0;

            for(int i = 0; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) * 2 + 2000;        // 0.5 만큼 이동을 해결하기 위해.
                int x = 2000 - Integer.parseInt(st.nextToken()) * 2;
                int d = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                Atom atom = new Atom(x,y,d,p);
                queue.add(atom);
            }

            bfs();
            System.out.printf("#%d %d\n", t, result);

        }
    }
}