import java.io.*;
import java.util.*;

public class Main {
    static class Pipe implements Comparable<Pipe>{
        int L, C;

        Pipe(int L, int C){
            this.L = L;
            this.C = C;
        }

        @Override
        public int compareTo(Pipe O){
            if(O.L == this.L) return this.C - O.C;
            else return this.L - O.L;
        }
    }
    static int D, P;
    static Pipe[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        arr = new Pipe[P + 1];
        dp = new int[P + 1][D + 1];
        arr[0] = new Pipe(0,0);

        for(int i = 1; i < P + 1; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = new Pipe(l, c);
        }
        Arrays.sort(arr);
//        for(Pipe p: arr) System.out.println(p.L + " " + p.C);

        dp[0][0] = Integer.MAX_VALUE;
        for(int i = 1; i < P + 1; i++){
            for(int j = 0; j < D + 1; j++){
                if(j == 0) dp[i][j] = Integer.MAX_VALUE;
                else if(j < arr[i].L) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(Math.min(dp[i-1][j - arr[i].L], arr[i].C), dp[i-1][j]);
            }
        }

//        for(int i = 0; i < P + 1; i++){
//            for(int j = 0; j < D + 1; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[P][D]);
    }
}