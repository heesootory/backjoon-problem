import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int idx = stack.pop();
                ans[idx] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) ans[stack.pop()] = -1;
        StringBuilder sb = new StringBuilder();
        for(int i : ans) sb.append(i).append(" ");
        System.out.println(sb);
    }

}
