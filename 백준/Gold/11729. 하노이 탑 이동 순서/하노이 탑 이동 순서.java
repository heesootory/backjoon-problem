import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;

        Hanoi(N, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb);

    }

    static void Hanoi(int N, int from, int mid, int to){

        if(N == 1){
            cnt++;
            sb.append(from + " " + to + "\n");
            return;
        }

        Hanoi(N-1, from, to, mid);

        cnt++;
        sb.append(from + " " + to + "\n");

        Hanoi(N-1, mid, from, to);

    }

}
