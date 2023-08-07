import java.io.*;
import java.util.*;

/**
 * 오른쪽에 자기 보다 낮은 빌딩의 갯수? => 왼쪽에 자기 보다 큰 빌딩의 갯수
 */


public class Main{
    static int N;
    static int[] arr;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        stack = new Stack<>();
        long sum = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            stack.push(arr[i]);
            sum += (stack.size() - 1);
        }

        System.out.println(sum);
    }
}