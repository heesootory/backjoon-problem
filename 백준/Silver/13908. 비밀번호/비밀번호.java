import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static boolean[] visited;
    static int count;
    static void dfs(int idx, int cnt){
        if(idx == n){
            if(cnt == m) count++;
            return;
        }

        for(int i = 0 ; i < 10; i++){
            if(visited[i]){
                visited[i] = false;
                dfs(idx + 1, cnt + 1);
                visited[i] = true;
            }
            else dfs(idx + 1, cnt);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if(m != 0) st = new StringTokenizer(br.readLine());
        visited = new boolean[10];
        for(int i = 0 ; i < m; i++) {
            visited[Integer.parseInt(st.nextToken())] = true;
        }

        dfs(0, 0);
        System.out.println(count);
    }
}




