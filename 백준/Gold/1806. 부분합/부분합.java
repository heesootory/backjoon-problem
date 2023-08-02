import java.io.*;
import java.util.*;

public class Main{
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(i <= j){
            if(sum < s){
                if(j >= n) break;
                sum += arr[j];
                j++;
            }else{
                if(j - i < ans) ans = j - i;
                if(i == j) break;
                sum -= arr[i];
                i++;
            }

        }

        System.out.println((ans == Integer.MAX_VALUE) ? 0 : ans);

    }
}