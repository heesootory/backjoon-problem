import java.util.*;
import java.io.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int N;
    static int cnt;
    static int[] arr;

    static void dfs(int idx){
        if(idx == N){
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            arr[idx] = i;
            boolean flag = false;
            for(int j = 0; j < idx; j++){
                if((Math.abs(idx - j) == Math.abs(arr[idx] - arr[j])) || arr[idx] == arr[j]){
                    flag = true; break;
                }
            }
            if(flag) continue;
            dfs(idx + 1);
        }

    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dfs(0);
        System.out.println(cnt);

    }
}