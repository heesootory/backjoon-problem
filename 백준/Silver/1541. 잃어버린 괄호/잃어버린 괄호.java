import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;


public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] strArr = str.split("\\-|\\+");
        int s = strArr.length;
        int[] numList = new int[s];
        int[] codeList = new int[s - 1];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < strArr.length; i++){
            numList[i] = Integer.parseInt(strArr[i]);
        }

        for(int i = 0, j = 0; i < str.length(); i++){
            if(str.charAt(i) == '-' || str.charAt(i) == '+'){
                codeList[j++] = str.charAt(i);
            }
        }

        for(int i = numList.length - 1; i > 0; i--) {
            stack.push(numList[i]);

            if (codeList[i - 1] == '+') {
                int a = stack.pop();
                numList[i - 1] += a;
            }
        }

        int ans = numList[0];

        while(!stack.isEmpty()){
            ans -= stack.pop();
        }

        System.out.println(ans);
    }
}

