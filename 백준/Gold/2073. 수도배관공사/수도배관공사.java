import java.io.*;
import java.util.*;

public class Main {
    static class Pipe implements Comparable<Pipe>{
        int L, C;

        Pipe(int L, int C){
            this.L = L;
            this.C = C;
        }

        /**
         * 파이프 배열의 오름차순 정렬
         * L(파이프의 길이)를 중심으로 오름차순,
         * 단, L이 같을 경우, C(파이프의 용량)을 기준으로 오름차순.
         */
        @Override
        public int compareTo(Pipe O){
            if(O.L == this.L) return this.C - O.C;
            else return this.L - O.L;
        }
    }
    static int D, P;
    static Pipe[] arr;      // 파이프 배열
    static int[][] dp;      // dp 테이블

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        arr = new Pipe[P + 1];
        dp = new int[P + 1][D + 1];
        arr[0] = new Pipe(0,0);     // arr(파이프배열)의 오름차순을 위해 임의의로 넣어주기

        for(int i = 1; i < P + 1; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = new Pipe(l, c);
        }
        Arrays.sort(arr);

        dp[0][0] = Integer.MAX_VALUE;
        for(int i = 1; i < P + 1; i++){
            for(int j = 0; j < D + 1; j++){
                if(j == 0) dp[i][j] = Integer.MAX_VALUE;        // 0열은 항상 최대 수로 선택되어지지 않게 설정.
                else if(j < arr[i].L) dp[i][j] = dp[i-1][j];        // 추가된 파이프의 길이보다 짧은 열은 dp테이블의 이전 행과 같은 수로 구성.
                else dp[i][j] = Math.max(Math.min(dp[i-1][j - arr[i].L], arr[i].C), dp[i-1][j]);
                // dp테이블 정의 : 구성할 수 있는 파이프들의 최소값과 이전의 완성된 길이 중, 최댓값이 갱신.
            }
        }

        System.out.println(dp[P][D]);
    }
}