import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static Map<Integer, Integer> map;
    static int[] arr;
    static int[] ansArr;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        stack = new Stack<>();
        arr = new int[n];
        ansArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if(map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        for(int i = 0; i < n; i++){
            if(stack.isEmpty()) stack.push(i);
            else{
                while(map.get(arr[stack.peek()]) < map.get(arr[i])){
                    ansArr[stack.pop()] = arr[i];
                    if(stack.isEmpty()) break;
                }

                stack.push(i);
            }
        }

        while(!stack.isEmpty()) ansArr[stack.pop()] = -1;
        StringBuilder sb = new StringBuilder();
        for(int i : ansArr) sb.append(i).append(" ");
        System.out.println(sb);



    }
}