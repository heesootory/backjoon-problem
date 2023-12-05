import java.util.*;
import java.io.*;


public class Main{
    static int A, B;
    static int ans;
    static void makeNum(int[] num, int n, int idx){
        if(idx == n){
            int norm = 1;
            int sum = 0;
            for(int i = n - 1; i >= 0; i--){
                sum += (num[i] * norm);
                norm *= 10;
            }
            if(A <= sum && sum <= B) ans++;
            return;
        }

        num[idx] = 4;
        makeNum(num, n, idx + 1);
        num[idx] = 7;
        makeNum(num, n, idx + 1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for(int i = 1; i < 10; i++){
            int[] num = new int[i];
            makeNum(num, i, 0);
        }

        System.out.println(ans);
    }
}