import java.io.*;
import java.util.*;


public class Main{
    static class triple{
        int x, y, z;
        public triple(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[][] way = {{1,3,9}, {1,9,3}, {3,1,9}, {3,9,1}, {9,1,3}, {9,3,1}};
    static int bfs(int x, int y, int z){
        boolean[][][] visited = new boolean[61][61][61];
        Queue<triple> queue = new LinkedList<>();
        queue.add(new triple(x, y, z));
        visited[x][y][z] = true;
        int cnt = 0;

        Loop:
        while(!queue.isEmpty()){

            int len = queue.size();

            for(int i = 0; i < len; i++){
                triple curr = queue.poll();

                if(curr.x <= 0 && curr.y <= 0 && curr.z <= 0) break Loop;

                for(int w = 0; w < 6; w++){
                    int next_x = (curr.x - way[w][0] < 0) ? 0 : curr.x - way[w][0];
                    int next_y = (curr.y - way[w][1] < 0) ? 0 : curr.y - way[w][1];
                    int next_z = (curr.z - way[w][2] < 0) ? 0 : curr.z - way[w][2];

                    if(visited[next_x][next_y][next_z]) continue;

                    visited[next_x][next_y][next_z] = true;
                    queue.add(new triple(next_x, next_y, next_z));
                }
            }
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scv = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(scv[0], scv[1], scv[2]));

    }
}