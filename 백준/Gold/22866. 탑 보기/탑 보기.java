import java.io.*;
import java.util.*;

class Node{
    int num, height, cnt;
    int min_num = Integer.MAX_VALUE;
    Node(int num, int height){
        this.num = num;
        this.height = height;
    }
}

public class Main {
    static int N;
    static Node[] arr;
    static Stack<Node> stack1;
    static Stack<Node> stack2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new Node[N];
        for(int i = 0; i < N; i++){
            arr[i] = new Node(i+1, Integer.parseInt(st.nextToken()));
        }

        stack1 = new Stack<>();
        stack2 = new Stack<>();

        /**
         * 오른쪽 보기
         */

        for(int i = 0; i < N; i++){

            while(!stack1.isEmpty() && arr[i].height >= stack1.peek().height) stack1.pop();

            arr[i].cnt += stack1.size();

            if(!stack1.isEmpty()){
                int diff = Math.abs(stack1.peek().num - arr[i].num);
                int ori_diff = Math.abs(arr[i].min_num - arr[i].num);
                if(diff < ori_diff) arr[i].min_num = stack1.peek().num;
                else if(diff == ori_diff)
                    arr[i].min_num = Math.min(arr[i].min_num, stack1.peek().num);
            }

            stack1.push(arr[i]);
        }


        /**
         * 왼쪽 보기
         */

        for(int i = N-1; i >= 0; i--){
            while(!stack2.isEmpty() && arr[i].height >= stack2.peek().height) stack2.pop();

            arr[i].cnt += stack2.size();

            if(!stack2.isEmpty()){
                int diff = Math.abs(stack2.peek().num - arr[i].num);
                int ori_diff = Math.abs(arr[i].min_num - arr[i].num);
                if(diff < ori_diff) arr[i].min_num = stack2.peek().num;
                else if(diff == ori_diff)
                    arr[i].min_num = Math.min(arr[i].min_num, stack2.peek().num);
            }

            stack2.push(arr[i]);
        }


        /**
         * 출력
         */
        StringBuilder sb = new StringBuilder();
        for(Node n : arr){
            sb.append(n.cnt);
            if(n.cnt != 0) sb.append(" ").append(n.min_num);
            sb.append("\n");
        }
        System.out.println(sb);

    }

}
