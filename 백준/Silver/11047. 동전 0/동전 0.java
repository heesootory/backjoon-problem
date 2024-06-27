import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;


public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numList = new int[N];

        for(int i = 0; i < N; i++){
            numList[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i = numList.length - 1; i >= 0; i--){
            int num = numList[i];
            if(num <= K){
                cnt += (K / num);
                K %= num;
            }
        }

        System.out.println(cnt);
    }
}

