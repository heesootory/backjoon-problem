import java.io.*;
import java.util.*;



public class Main{
    static int N;
    static int[] arr;
    static int ans1, ans2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int ans = Integer.MAX_VALUE;

        while(left < right){
            int diff = Math.abs(arr[left] + arr[right]);
            if(diff < ans){
                ans = diff;
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if(arr[left] +arr[right] > 0) right--;
            else left++;
        }

        System.out.println(ans1 + " " + ans2);

    }
}