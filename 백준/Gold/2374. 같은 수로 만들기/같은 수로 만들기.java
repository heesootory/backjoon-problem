import java.io.*;
import java.util.*;



public class Main {
    static int N, max, maxIdx;
    static long cnt;
    static int[] arr;
    static Stack<Integer> leftStack;
    static Stack<Integer> rightStack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 2];
        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        arr[N + 1] = max;

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < N + 2; i++){
            min = Math.min(min, arr[i]);
            // 여태까지 나온 최댓값보다 큰수가 나왔을때, 작업 시작!
            if(i != 1 && arr[i-1] <= arr[i]){
                cnt += (arr[i] - min);      // 카운트에 차이 만큼 더함
                for(int j = i; j >= 1; j--) arr[j] = arr[i];   // 이전으로 돌아가면서 방금 만난 최댓값으로 갱신
                min = arr[i];         // i 앞의 값들은 모두 arr[i]로 갱신했으므로, 최솟값 = 최댓값 = arr[i]
            }
//            System.out.println("인덱스 : " + i);
//            System.out.println(Arrays.toString(arr));
//            System.out.println(cnt);
        }

        System.out.println(cnt);
    }
}
