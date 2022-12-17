import java.io.*;
import java.util.*;

public class Main {
    static class Emozi{
        int display;
        int clipboard;
        Emozi(int display, int clipboard){
            this.display = display;
            this.clipboard = clipboard;
        }
    }
    static int S, time;
    static Queue<Emozi> queue;
    static boolean[][] visited;
    static void bfs(Emozi emozi){
        queue = new LinkedList<>();
        queue.add(emozi);
        visited[emozi.display][emozi.clipboard] = true;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                Emozi e = queue.poll();

                if(e.display == S) return;      // bfs 종료 조건

                // 복사
                if(!visited[e.display][e.display]){
                    Emozi copy_em = new Emozi(e.display, e.display);
                    queue.add(copy_em);
                    visited[e.display][e.display] = true;
                }
                // 붙여넣기
                if(e.clipboard != 0 && e.display + e.clipboard <= S && !visited[e.display + e.clipboard][e.clipboard]){
                    Emozi paste_em = new Emozi(e.display + e.clipboard, e.clipboard);
                    queue.add(paste_em);
                    visited[e.display + e.clipboard][e.clipboard] = true;
                }
                // 제거
                if(e.display-1 >= 0 && !visited[e.display-1][e.clipboard]){
                    Emozi remove_em = new Emozi(e.display-1, e.clipboard);
                    queue.add(remove_em);
                    visited[e.display-1][e.clipboard] = true;
                }
            }
            time++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = Integer.parseInt(br.readLine());
        visited = new boolean[S+1][S+1];

        bfs(new Emozi(1, 0));
        System.out.println(time);
//        for(boolean[] vi : visited){
//            for(boolean b : vi) System.out.print(b + " ");
//            System.out.println();
//        }
    }
}