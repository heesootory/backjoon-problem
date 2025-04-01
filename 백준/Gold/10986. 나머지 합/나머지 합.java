import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] arr, remainArr, cntArr;
    static long[] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];           // 주어진 배열.
        sumArr = new long[N + 1];        // 합배열.
        remainArr = new int[N + 1];     // 합배열을 M으로 나눈 나머지 배열.
        cntArr = new int[M];        // M으로 나눈 나머지가 같은 것들의 갯수 배열.

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        for(int i = 1; i < N + 1; i++){
            sumArr[i] = sumArr[i-1] + arr[i];
            remainArr[i] = (int)(sumArr[i] % M);
            cntArr[remainArr[i]]++;

            if(remainArr[i] == 0) ans++;           // 0~n 의 총합이 M으로 나누어 떨어지는 경우 체크.
        }

        // 나머지가 같은 곳을 처음과 끝으로 지정해 총합이 M으로 나누어 떨어지는 경우 체크 -> 결국 조합.
        for(int i : cntArr){
            ans += ((long)i * (i - 1) / 2);
        }

        System.out.println(ans);
    }

}

