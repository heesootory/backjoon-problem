import java.io.*;
import java.util.*;

class Edge{
    int x, y, idx;
    Edge(int x, int y, int idx){
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

public class Main{
    static int T, n;
    static boolean[] visited;
    static ArrayList<Edge> list;
    static int beer = 20;
    static void bfs(Edge start){
        Queue<Edge> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){

            Edge curr = queue.poll();

            for(Edge e : list){
                if(Math.abs(curr.x - e.x) + Math.abs(curr.y - e.y) <= 1000 && !visited[e.idx]){
                    queue.add(e);
                    visited[e.idx] = true;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            Edge house = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -1);
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                Edge waypoint = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
                list.add(waypoint);
            }
            st = new StringTokenizer(br.readLine());
            Edge festival = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), n);
            list.add(festival);

            bfs(house);

            System.out.println(visited[n] ? "happy" : "sad");

        }


    }
}