import java.io.*;
import java.util.*;



public class Main{
    static int N;
    static int[] arr;

    static int[] cntArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cntArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i > 0) cntArr[i] = (arr[i - 1] > arr[i]) ? cntArr[i - 1] +1 : cntArr[i - 1];
        }

        int Q = Integer.parseInt(br.readLine());
        for(int i = 0 ;i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            System.out.println(cntArr[y] - cntArr[x]);
        }
    }
}