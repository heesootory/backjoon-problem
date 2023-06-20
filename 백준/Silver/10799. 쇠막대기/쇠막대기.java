import java.util.*;
import java.io.*;


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();
        int stick = 0;
        int sum = 0;

        for(int i = 0; i < str.length(); i++){
            switch(str.charAt(i)){
                case '(':
                    if(str.charAt(i+1) == '(') stick++;
                    break;
                case ')':
                    if(str.charAt(i-1) == '(') sum += stick;
                    else {
                        stick--;
                        sum++;
                    }
                    break;
            }
        }
        System.out.println(sum);

    }
}