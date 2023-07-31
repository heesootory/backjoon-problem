import java.io.*;
import java.util.*;

class Stone{
    int x, y;
    boolean visited;
    Stone(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int n, T;
    static int Ans = -1;
    static ArrayList<Stone>[] list;
    static boolean check(Stone start){
        Queue<Stone> queue = new LinkedList<>();
        start.visited = true;
        queue.add(start);

        while(!queue.isEmpty()){
            Ans++;
            int len = queue.size();
            for(int q = 0; q < len; q++){
                Stone s = queue.poll();
                if(s.y == T) return true;
                for(int h = s.y - 2; h <= s.y + 2; h++){
                    if(h < 0 || h > T) continue;
                    for(Stone lock : list[h]){
                        if(Math.abs(lock.x - s.x) <= 2 && !lock.visited){
                            lock.visited = true;
                            queue.add(lock);
                        }
                    }
                }
            }
        }

        return false;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        list = new ArrayList[T + 1];
        for(int i = 0; i < T + 1; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Stone stone = new Stone(x, y);
            list[y].add(stone);
        }

        System.out.println(check(new Stone(0,0)) ? Ans : -1);
    }
}