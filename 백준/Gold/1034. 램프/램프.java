import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static String[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new String[N];

        for(int i = 0; i < N; i++){
            table[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        int ans = 0;

        for(int i = 0; i < N; i++){
            int count = 0;
            int zero_cnt = 0;
            for(int j = 0; j < M; j++){
                if(table[i].charAt(j) == '0') zero_cnt++;
            }

            if(zero_cnt <= K && (zero_cnt % 2 == K % 2)){
                for(int h = i; h < N; h++){
                    if(table[i].equals(table[h])) count++;
                }
                if(count > ans) ans = count;
            }
        }

        System.out.println(ans);

    }
}
