import java.io.*;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o){
            return this.x - o.x;
        }

    }

    static int T, N;
    static Pair[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new Pair[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[i] = new Pair(x, y);
            }

            Arrays.sort(arr);
            int norm = arr[0].y;
            int cnt = 1;
            for(int i = 0; i < N; i++){
                if(arr[i].y < norm){
                    norm = arr[i].y;
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}