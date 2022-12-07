import java.io.*;
import java.util.*;

public class Main {
    static boolean[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        arr = new boolean[31];

        for(int i = 0; i < 28; i++){
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            arr[j] = true;
        }


        for(int i = 1; i < arr.length; i++){
            if(!arr[i]) sb.append(i + "\n");
        }
        System.out.println(sb);

    }
}