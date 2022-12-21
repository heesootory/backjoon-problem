import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    static List<Long> list  = new ArrayList<>();

    static void dfs(int idx, long num){
        // 기저조건 직전 - 리스트에 없다면 삽입.
        if(!list.contains(num)) list.add(num);

        // 기저
        if(idx >= 10) return;

        // 부분집합과 동일 -> 수를 고르냐 안고르냐
        dfs(idx + 1, (num*10)+arr[idx]);      // 선택하여 더해줌.
        dfs(idx + 1, num);          // 안선택하고 넘어감.
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dfs(0,0);
        Collections.sort(list);
//        for(int i = 0; i < 30; i++){
//            System.out.print(list.get(i) + " ");
//        }
        try{
            System.out.println(list.get(N-1));
        }catch(Exception e){
            System.out.println(-1);
        }
    }
}