import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {
    static int N, q;
    static int[] countArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        countArr = new int[N + 1];

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            countArr[a]++; countArr[b]++;
        }

        q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(t == 1) System.out.println((countArr[k] == 1) ? "no" : "yes");
            else System.out.println("yes");
        }


    }

}
