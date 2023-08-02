import java.io.*;
import java.util.*;

public class Main{

    String ans = "";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String check = br.readLine();
        char c = check.charAt(0);
        int len = check.length();
        Stack<Character> stack = new Stack<>();

        for(int i = str.length() - 1; i >= 0; i--){
            stack.push(str.charAt(i));

            if(str.charAt(i) == c && stack.size() >= len){
                boolean flag = false;
                int j = 0;
                for(;j < len; j++){
                    if(stack.peek() != check.charAt(j)){
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
                if(flag){
                    for(int k = j - 1; k >= 0; k--){
                        stack.push(check.charAt(k));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) System.out.println("FRULA");
        else{
            while(!stack.isEmpty()) sb.append(stack.pop());
            System.out.println(sb);
        }

    }
}