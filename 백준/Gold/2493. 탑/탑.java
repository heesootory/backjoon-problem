import java.awt.*;
import java.io.*;
import java.util.*;

class Top{
    int height, num;
    public Top(int height, int num){
        this.height = height;
        this.num = num;
    }
}

public class Main {
    static int N;
    static Stack<Top> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int top_height = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Top(top_height, i));
            }
            else{
                while(true){
                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(new Top(top_height, i));
                        break;
                    }

                    if(stack.peek().height > top_height){
                        sb.append(stack.peek().num + " ");
                        stack.push(new Top(top_height, i));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb);

    }

}
