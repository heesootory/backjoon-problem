import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];
        int[] cntArr = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cntArr[arr[i]]++;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && cntArr[arr[stack.peek()]] < cntArr[arr[i]]){
                int idx = stack.pop();
                ans[idx] = arr[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            ans[idx] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : ans) sb.append(i).append(" ");
        System.out.println(sb);

    }
}
