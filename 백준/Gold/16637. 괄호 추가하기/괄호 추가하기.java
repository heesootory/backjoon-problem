import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num_arr;
    static char[] sign_arr;
    static int max = Integer.MIN_VALUE;

    static int cal(int a, int b, char c){
        switch(c){
            case '+' : return (a + b);
            case '-' : return (a - b);
            default : return (a * b);
        }
    }

    static void dfs(int idx, int sum){
        if(idx == N / 2){
            if(sum > max) max = sum;
            return;
        }

        // 순서대로 계산하면서 넘어가기
        dfs(idx + 1, cal(sum, num_arr[idx+1], sign_arr[idx]));

        // 다음것을 먼저 계산하고 넘어가기
        if(idx + 1 < sign_arr.length){
            int next = cal(num_arr[idx + 1], num_arr[idx + 2], sign_arr[idx + 1]);
            dfs(idx + 2, cal(sum, next, sign_arr[idx]));
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        num_arr = new int[N / 2 + 1];
        sign_arr = new char[N / 2];

        int i = 0;
        int j = 0;
        for(int s = 0; s < str.length(); s++){
            if(s % 2 == 0) num_arr[i++] = (str.charAt(s) - '0');
            else sign_arr[j++] = str.charAt(s);
        }
        dfs(0, num_arr[0]);
        System.out.println(max);
    }
}
