import java.io.*;
import java.util.*;

public class Main{
    static int n, m;
    static int[] arr;
    static int partition(int mid){
        int count = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if(max - min > mid){        // 들어가면 안되는 경우
                count++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--;            // 들어가면 안되니까 새로운 구간은 여기서부터 다시 시작.   
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        int low = 0;
        int high = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        while(low <= high){
            int mid = (low + high) / 2;
            int cnt = partition(mid);

            if(cnt > m) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println(low);

    }
}