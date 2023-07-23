import java.io.*;
import java.util.*;


class Node{
    int num, weight;
    Node(int num, int weight){
        this.num = num;
        this.weight = weight;
    }
}

public class Main {
    static int N, R;
    static int column, branch;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static void findBranchLength(int g, int b){
        int len = list[g].size();
        int cnt = 0;
        for(int i = 0; i < len; i++) {
            if(!visited[list[g].get(i).num]) cnt++;
        }

        if(cnt == 0){
            if(b > branch) branch = b;
            return;
        }

        for(int i = 0; i < len; i++){
            if(visited[list[g].get(i).num]) continue;

            visited[list[g].get(i).num] = true;
            findBranchLength(list[g].get(i).num, b + list[g].get(i).weight);
            visited[list[g].get(i).num] = false;
        }
    }
    static void findColumn(int idx, int s){
        int len = list[s].size();
        if((idx == 0 && len >= 2) || (idx != 0 && len >= 3)) {
            // 기가노드 시작
            findBranchLength(s, 0);
            return;
        }

        for(int i = 0; i < len; i++){
            if(visited[list[s].get(i).num]) continue;

            column += list[s].get(i).weight;
            visited[list[s].get(i).num] = true;
            findColumn(idx + 1, list[s].get(i).num);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, w));
            list[end].add(new Node(start, w));
        }

        visited[R] = true;
        findColumn(0, R);

        System.out.println(column +  " " + branch);
    }

}
