import java.util.*;
import java.io.*;


public class Main{
    static int N;
    static int[] score;
    static int[] sumArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        score = new int[N + 1];
        sumArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = (score[i - 1] > score[i]) ? sumArr[i - 1] + 1 : sumArr[i - 1];
        }

        int Q = Integer.parseInt(br.readLine());

        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            System.out.println(sumArr[to] - sumArr[from]);

        }
    }

}