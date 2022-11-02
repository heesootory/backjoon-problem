import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;
    static List<Integer>[] list;
    static boolean[] party;

//    static void print(){
//        for(int i : queue) System.out.print(i + " ");
//    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       // 사람 수
        M = Integer.parseInt(st.nextToken());       // 파티 수
        visited = new boolean[N+1];
        list = new ArrayList[M];
        party = new boolean[M+1];
        for(int i = 0; i < M; i++) list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++) queue.add(Integer.parseInt(st.nextToken()));

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int par = Integer.parseInt(st.nextToken());
            for(int j = 0; j < par; j++) list[i].add(Integer.parseInt(st.nextToken()));
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            visited[now] = true;

            for(int i = 0; i < M; i++) {
                if (!party[i]) {
                    boolean flag = false;
                    for (int j : list[i]) {
                        if (j == now) {
                            party[i] = true;
                            flag = true;
                        }
                    }
                    if (flag) {
                        for (int j : list[i]) {
                            if (!visited[j]) queue.add(j);
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < M; i++){
            if(!party[i]) cnt++;
        }
        System.out.println(cnt);

    }
}