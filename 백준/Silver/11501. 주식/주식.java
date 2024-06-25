import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sell = 0;
            long profit = 0;
            boolean plus = false;
            for(int i = N - 2; i >= 0; i--){
               if(plus){
                   if(arr[i] > sell) plus = false;
                   else profit += (sell - arr[i]);
               }else{
                    if(arr[i] < arr[i + 1]) {
                        sell = arr[i + 1];
                        profit += (sell - arr[i]);
                        plus = true;
                    }
               }
            }
            System.out.println(profit);
        }

    }
}

