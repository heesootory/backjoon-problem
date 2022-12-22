import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static boolean[] button;
    static int ans = Integer.MAX_VALUE;

    static void dfs(int idx, int channel){
        if(idx != 0){
            int cnt = Math.abs(channel - N) + idx;
            ans = Math.min(ans, cnt);
        }

        if(idx == 6) return;

        for(int i = 0; i < 10; i++){
            if(button[i]){
                dfs(idx + 1, channel * 10 + i);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        button = new boolean[10];
        Arrays.fill(button, true);

        if(M > 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < M; i++) button[Integer.parseInt(st.nextToken())] = false;
        }

        ans = Math.min(Math.abs(100 - N), ans);
        dfs(0, 0);
        System.out.println(ans);
    }
}