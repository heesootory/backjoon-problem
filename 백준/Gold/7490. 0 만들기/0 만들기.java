import java.io.*;
import java.util.*;


public class Main {
    static int N, end;
    static int[] nums;

    static boolean cal(String str){
        int sum = 0, mid = 0, op = 1;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '+'){
                sum += (mid * op);
                mid = 0;
                op = 1;
            }
            else if(c == '-'){
                sum += (mid * op);
                mid = 0;
                op = -1;
            }
            else if(c == ' '){
                mid *= 10;
            }
            else{
                mid += (c - '0');
            }
        }
        sum += (mid * op);
//        System.out.println(sum);
        return sum == 0;
    }

    static void dfs(int idx, String str){
        if(idx == end){
            if(cal(str)) System.out.println(str);
            return;
        }

        dfs(idx + 1, str + " " + idx);
        dfs(idx + 1, str + "+" + idx);
        dfs(idx + 1, str + "-" + idx);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for(int i = 0 ; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            end = nums[i] + 1;
            dfs(2,  "1");
            System.out.println();
        }

//        System.out.println(cal("1-2 3-4 5+6 7"));
    }
}