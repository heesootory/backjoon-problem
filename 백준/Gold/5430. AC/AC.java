import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int T;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        loop : for(int t = 0; t < T; t++){
            deque = new LinkedList<>();

            String methods = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String num_arr = br.readLine();

            // 문자열 나누기.
            StringTokenizer st = new StringTokenizer(num_arr, "[],");
            for(int i = 0; i < num; i++){
                int j = Integer.parseInt(st.nextToken());
                deque.add(j);
            }

            // 1이면 앞쪽, -1이면 뒤쪽.
            int order = 1;

            // 함수 호출
            for(int i = 0; i < methods.length(); i++){
                char c = methods.charAt(i);
                if(c == 'R') order *= -1;
                else {
                    if(deque.size() == 0){
                        System.out.println("error");
                        continue loop;
                    }
                    else{
                        int j = (order == 1) ? deque.poll() : deque.pollLast();
                    }
                }
            }

            // 출력
            int len = deque.size();
            int[] ans = new int[len];
            if(order == 1){
                for(int i = 0; i < len; i++) ans[i] = deque.poll();
            }else{
                for(int i = 0; i < len; i++) ans[i] = deque.pollLast();
            }

            System.out.print("[");
            if(ans.length > 0){
                for(int i = 0; i < ans.length - 1; i++) System.out.print(ans[i] + ",");
                System.out.print(ans[ans.length - 1]);
            }
            System.out.println("]");
        }


    }
}
