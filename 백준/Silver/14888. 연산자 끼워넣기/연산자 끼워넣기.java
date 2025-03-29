import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] arr;
    static int[] cal;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cal = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int idx, int sum){

        if(idx == N){
            if(sum > max) max = sum;
            if(sum < min) min = sum;
            return;
        }

        for(int i = 0; i < 4; i++){
            if(cal[i] == 0) continue;

            switch(i){
                case 0: cal[0]--;
                        dfs(idx + 1, sum + arr[idx]);
                        cal[0]++;
                    break;
                case 1: cal[1]--;
                        dfs(idx + 1, sum - arr[idx]);
                        cal[1]++;
                    break;
                case 2: cal[2]--;
                        dfs(idx + 1, sum * arr[idx]);
                        cal[2]++;
                    break;
                case 3: cal[3]--;
                        dfs(idx + 1, sum / arr[idx]);
                        cal[3]++;
                    break;
            }


        }

    }

}
